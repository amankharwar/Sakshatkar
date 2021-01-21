
package Client;
import Common.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
public class Videowindow extends javax.swing.JFrame {


    Clientreceiver cr;
    VideoSender vs;
    VideoReceiver vr;
    Audioreceiver ar;
    Audiosender as;
    
   
   public Videowindow(Audioreceiver a,Audiosender b,VideoReceiver c,VideoSender d,Clientreceiver e)
   {
       ar=a;
       as=b;
       vr=c;
       vs=d;
       cr=e;
       cr.video = this;
      // vr.vid=this;
      // vs.vid=this;
      try{
       UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
      }catch(Exception ex)
      {
           System.out.println( "Problem in constructor : " + this.getName()); 
      }
       initComponents();
       setLocationRelativeTo(null);
   }
    // cutcall()
    // stop video()
    // stop audio()
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        myvideo = new javax.swing.JLabel();
        clientvideo = new javax.swing.JLabel();
        leave = new javax.swing.JButton();
        myname = new javax.swing.JLabel();
        clientname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Video Window");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myvideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(myvideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 640, 480));

        clientvideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(clientvideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 640, 480));

        leave.setBackground(new java.awt.Color(255, 51, 51));
        leave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        leave.setForeground(new java.awt.Color(255, 255, 255));
        leave.setText("Leave");
        leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveActionPerformed(evt);
            }
        });
        getContentPane().add(leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 180, 40));

        myname.setBackground(new java.awt.Color(255, 255, 255));
        myname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        myname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myname.setText("  my name");
        myname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        myname.setOpaque(true);
        getContentPane().add(myname, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 550, 260, 40));

        clientname.setBackground(new java.awt.Color(255, 255, 255));
        clientname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        clientname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientname.setText("client name");
        clientname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        clientname.setOpaque(true);
        getContentPane().add(clientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 270, 40));

        jLabel1.setBackground(new java.awt.Color(235, 219, 168));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveActionPerformed
         Systeminfo s=new Systeminfo(cr.username,cr.to,2);
        try {
            cr.oos.writeObject(s);
            
        } catch (IOException ex) {
            Logger.getLogger(Videowindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ar.stop();
        //as.stop();
        //vr.stop();
        //vs.stop();
       // ar.close();
        as.close();
       vs.close();
       // vr.close();
        
        this.dispose();
    }//GEN-LAST:event_leaveActionPerformed
    public void cut() 
    {
        //ar.stop();
        //as.stop();
        //vr.stop();
        //vs.stop();
      //  ar.close();
        as.close();
        vs.close();
    //    vr.close();
        
        this.dispose();
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel clientname;
    public javax.swing.JLabel clientvideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leave;
    public javax.swing.JLabel myname;
    public javax.swing.JLabel myvideo;
    // End of variables declaration//GEN-END:variables

    
}
