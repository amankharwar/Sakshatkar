
package Client;

import Common.Request;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import Common.*;
import java.net.Socket;
import javax.swing.UIManager;
public class Mainwindow extends javax.swing.JFrame {

    ObjectOutputStream oos = null ;
    ObjectInputStream ooi = null ;
    ObjectOutputStream oos1 = null ;
    ObjectInputStream ooi1 = null ;
    ObjectOutputStream oos2  = null ;
    ObjectInputStream ooi2  = null ;
    String username = "";
    Clientreceiver cr;
    
    public Socket audSocket = null ;
    
    Login login = null;
    Thread t1=null;
    public Mainwindow() {
          try{
       UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
      }catch(Exception ex)
      {
           System.out.println( "Problem in constructor : " + this.getName()); 
      }
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        label_username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        contactList = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        front_username = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        call = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Main Window");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_username.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        label_username.setForeground(new java.awt.Color(29, 55, 161));
        label_username.setText("   @username");
        label_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 31, 180, 46));

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   DP");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 31, 64, 46));

        jButton2.setText(".");
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 31, 23, 49));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contact List");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, 180, 40));

        contactList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contactList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aman", "ayush", "akshay" }));
        jPanel3.add(contactList, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 221, 240, 40));

        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 11, 320, 770));

        front_username.setFont(new java.awt.Font("Times New Roman", 0, 60)); // NOI18N
        front_username.setForeground(new java.awt.Color(233, 48, 102));
        front_username.setText("username");
        jPanel3.add(front_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 390, 70));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(233, 48, 102));
        jLabel6.setText("WELCOME ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, 80));

        call.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        call.setText("Call");
        call.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callActionPerformed(evt);
            }
        });
        jPanel3.add(call, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 281, 120, 40));

        logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout.setText("logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 377, 133, 41));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1350, 790));

        jLabel5.setBackground(new java.awt.Color(211, 207, 179));
        jLabel5.setOpaque(true);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void callActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callActionPerformed
       
        Object obj = contactList.getSelectedItem();
        String to = obj.toString();
        
        Request req = new Request( username, to );
        
        try {
            
             System.out.println("Requesting to "+ to); 
            
            oos.writeObject(req);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_callActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        
        try {
            oos.writeObject(new Systeminfo("","",1));
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        // cr thread close
        // cr.ooi.close();
        //cr.oos.close();
        //cr.stop();
        
         System.out.println("callign cr.close from mainwindow using logout button......"); 
        
        try {
            cr.close();
        } catch (IOException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
    }//GEN-LAST:event_logoutActionPerformed
     // logout()
    // dropdown list of friend
    // text area of name of friend
   
    //start()
    
    void start( ObjectOutputStream os , ObjectInputStream is , String name,ObjectOutputStream os1 , ObjectInputStream is1 , ObjectOutputStream os2 , ObjectInputStream is2 , Login l)
    {   
        oos = os;
        ooi = is;
        oos1 = os1;
        ooi1 = is1;
        oos2 = os2;
        ooi2 = is2;
        username = name;
        login = l;
        cr = new Clientreceiver(os, is, name, oos1, ooi1 , oos2 , ooi2 , login);
        if(audSocket==null )
        {
             System.out.println("Mainwindow : audsocket is null......" ); 
        }
        else
        {
             System.out.println("Mainwindow : audsocket is not null...."); 
        }
        cr.audioSocket = audSocket;
        Thread t = new Thread(cr);
        //t1 = t;
        t.start();
       
        
    }

   
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton call;
    private javax.swing.JComboBox<String> contactList;
    public javax.swing.JLabel front_username;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel label_username;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
