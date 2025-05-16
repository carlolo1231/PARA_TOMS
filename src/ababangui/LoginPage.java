
package ababangui;

import ForgotPass.ForgotPassword;
import Userdashboard.UserDashboard;
import config.DbConnect;
import config.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class LoginPage extends javax.swing.JFrame {
  
  private Timer blinkTimer;
private boolean isBlue = true;
    public LoginPage() {
        setUndecorated(true);
        initComponents();
        blinkTimer = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            jLabel1.setForeground(isBlue ? Color.BLUE : Color.WHITE);
            isBlue = !isBlue;
        }
    });
    blinkTimer.start();
    }
public static String hashPassword(String password) {  
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}
public static Boolean loginAcc(String username, String password) {
               DbConnect connector = new DbConnect();
    String query = "SELECT id, u_fname, u_lname, u_email, u_username, u_pass, status, type FROM users WHERE u_username = ?";

    try (Connection connect = connector.getConnection();
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, username);
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            String storedHashedPassword = resultSet.getString("u_pass");
            String status = resultSet.getString("status");
            String type = resultSet.getString("type");

            String hashedPasswordInput = hashPassword(password);
            if (hashedPasswordInput == null) {
                System.out.println("Error hashing password!"); 
                return false;
            }

            if (!hashedPasswordInput.equals(storedHashedPassword)) {
                System.out.println("Invalid password."); 
                return false;
            }

            if ("Pending".equalsIgnoreCase(status)) {
                System.out.println("Your account is pending approval.");
                return false;
            }

            System.out.println("Welcome " + username + "! You are logged in as " + type);
            return true; 
        } else {
            System.out.println("Invalid username or password."); 
            return false; 
        }
    } catch (SQLException ex) {
        System.out.println("Database Error: " + ex.getMessage()); 
        return false;
    }
   }
 public void logActivity(int userId, String activity) {
    String logQuery = "INSERT INTO logs (user_id, activity) VALUES (?, ?)";

    try (Connection conn = new DbConnect().getConnection();
         PreparedStatement stmt = conn.prepareStatement(logQuery)) {

        stmt.setInt(1, userId);
        stmt.setString(2, activity);
        stmt.executeUpdate();

        System.out.println("Activity logged: " + activity);

    } catch (SQLException ex) {
        System.err.println("Failed to log activity: " + ex.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        Lbutton = new javax.swing.JButton();
        Rbutton = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("'Welcome to Supply Request Tracker'");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 730, 40));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 30, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 970, 100));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 5, true));
        jPanel3.setName(""); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 40));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 40));

        user.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        user.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 0)));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel3.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        Lbutton.setBackground(new java.awt.Color(0, 0, 0));
        Lbutton.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Lbutton.setForeground(new java.awt.Color(255, 255, 255));
        Lbutton.setText("LOGIN");
        Lbutton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Lbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LbuttonMouseExited(evt);
            }
        });
        Lbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(Lbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 140, 40));

        Rbutton.setBackground(new java.awt.Color(0, 0, 0));
        Rbutton.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Rbutton.setForeground(new java.awt.Color(255, 255, 255));
        Rbutton.setText("REGISTER");
        Rbutton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Rbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RbuttonMouseExited(evt);
            }
        });
        Rbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(Rbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 150, 40));

        pass.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 51)));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 250, 30));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 30));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Forgot password?");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 150, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 440, 340));

        jPanel4.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 10, 430));

        jPanel6.setBackground(new java.awt.Color(0, 51, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 10, 440));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/fantastic-fast-business-fast-internet-background_952778-12108.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 720, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/fantastic-fast-business-fast-internet-background_952778-12108.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-420, 80, 720, 460));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/fantastic-fast-business-fast-internet-background_952778-12108.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 720, 500));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/fantastic-fast-business-fast-internet-background_952778-12108.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 720, 500));

        jPanel5.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 930, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void LbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LbuttonActionPerformed
       String usernameInput = user.getText().trim();
    String passwordInput = new String(pass.getPassword()).trim();

    if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String hashedPasswordInput = hashPassword(passwordInput);
    String sql = "SELECT u_id, fn, ln, em, us, type, status, ps FROM users WHERE us = ?";

    try (Connection connect = new DbConnect().getConnection();
         PreparedStatement pst = connect.prepareStatement(sql)) {

        pst.setString(1, usernameInput);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("ps");
            String status = rs.getString("status");
            String userType = rs.getString("type");

           
            if (status.equalsIgnoreCase("Pending")) {
                JOptionPane.showMessageDialog(this, "Your account is pending. Please wait for admin approval.", "Access Denied", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            if (hashedPasswordInput.equals(dbPassword)) {
                
                
                Session sess = Session.getInstance();
                sess.setuid(rs.getInt("u_id"));
                sess.setFname(rs.getString("fn"));
                sess.setLname(rs.getString("ln"));
                sess.setemail(rs.getString("em"));
                sess.setusername(rs.getString("us"));
                sess.settype(userType);
                sess.setStatus(status);

               
                String activityMessage = userType.equalsIgnoreCase("admin") ? "Admin logged in" : "User logged in";
                logActivity(sess.getuid(), activityMessage);

               
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                
                switch (userType.toLowerCase()) {
                    case "admin":
                    case "supplier":
                        new AdminDashboard().setVisible(true);
                        break;
                    case "client":
                        new Userdashboard.UserDashboard().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Invalid User Type!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }

              
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "DB Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    
    }//GEN-LAST:event_LbuttonActionPerformed

    private void RbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbuttonActionPerformed
    

   

    this.setVisible(false); // Hide current form

    // Create and show the registration form
    RegistrationForm registrationForm = new RegistrationForm();
    registrationForm.setVisible(true);
    }//GEN-LAST:event_RbuttonActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
         if (jCheckBox1.isSelected()) {
        pass.setEchoChar((char) 0); 
    } else {
        pass.setEchoChar('*'); 
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        ForgotPassword fp = new ForgotPassword();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setForeground(Color.BLACK);
        jLabel8.setCursor( new Cursor (Cursor.HAND_CURSOR) );
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setForeground(Color.BLUE);
        jLabel8.setCursor( new Cursor (Cursor.DEFAULT_CURSOR) );
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void RbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbuttonMouseEntered
     Rbutton.setForeground(Color.BLUE);
     Rbutton.setBackground(Color.WHITE);
     Rbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_RbuttonMouseEntered

    private void RbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbuttonMouseExited
        Rbutton.setForeground(Color.WHITE);
        Rbutton.setBackground(Color.BLACK);
     Rbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_RbuttonMouseExited

    private void LbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbuttonMouseEntered
       Lbutton.setForeground(Color.BLUE);
     Lbutton.setBackground(Color.WHITE);
     Lbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LbuttonMouseEntered

    private void LbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbuttonMouseExited
          Lbutton.setForeground(Color.WHITE);
        Lbutton.setBackground(Color.BLACK);
     Lbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_LbuttonMouseExited

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lbutton;
    private javax.swing.JButton Rbutton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
