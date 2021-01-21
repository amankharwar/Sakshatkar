
package Client;

import Common.AudioPacket;
import Common.CallCut;
import Common.TargetName;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import sun.misc.IOUtils;

public class Audiosender extends Thread{

    Clientreceiver cr = null;
    Socket socket = null; 
    
    ObjectOutputStream oos = null;
    
    public Audiosender(Clientreceiver c) {
        
        cr = c;
       oos = c.oos2;
        
    }
    
    public  boolean exit = false;
    
    
    public void run()
    {
        
      
        
        
        TargetName tn = new TargetName(cr.to);
        try {
            oos.writeObject(tn);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Audiosender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //--------------------code for sending audio -----------------
        
        
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

        // AudioFormat format = new AudioFormat( 44100, 16 , 2 , true , true);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format, 44100);
        if (!AudioSystem.isLineSupported(info)) {
            System.err.println("Line not supported");
        }

        try (TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info)) {
            targetLine.open();

            System.out.println("starting recording");
            targetLine.start();
         
            try {

                byte da[] = new byte[10000];

                Clip clip;

                while (!exit) {

                    targetLine.read(da, 0, 10000);

                    System.out.println("Sending file to client....");

                    AudioPacket ap = new AudioPacket(da);

                    oos.writeObject(ap);
                    oos.flush();

                    Thread.sleep(100);

                }

            } catch (Exception ex) {
            }
            System.out.println("Stopped Recording.. ");

        } catch (Exception e) {
            System.out.println("Problem in try block....");
        }
        
        try {
            oos.writeObject(new CallCut());
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Audiosender.class.getName()).log(Level.SEVERE, null, ex);
        }

         System.out.println("Audio Sender has ended...."); 
        
    }
    
    
    public void close()
    {
        exit = true;
    }
    
}
