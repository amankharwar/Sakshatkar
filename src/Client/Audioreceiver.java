package Client;

import Common.AudioPacket;
import Common.CallCut;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import jdk.internal.util.xml.impl.Input;

public class Audioreceiver extends Thread{
    
    Clientreceiver cr = null;
    ObjectInputStream ois = null;
    Socket socket = null;
    
    
    public Audioreceiver(Clientreceiver c) {
        
        this.cr = c;
        ois = cr.ooi2;
        
    }
    
    
    public boolean  exit = false;
    
    
    public void run()
    {
        Clip clip =  null;
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        
        while(true)
        {
            Object obj = null ;
            
            
            try {
                obj = ois.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Audioreceiver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Audioreceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if(obj!= null )
            {
                
                if(obj instanceof  CallCut)
                {
                     System.out.println("Audio Receiver has ended after receiving callcut object ...."); 
                     break;
                }
                
                else if(obj instanceof  AudioPacket)
                {
                    
                    try {
                        clip = AudioSystem.getClip();
                        
                        AudioPacket ap = (AudioPacket)obj;
                        clip.open(format, ap.b, 0, 10000);
                        clip.start();
                        
                        
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Audioreceiver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
                
                
                
            }
                    
            
        }
        
         System.out.println("Audio Receiver has ended....."); 
        
        
        
    }
    
   


    
}
