package Server;
import Common.*;
import java.io.*;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Clienthandler extends Thread {

    ObjectInputStream ooi;
    ObjectOutputStream oos;
    String username;
    String pass;
    Serverfile server;
    Socket ss;
     ObjectInputStream ooi1;
    ObjectOutputStream oos1;
     ObjectInputStream ooi2;
    ObjectOutputStream oos2;
    
    public Socket audioSocket = null;
    
    Videothread v = null;
    
    Audiothread audio = null;
    
    public Clienthandler(ObjectOutputStream o,ObjectInputStream  i,Serverfile s,Socket t , ObjectOutputStream os1 , ObjectInputStream is1, ObjectOutputStream os2 , ObjectInputStream is2)
    {
       oos=o;
       ooi=i;
       server=s;
       ss=t;
       
       ooi1 = is1;
       oos1 = os1;
       ooi2 = is2;
       oos2 = os2;
    }
   
    public void run() {
        Object obj = null;
        
         System.out.println("Client Handler started...."); 
      
        

        while (true) {

            try {
                obj = ooi.readObject();    //reading object from client
            } catch (IOException ex) {
                Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (obj instanceof User) {
                User u = (User) obj;
                username = u.username;
                pass = u.password;

                try {
                    if (authenticate()) {
                      /*  try {
                            oos.writeObject(new Authenticate(true));
                        } catch (IOException ex) {
                            Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        while (true) {
                            try {
                                obj = null;
                                obj = ooi.readObject();
                                  
                            } catch (IOException ex) {
                                Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                                break;
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                                break;
                            }

                            if (obj instanceof Request) {
                                Request q = (Request) obj;
                                String from, to;
                                from = q.from;
                                to = q.to;
                                
                                  System.out.println( "Got request from " + from + " to : " + to ); 
                                
                                if (server.currentstatus.containsKey(to) || server.currentstatus.containsKey(from) || !(server.Activelist.containsKey(to))) {
                                    Response res = new Response(to, from, false);
                                    try {
                                        oos.writeObject(res);
                                        oos.flush();
                                    } catch (IOException ex) {
                                        Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    Clienthandler temp = server.userthread.get(to);
                                    try {
                                        temp.oos.writeObject(q);
                                       temp.oos.flush();
                                    } catch (IOException ex) {
                                        Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            } else if (obj instanceof Response) {
                                Response q = (Response) obj;
                                String from, to;
                                from = q.from;
                                to = q.to;
                                
                                  System.out.println("Response from : " + from + " to : " + to); 
                                
                                Clienthandler temp = null;
                                
                                try{
                                temp = server.userthread.get(to);
                                }
                                
                                catch(Exception e)
                                {
                                     System.out.println("temp " + temp + "         " + e); 
                                }
                                
                                
                                try {
                                    // accept then add to currentstatus to true
                                    if (q.status) {
                                        server.currentstatus.put(to, true);
                                        server.currentstatus.put(from, true);
                                    }
                                    if(temp!=null)
                                    {
                                        temp.oos.writeObject(q);
                                        temp.oos.flush();
                                    }
                                 
                                    
                                    
                                    else{
                                     
                                         System.out.println("Temp is null..."); 
                                    }
                                    
                                    
                                    oos.flush();
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } 
                            else if (obj instanceof Systeminfo) {
                                
                                Systeminfo s=(Systeminfo)obj;
                                
                                if(s.l==1)
                                    break;
                                else
                                {
                                     //remove from currentstatus
                                     // call cut 
                                    System.out.println("call cut from "+s.from+" to "+s.to);
                                    server.currentstatus.remove(s.from);
                                    server.currentstatus.remove(s.to);
                                    Clienthandler temp = null;
                                    
                                    
                                
                                     try{
                                        temp = server.userthread.get(s.to);
                                      }
                                
                                     catch(Exception e)
                                     {
                                     System.out.println("temp " + temp + "         " + e); 
                                     }
                                     temp.oos.writeObject(new Systeminfo("","",2));
                                     
                                     temp.oos.flush();
                                     
                                }
                            }
                        }
                        // logout()
                        server.Activelist.remove(username);
                        server.userthread.remove(username);
                        break;
                    } 
                } catch (IOException ex) {
                    Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 //break;

            } // obj instanceof user ends.....
            
            else if( obj instanceof SignupInfo ) {
                
                String name = ((SignupInfo) obj).username;
                String pass = ((SignupInfo) obj).pass;
                
                 System.out.println(name + "  " + pass); 
                 
                 if(server.database.containsKey(name))
                 {
                    try {
                        oos.writeObject(new Registration(false));
                        oos.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                else
                 {
                     
                     
                    try {
                        setCredentials(obj );
                    } catch (Exception ex) {
                        Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                     server.database.put(name, pass);
                      try {
                        oos.writeObject(new Registration(true));
                        oos.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Clienthandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                
                
                
            }
            
            

        }

    }
    
    
    
    void setCredentials( Object obj ) throws SQLException
    {
        
        SignupInfo signup  = (SignupInfo)obj;
        
        String fname = signup.fname;
        String lname = signup.lname;
        String user = signup.username;
        String password = signup.pass;
        String email = signup.email;
        
         PreparedStatement ps ;
        String query ="INSERT INTO `credentials`(`u_fname`, `u_lname`, `u_username`, `u_pass`, `u_email`) VALUES (?,?,?,?,?)";
        
         ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, user);
            ps.setString(4, password);
            ps.setString(5, email);
            
            
         if(ps.executeUpdate()>0)            
         System.out.println("user is added successfully..."); 
        
        
    }
   
   
    boolean authenticate() throws IOException
    {

        boolean b = false;

        if (server.database.containsKey(username)) {
            if (server.database.get(username).equals(pass)) {
                server.Activelist.put(username, ss);
                server.userthread.put(username, this);
                b = true;
            } else {
                b = false;
            }

        } else {
            b = false;
        }
        
        if(b)
        {
        
        v = new Videothread(server,this, username);
        
        Thread video = new Thread( v );
        video.start();
        
        
       audio = new Audiothread(server, this,username);
       Thread aud = new Thread( audio );
       aud.start();
        }
        Authenticate au = new Authenticate(b);

        oos.writeObject(au);
        oos.flush();
        return b;

    }
   
 
  
    
    
}
