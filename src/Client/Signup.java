/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Common.Registration;
import Common.SignupInfo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Signup extends javax.swing.JFrame {

    static ObjectOutputStream oos = null;
    static ObjectInputStream ois = null ;
    
    String Fname = "";
    String Lname = "";
    String Email = "";
    String Username = "";
    String Pass = "";
    String Repass = "";
    
   
    public Signup( ObjectOutputStream os , ObjectInputStream is) {
        
        oos = os;
        ois = is;
        
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        repass = new javax.swing.JPasswordField();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Signup");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 120, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("First Name ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 109, 44));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("SAKSHATKAR");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 240, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Last Name ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 109, 44));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 109, 44));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 120, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("email id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 109, 44));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("re-enter password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 150, 44));

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 170, 40));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 170, 40));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 170, 40));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 170, 40));
        jPanel1.add(repass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 170, 40));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 170, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Signup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 130, 40));

        jLabel9.setBackground(new java.awt.Color(219, 148, 113));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 80));

        jLabel10.setBackground(new java.awt.Color(204, 169, 119));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 490, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       Fname = fname.getText();
       Lname = lname.getText();
       Email =  email.getText();
       Username = username.getText();
       Pass = String.valueOf(pass.getPassword());
       Repass = String.valueOf(repass.getPassword());
       
       if(Fname.equals(""))
       {
           JOptionPane.showMessageDialog(null, "First name can not be vaccant..");
           return;
       }
       
       if(Email.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Email can not be vaccant..");
           return;
       }
       if(Username.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Username can not be vaccant..");
           return;
           
       }
       
       if(Pass.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Password can not be vaccant..");
       }
       
       if(!Pass.equals(Repass))
       {
           JOptionPane.showMessageDialog(null, "Password doesn't match..");
           return;
       }
       
       
        
        SignupInfo sign = new SignupInfo( Fname ,Lname , Email,Username  ,Pass  );
        
        try {
            oos.writeObject(sign);
            oos.flush();
            
            //you need to have acknowledgement for successfull registration ....
            //it may be the case that two client can have same username...
            
            Object obj = null;
            
            obj = ois.readObject();
            
            Registration reg = (Registration)obj;
            
            if(reg.accepted)
            {
                JOptionPane.showMessageDialog(null, "You have been registered successfully...");

                (new Login()).setVisible(true);
                this.dispose();
            }
            
            else{
                
                JOptionPane.showMessageDialog(null, "Username alread exist. Please choose another Username...");
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField repass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
