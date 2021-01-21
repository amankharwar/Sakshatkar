package Client;

import Common.CallCut;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class VideoReceiver extends Thread {
    Videowindow vw = null;
    Videowindow vid;
    Clientreceiver cr = null;
    
    ObjectInputStream ois = null ;

    public boolean exit = false;
    
    public VideoReceiver(Clientreceiver cr ) {
        
        this.cr = cr;
       
        
        ois = cr.ooi1;
        
    }
    
   
    
    public void run() {
        
         Object obj = null;
         
         exit = false;
         
         System.out.println("Starting videoreceiver .....");
        
        while(!exit)
        {
            
             System.out.println("Receiving video from :" + cr.to); 
            
           
            try {
                obj = ois.readObject();
            } catch (IOException ex) {
                Logger.getLogger(VideoReceiver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VideoReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(obj!=null)
            {
            
            if(obj instanceof  CallCut)
            {
             exit = true;
             break;
            }
            else if(obj instanceof   ImageIcon )
            {
            ImageIcon bm = (ImageIcon)obj;
            
            vw.clientvideo.setIcon(bm);
            }
            }
            
            else{
                
                 System.out.println("Video object is null..."+ cr.username); 
            }
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(VideoReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
         System.out.println("VideoReceiver has stopped...."); 
         
         
        
        
    }
    
    public void close()
    {
        exit = true;
    }
    
    
}
