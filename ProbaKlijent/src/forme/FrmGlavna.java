/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Korisnik;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class FrmGlavna extends javax.swing.JFrame {
private Korisnik k;
    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
        Dimension d=new Dimension();
        d.setSize(800,440);
        this.setSize(d); 
        this.setName("Login");
        pack();
        jButtonDalje.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldusername = new javax.swing.JTextField();
        jPasswordFieldpassword = new javax.swing.JPasswordField();
        jButtonLogout = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jLabelPic = new javax.swing.JLabel();
        jLabelKorisnikInfo = new javax.swing.JLabel();
        jButtonDalje = new javax.swing.JButton();

        jMenuItem3.setText("jMenuItem3");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);
        setPreferredSize(null);
        setSize(new java.awt.Dimension(800, 440));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelLogin.setBackground(new java.awt.Color(226, 243, 243));
        jPanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Korisnik", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelLogin.setPreferredSize(new java.awt.Dimension(642, 160));
        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("username:");
        jPanelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("password:");
        jPanelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        jPanelLogin.add(jTextFieldusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 175, -1));
        jPanelLogin.add(jPasswordFieldpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 175, -1));

        jButtonLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(0, 102, 102));
        jButtonLogout.setText("Izloguj se");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 135, -1));

        jButtonLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 102, 102));
        jButtonLogin.setText("Uloguj se");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 135, -1));

        jLabelPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanelLogin.add(jLabelPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 170, 170));

        jLabelKorisnikInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelKorisnikInfo.setForeground(new java.awt.Color(0, 102, 102));
        jPanelLogin.add(jLabelKorisnikInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 220, 50));

        jButtonDalje.setIcon(new javax.swing.ImageIcon("D:\\softveri\\jovanasemin\\ProbaKlijent\\images\\animated_arrow.gif")); // NOI18N
        jButtonDalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDaljeActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonDalje, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
      
        String username= jTextFieldusername.getText().trim();
       char[] passwordNiz= jPasswordFieldpassword.getPassword();
       String message="";
       if(username.isEmpty()){
       message+="Niste uneli username \n";
       }
       if(passwordNiz.length==0){
       message+="Niste unesli password";
       }
       if(!message.isEmpty()){
           JOptionPane.showMessageDialog(this, message);
           return;
       }
       String password = String.valueOf(passwordNiz);
       System.out.println(password);
        
       KlijentskiZahtev zahtev= new  KlijentskiZahtev();
       zahtev.setOperacija(operacije.Operacija.LOGOVANJE);
       Korisnik korisnik= new Korisnik();
       korisnik.setUsername(username);
       korisnik.setPassword(password);
       zahtev.setParametar(korisnik);
       komunikacija.Komunikacija.getInstance().posaljiZahtev(zahtev);
       ServerskiOdgovor odgovor= komunikacija.Komunikacija.getInstance().primiOdgovor(); 
       
       
       if(odgovor.getParametar()!=null){
        
        k=(Korisnik) odgovor.getParametar();
        jLabelKorisnikInfo.setText("Dobrodosli: "+k.getIme()+" \n"+k.getPrezime());
        String url= "images\\s"+k.getUsername()+"s.jpeg";
        BufferedImage img = null;
        try {
        img = ImageIO.read(new File(url));
        }catch (IOException e) {
        e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(jLabelPic.getWidth(), jLabelPic.getHeight(),
        Image.SCALE_SMOOTH);
        ImageIcon icon= new ImageIcon(dimg);
        jLabelPic.removeAll();
        jLabelPic.setIcon(icon);
        jButtonDalje.setEnabled(true);
       
        JOptionPane.showMessageDialog(this,odgovor.getPoruka(),"Uspeh",JOptionPane.PLAIN_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(this,odgovor.getPoruka(),"Greska",JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
       KlijentskiZahtev zahtev= new  KlijentskiZahtev();
       zahtev.setOperacija(operacije.Operacija.LOGOUT);
       komunikacija.Komunikacija.getInstance().posaljiZahtev(zahtev);
       this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       KlijentskiZahtev zahtev= new  KlijentskiZahtev();
       zahtev.setOperacija(operacije.Operacija.LOGOUT);
       komunikacija.Komunikacija.getInstance().posaljiZahtev(zahtev);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonDaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDaljeActionPerformed
        FrmMeni frm= new FrmMeni();
        frm.setKor(k);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonDaljeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDalje;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelKorisnikInfo;
    private javax.swing.JLabel jLabelPic;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPasswordFieldpassword;
    private javax.swing.JTextField jTextFieldusername;
    // End of variables declaration//GEN-END:variables

    public Korisnik getK() {
        return k;
    }
}
