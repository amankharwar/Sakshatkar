/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author amank
 */
public class StartVideoWindow implements  Runnable{
    
    Clientreceiver cr;
    public StartVideoWindow(Clientreceiver c) {
        cr=c;
    }
    
    
    

    @Override
    public void run() {
        
        Audioreceiver a = null;
        Audiosender b = null;
        VideoReceiver c = null;
        VideoSender d = null;

        

        a = new Audioreceiver(cr);
        b = new Audiosender(cr);
        c = new VideoReceiver(cr );
        d = new VideoSender(cr);
       
       
        
        
        Videowindow vw = new Videowindow(a, b, c, d, cr);
        //
        cr.video = vw;
        vw.clientname.setText(cr.to);
        vw.myname.setText(cr.username);
        
        
       
        a.socket = cr.audioSocket;
        b.socket = cr.audioSocket;
        c.vw = vw;
        d.vw = vw;
        
         Thread t1 = new Thread(a);
        
        Thread t2 = new Thread(b);
        
       
        
         
        Thread t3 = new Thread(c);
       
        Thread t4 = new Thread(d);
        
         t1.start();
        t2.start();
        
        t3.start();
        
        t4.start();
        vw.setVisible(true);
        
        
        
     }
    
}
