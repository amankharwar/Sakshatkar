
package Client;

import Common.CallCut;
import Common.TargetName;
import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class VideoSender extends  Thread{
    Videowindow vid;
    
    Clientreceiver  cr = null;

    ObjectOutputStream oos = null;
    
    Videowindow vw = null;
    
    public VideoSender(Clientreceiver cr ) {
        
        this.cr = cr;
        
        oos = cr.oos1;
        
        
    }
    
   public  boolean  exit = false;
    
   
    
    public void run()
    {
        exit = false;
        Webcam webcam =null;
        try {
            webcam = Webcam.getDefault();
            
           
            // USB Camera 0
            // SplitCam 1
            // ManyCam Virtual Webcam 2

            
           /*  if(cr.username.equals("aman"))
             webcam = Webcam.getWebcamByName("DroidCam Source 3 3");
             
             else
             {
                 webcam = Webcam.getWebcamByName("USB Camera 0");
             }
            
             if(webcam == null)
             {
                  System.out.println("webcam is null : " + cr.username); 
                  
             }
             */
             
            //  Webcam webcam = Webcam.getDefault();
            //webcam.setViewSize(new Dimension(908, 357));
            webcam.setViewSize(new Dimension(640, 480));
            webcam.open();
        } catch (Exception e) {
            System.out.println("Webcam open....");
        }

       
        try {
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(VideoSender.class.getName()).log(Level.SEVERE, null, ex);
        }
            TargetName tn = new TargetName(cr.to);

            try {
                oos.writeObject(tn);
                oos.flush();
            } catch (IOException ex) {
                Logger.getLogger(VideoSender.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedImage bm  = null;
            ImageIcon in = null;
            while(!exit)
            {
                
                 System.out.println("sending Video to "+ cr.to); 
                 //ImageIcon in = null;
                try{
                   bm = webcam.getImage();
                    in = new ImageIcon(bm );
                }catch(Exception e )
                {
                     System.out.println("Problem in getting image.... in video sender...." + e); 
                }
                
                try {
                    if(vw!=null)
                    vw.myvideo.setIcon(in);
                    
                    else{
                         System.out.println("vw is null...."); 
                    }
                    oos.writeObject(in);
                    oos.flush();
                     
                } catch (IOException ex) {
                    Logger.getLogger(VideoSender.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VideoSender.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                
                
            }
            
            
        
        try {
            oos.writeObject(new CallCut());
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(VideoSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webcam.close();
        
         System.out.println("Video Sender has stopped........."); 


    }
    
    
    public void close()
    {
        exit= true;
    }
    
     
}
