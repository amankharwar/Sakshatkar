/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Common.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author asus
 */
public class Login extends javax.swing.JFrame {
    
    static ObjectOutputStream oos = null;
    static ObjectInputStream ooi = null;
    public static Socket socket = null;
    public static Socket socket1 = null;
    public static Socket socket2 = null;
    static ObjectOutputStream oos1 = null;
    static ObjectInputStream ooi1 = null;
    static ObjectOutputStream oos2 = null;
    static ObjectInputStream ooi2 = null;
    static InputStream in = null;
    static InputStream in1 = null ;
    static InputStream in2 = null ;
            
            
   
    
    
   
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        pwd = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText(" SAKSHATKAR");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 240, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, 44));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Username ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, 39));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 223, 38));
        jPanel1.add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 223, 39));

        login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        login.setText("Login");
        login.setBorder(null);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Does not have an account?     ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 254, 28));

        signup.setText("Create Account");
        signup.setToolTipText("");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel1.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 156, 28));

        jLabel5.setBackground(new java.awt.Color(216, 132, 36));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        jLabel6.setBackground(new java.awt.Color(227, 188, 134));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 610, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
         System.out.println("Starting call function.."); 
         
        try {
           
            
       
              
              if(ooi==null )
              {
                   System.out.println("ooi is null..."); 
              }
              
               if(ooi1==null )
              {
                   System.out.println("ooi1 is null..."); 
              }
               
                if(ooi2==null )
              {
                   System.out.println("ooi2 is null..."); 
              }
              
            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        User u = new User( name.getText() , String.valueOf(pwd.getPassword() ) );
       
        try {
            if(oos!=null)
            oos.writeObject(u);
            
            else{
                 System.out.println("oos is null"); 
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(oos!=null)
        {
        Authenticate au = null;
        try {
            
             //System.out.println("start reading...."); 
            au = (Authenticate)ooi.readObject();
             //System.out.println("Problem in read...."); 
            
            if(au.status)
            {
                JOptionPane.showMessageDialog(null, "You have been logged in Successfully...");
                
                
                
                
                Mainwindow mw = new Mainwindow();
                
                mw.label_username.setText( "@"+name.getText());
                mw.front_username.setText(name.getText());
                //mw.start(oos, ooi, name.getText(), oos1, ooi1, oos2 , ooi2 );
                mw.start(oos, ooi, name.getText(), oos1, ooi1, oos2 , ooi2 , this);
                if(socket2!=null )
                {
                     System.out.println("Login class : socket2 is not null..."); 
                }
                mw.audSocket = socket2;
                mw.setVisible(true);
                this.dispose();
            }
            
            else{
                
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
        
        
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
      
        Signup signup = new Signup(oos , ooi);
        
        signup.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_signupActionPerformed

    
    public  void close() throws IOException
    {
        //socket.close();
        //socket1.close();
        //socket2.close();
        
        System.exit(1);
    }
    
   
    public static void main(String args[]) throws IOException, InterruptedException {
        
       //Socket
       
       
        socket = new Socket("localhost", 7666);

        socket1 = new Socket("localhost", 7667);

        socket2 = new Socket("localhost", 7668);
        
        
        oos = new ObjectOutputStream(socket.getOutputStream());
         in = socket.getInputStream();
        // ObjectInputStream ooi=new ObjectInputStream(s.getInputStream());

         oos1 = new ObjectOutputStream(socket1.getOutputStream());
        //  ObjectInputStream ooi1 =new ObjectInputStream(s1.getInputStream());
         in1 = socket1.getInputStream();

        oos2 = new ObjectOutputStream(socket2.getOutputStream());
        // ObjectInputStream ooi2 = new ObjectInputStream(s2.getInputStream());

         in2 = socket2.getInputStream();

          ooi = new ObjectInputStream(in);
             System.out.println("Received ooi..."); 
           
                  ooi1 = new ObjectInputStream(in1 );
             System.out.println("Received ooi1...."); 
             
             ooi2 = new ObjectInputStream(in2);
              System.out.println("Received ooi2....."); 
         
           System.out.println("Going to launch frame ....."); 
        
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    public static javax.swing.JTextField name;
    public static javax.swing.JPasswordField pwd;
    public javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
