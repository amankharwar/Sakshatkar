/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author amank
 */
public class StartApproval implements  Runnable{
    
    ObjectOutputStream oos = null;
    ObjectInputStream ooi = null;
    String username = "";
    String from = "";
    Clientreceiver cr;
    public StartApproval( ObjectOutputStream os , ObjectInputStream is, String from , String username,Clientreceiver c) {
        
        oos = os;
        ooi = is;
        cr=c;
        this.from = from;
        this.username = username;
    }

    @Override
    public void run() {
        
         Approval av;
        try {
            av = new Approval(oos,ooi,from,username,cr);
             av.friendname.setText(from);
          av.setVisible(true);
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StartApproval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(StartApproval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(StartApproval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(StartApproval.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
        
        
        
    }
    
    
    
    
}
