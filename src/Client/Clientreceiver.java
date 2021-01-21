
package Client;


import Common.Request;
import Common.Response;
import Common.Systeminfo;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Clientreceiver extends  Thread{
    
    ObjectOutputStream oos = null;
    ObjectInputStream ooi = null;
    ObjectOutputStream oos1 = null ;
    ObjectInputStream ooi1 = null ;
    ObjectOutputStream oos2  = null ;
    ObjectInputStream ooi2  = null ;
    String username = "";
    Videowindow video=null;
    
    Login login;
    String to;
    Socket audioSocket ;
    
    
    public boolean exit = false;
    
    public Clientreceiver( ObjectOutputStream os , ObjectInputStream is , String name , ObjectOutputStream os1 , ObjectInputStream is1 , ObjectOutputStream os2 , ObjectInputStream is2 , Login l)
    {
        oos = os;
        ooi = is;
        oos1 = os1;
        ooi1 = is1;
        oos2 = os2;
        ooi2 = is2;
        login = l;
        username = name;
    }
    
    
    public void run()
    {
        Object obj = null;
       
        while(!exit )
        {
             System.out.println("value of exit : " + exit); 
             if(exit)
             {
                 break;
             }
            try {
                obj = null;
                obj = ooi.readObject();
            } catch (Exception ex) {
                 System.out.println("ClientReceiver closed... and ooi is also closed..." + ex); 
                 break;
                
            }
            if(obj instanceof  Response)
            {
                Response res = (Response)obj;
                if(res.status)
                {
                     System.out.println("Request accepted..."); 
                     //cr=this;
                      to = res.from;
                     Thread t = new Thread(new StartVideoWindow(this));
                     t.start();
                     
                     
                }
                
                else{
                    
                    JOptionPane.showMessageDialog(null, "Request was declined...");
                }
                
                //ooi.flush();
            }
            
            else if(obj instanceof  Request)
            {
                
                Request q = (Request)obj;
                
                String from = q.from;
                
                 System.out.println(" Received request from : " + from + " in clientreceiver..."); 
                
                // av.friendname.setText(from);
                //av.setVisible(true);
                //cr=this;
                //cr.to=q.from;
                to = q.from;
                Thread t = new Thread(new StartApproval( oos , ooi , from , username, this));
                t.start();
                
            }
            
            else if(obj instanceof Systeminfo)
            {
                video.cut();
                System.out.println("egnksjdhkvjbkjsdb sduhfguk");
                video=null;
                
            }
            
           
            
            
        }
        
        try {
            login.close();
        } catch (IOException ex) {
            Logger.getLogger(Clientreceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
         System.out.println("ClientReceiver has stopped..."); 
        
    }
    
    
    public void close() throws IOException
    {
        
         System.out.println("Setting exit value true......."); 
         ooi.close();
        exit = true;
        
        
    }
    
    
    
}
