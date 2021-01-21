package Server;
import java.io.*;
import java.net.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Serverfile {

        Hashtable<String,Socket>  Activelist;// logged in
        Hashtable<String,Clienthandler>  userthread; // threads
        Hashtable<String,Boolean> currentstatus;// for call
        static Hashtable<String,String>  database;
        
        
        public static void main(String[] args) throws IOException, InterruptedException, SQLException 
        {
        // connnection;
            
            
        // object for server    
          Serverfile server=new Serverfile();
          server.Activelist=new Hashtable<String,Socket>();
          server.userthread=new Hashtable<String,Clienthandler>();
          server.currentstatus=new Hashtable<String,Boolean>();
          server.database = new Hashtable<>();
          //server.database.put("aman","123");
         // server.database.put("ayush","123");
        // thread for audio and video 
         // Thread t1=new Thread(new Audiothread(server));
         // Thread t2=new Thread(new Videothread(server));
         // t1.start();
         // t2.start();
         
         setDatabase( );
          
          ServerSocket ss=new ServerSocket(7666);
          ServerSocket ss1 = new ServerSocket(7667);
          ServerSocket ss2 = new ServerSocket(7668);
          while(true)
          {
              Socket s = ss.accept();

              Socket s1 = ss1.accept();

              Socket s2 = ss2.accept();

              System.out.println("all socket connected ... in server ....");

              ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

              InputStream in = s.getInputStream();
              ObjectInputStream ooi = new ObjectInputStream(in);

              ObjectOutputStream oos1 = new ObjectOutputStream(s1.getOutputStream());  // oos1 is for video outputstream

              InputStream in1 = s1.getInputStream();
              ObjectInputStream ooi1 = new ObjectInputStream(in1);

              ObjectOutputStream oos2 = new ObjectOutputStream(s2.getOutputStream());
              InputStream in2 = s2.getInputStream();
              ObjectInputStream ooi2 = new ObjectInputStream(in2);


              
               System.out.println("Going to start client handler thread....."); 
               
               
              
               
              Clienthandler cr = new Clienthandler(oos,ooi,server,s , oos1 , ooi1 , oos2, ooi2 );
              Thread t3=new Thread(cr);
              cr.audioSocket = s2;
              t3.start();
          }
        
        
          
          
        }

    public static void setDatabase() throws SQLException {
        
    
         PreparedStatement ps;
         ResultSet rs;
         
         String query = "SELECT u_username, u_pass FROM `credentials`" ;
         
        ps = MyConnection.getConnection().prepareStatement(query);
         
        rs = ps.executeQuery();
        
        String name = "";
        String password = "";
        
        while(rs.next())
        {
            
            name = rs.getString("u_username");
            password = rs.getString("u_pass");
            
            database.put(name, password);
             
             System.out.println("username : " + name + " password : " + password);        
            
        }
        
    
    
    }
        
        
        
    
}
