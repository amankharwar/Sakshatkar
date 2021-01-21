/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.AudioPacket;
import Common.CallCut;
import Common.TargetName;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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

public class Audiothread extends Thread {
    Serverfile server; 
    Clienthandler cr = null;
    String username="";
    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    
    
    public Audiothread(Serverfile s , Clienthandler c , String user)
    {
      server=s;
      this.cr = c;
      username = user;
      ois = c.ooi2;
     
      socket = cr.audioSocket;
      
    }
    
    
    public void run()
    {
        
        while(true )
        {
        
        Object obj = null;

        try {
            obj = ois.readObject();

        } catch (Exception ex) {
            System.out.println("Audio Thread closed...."); 
            break;
        }
       
        TargetName tn = (TargetName) obj;

        String name = tn.getTargetname();

               
        ObjectOutputStream oos = server.userthread.get(name).oos2;
       
        
        while(true )
        {
            Object audobj = null;
            
            try {
                audobj = ois.readObject() ;
                
                if(audobj instanceof  CallCut)
                {
                    oos.writeObject(audobj);
                     System.out.println("Received callcut in audio thread..."); 
                     oos.flush();
                    break;
                }
                
                else if(audobj instanceof  AudioPacket)
                {
                    
                    oos.writeObject(audobj);
                     System.out.println("Writing audio packet to target client...."); 
                    oos.flush();
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(Audiothread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Audiothread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
        
         System.out.println("Out of interior while loop in audiothread...."); 

        }
        
        
        
    }
    
    
    
      /* public void run()
    {
        
        
        InputStream in = null ;
        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Audiothread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true )
        {
        DataInputStream din = new DataInputStream(in );
        
        try {
            String targetname = din.readUTF();
            
             System.out.println("Targetname : " + targetname); 
            
            Socket targetSocket = server.userthread.get(targetname).audioSocket;
            AudioFormat format = new AudioFormat(44100, 16, 2, true, true);

            OutputStream out = targetSocket.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(in);
            
            Clip clip = AudioSystem.getClip();
            
            while(true )
            {
                 AudioInputStream ais = null;
                
                try {
                    
                    ais = AudioSystem.getAudioInputStream(bis );
                    
                } catch (Exception e) {
                     System.out.println("ais is not audio input stream...."); 
                     DataOutputStream d = new DataOutputStream(out);
                     d.writeUTF("end");
                     break;
                    
                }
               
                
                if(ais instanceof  AudioInputStream)
                {
                    System.out.println("ais is audio input stream....."); 
                }
                
                else{
                     System.out.println("ais is not audio input stream...."); 
                     DataOutputStream d = new DataOutputStream(out);
                     d.writeUTF("end");
                     break;
                }
                
                 AudioInputStream as = new AudioInputStream(ais , format ,  4096);
               // AudioInputStream ais = AudioSystem.getAudioInputStream(in );
               
              // clip.open(ais);
               //clip.start();
               
               
               
                AudioSystem.write(as, AudioFileFormat.Type.WAVE, out);
                
                 System.out.println("size fo audio input stream : "+ as.getFrameLength()); 
                
            }
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Audiothread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        
        
        
    }*/
    
    
    

}
