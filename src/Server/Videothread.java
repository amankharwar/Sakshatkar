
package Server;

import Common.CallCut;
import Common.TargetName;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Videothread extends Thread{
  Serverfile server;
  Clienthandler cr  = null;
  String username="";
    ObjectOutputStream oos = null;
  ObjectInputStream ois=null;
  
  public Videothread(Serverfile s , Clienthandler cr , String user)
  {
      server=s;
      this.cr = cr;
      username = user;
      ois = cr.ooi1;
  }
    public void run()
    {
        
        while(true )
        {
            Object obj=null;
            try {
                obj = ois.readObject();
                 System.out.println("Receiving obj in videothread....."); 
            } catch (Exception ex) {
                 System.out.println("Video Thread closed..." + ex); 
                 break;
            }
            
            if(obj instanceof ImageIcon)
            {
                System.out.println("Object is of instance type in videothread  and actually it should be of targetUser.....");
                continue;
            }
            
            TargetName tn = (TargetName)obj;
            
            String targetname= tn.getTargetname();
            
            oos = server.userthread.get(targetname).oos1;
            
            while(true )
            {
                
                Object imgobj = null;
                try {
                    
                    
                    imgobj= ois.readObject();
                    
                     System.out.println("Receiving imgobj in videotrhread..."); 
                    
                    if(imgobj instanceof  CallCut)
                    {
                        oos.writeObject(imgobj);
                        System.out.println("call cut in video thread....");
                        break;
                        
                    }
                    else {
                    
                     System.out.println("Writing image to another client...."); 
                    oos.writeObject(imgobj);
                    oos.flush();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Videothread.class.getName()).log(Level.SEVERE, null, ex);
                    //break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Videothread.class.getName()).log(Level.SEVERE, null, ex);
                    //break;
                }
                
                
                
            }
            
            
        }
     
        
    }
    
}


//while(true)
//first read client name
//put while(true)
//start reading image object
//then simulatenously send that received obect data to client output stream
//server.userthread.get(clientame).oos1
//write all data on above output stream
//