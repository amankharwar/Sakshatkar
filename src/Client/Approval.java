
package Client;

import Common.Response;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Approval extends javax.swing.JFrame {

    ObjectOutputStream oos = null;
    ObjectInputStream ooi = null;
    String username = "";
    String from = "";
    Clientreceiver cr;
    Approval(ObjectOutputStream os , ObjectInputStream is , String from , String username , Clientreceiver c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        oos = os;
        ooi = is;
        this.from = from;
        cr=c;
        this.username = username;
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
         initComponents();
         setLocationRelativeTo(null);
    }
   
   
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        friendname = new javax.swing.JLabel();
        accept = new javax.swing.JButton();
        decline = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Approval");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(183, 228, 144));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("     Received a request from username : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 35));

        friendname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        friendname.setText("friend_name");
        jPanel1.add(friendname, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 16, 185, -1));

        accept.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        accept.setText("Accept ");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        jPanel1.add(accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 52, -1, -1));

        decline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        decline.setText("Decline");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        jPanel1.add(decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 479, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        
        Response res = new Response( username , from , true);
        
        try {
            oos.writeObject(res);
            oos.flush();
            
            
            
           Thread t = new Thread(new StartVideoWindow(cr));
           t.start();
            
            
           this.dispose();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Approval.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_acceptActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        Response res = new Response( username , from , false);
        
        try {
            oos.writeObject(res);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Approval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_declineActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton decline;
    public javax.swing.JLabel friendname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
