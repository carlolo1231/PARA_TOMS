
package ababangui;




import ababangui.UserS;
import ababangui.LoginPage;
import config.DbConnect;
import config.Session;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class EditUser extends javax.swing.JFrame {


    public EditUser() {
        setUndecorated(true);
        initComponents();
    }
public String destination;
   File selectedFile;
   public String oldpath;
   public String path;
   
    



public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/images", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = (ImagePath != null) ? new ImageIcon(ImagePath) : new ImageIcon(pic);

    int labelWidth = label.getWidth();
    if (labelWidth == 0) labelWidth = 150; 

    int newHeight = getHeightFromWidth(ImagePath, labelWidth);
    if (newHeight <= 0) newHeight = 150; 

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(labelWidth, newHeight, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}

public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
           
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!"+ex);
        }
        
        return -1;
    }
    public static String emails, usernames;
    
    public boolean duplicateChecker(){
        DbConnect conf = new DbConnect();
        try{
            String query = "SELECT * FROM users WHERE em = '"+email.getText()+"' OR us = '"+uname.getText()+"'";
            ResultSet resultSet = conf.getData(query);
            
            if(resultSet.next()){
                emails = resultSet.getString("em");
                if(emails.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                    email.setText(null);
                }
                usernames = resultSet.getString("us");
                if(usernames.equals(uname.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    uname.setText(null);
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
      public boolean  updateChecker(){
        DbConnect conf = new DbConnect();
        try{
            String query = "SELECT * FROM users WHERE (us = '"+uname.getText()+"' OR em = '"+email.getText()+"')AND id!='"+id.getText()+"' ";
            ResultSet resultSet = conf.getData(query);
            
            if(resultSet.next()){
                emails = resultSet.getString("em");
                if(emails.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                    email.setText(null);
                }
                usernames = resultSet.getString("us");
                if(usernames.equals(uname.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    uname.setText(null);
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        a_add = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        contact = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        utype = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pname = new javax.swing.JPasswordField();
        jLabel35 = new javax.swing.JLabel();
        ustatus = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 51, 102)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("'SUPPLY TRACKER'");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 670, 40));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("X");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 40));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("EDIT A USER");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, 40));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 50));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a_add.setBackground(new java.awt.Color(0, 0, 204));
        a_add.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        a_add.setText("ADD");
        a_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_addActionPerformed(evt);
            }
        });
        jPanel11.add(a_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, -1));

        refresh.setBackground(new java.awt.Color(0, 0, 204));
        refresh.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel11.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, -1));

        clear.setBackground(new java.awt.Color(0, 0, 204));
        clear.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel11.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, -1));

        update.setBackground(new java.awt.Color(0, 0, 204));
        update.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel11.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete.setBackground(new java.awt.Color(0, 0, 204));
        delete.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel11.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        back.setBackground(new java.awt.Color(0, 0, 204));
        back.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel11.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, -1));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, 470));
        jPanel9.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 260, 40));

        jLabel23.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Contact #:");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 90, -1));

        jLabel24.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Email:");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 90, -1));
        jPanel9.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 260, 40));

        utype.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        utype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        utype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utypeActionPerformed(evt);
            }
        });
        jPanel9.add(utype, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 260, 50));

        jLabel32.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("User Type:");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 90, -1));
        jPanel9.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 260, 40));

        jLabel30.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Last Name:");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 90, -1));

        jLabel33.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("First Name:");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 90, -1));
        jPanel9.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 260, 40));

        id.setEnabled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel9.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 170, 30));

        jLabel38.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("ID");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        jLabel34.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Username:");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 90, -1));
        jPanel9.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 260, 40));

        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        jPanel9.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 260, 40));

        jLabel35.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Password:");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 90, -1));

        ustatus.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ustatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        ustatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ustatusActionPerformed(evt);
            }
        });
        jPanel9.add(ustatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 462, 260, 40));

        jLabel37.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("User Status");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 90, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 80, 50));
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 330));

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 340, 330));

        select.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel9.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 120, 40));

        remove.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel9.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 130, 40));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -1, -1, 540));

        setSize(new java.awt.Dimension(1019, 566));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void a_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_addActionPerformed
       
     

    if(fname.getText().isEmpty()
        || lname.getText().isEmpty()
        || email.getText().isEmpty()
        || uname.getText().isEmpty()
        || pname.getText().isEmpty()
        || contact.getText().isEmpty()) {

        
        JOptionPane.showMessageDialog(null, "All Fields are Required!");
        return;
    }

    if(pname.getText().length() < 8) {
        pname.setText("");
        
        JOptionPane.showMessageDialog(null, "Password Must be longer than 8!");
        return;
    }

    String emails = this.email.getText();
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    Pattern patternEmail = Pattern.compile(emailRegex);
    Matcher matcherEmail = patternEmail.matcher(emails);

    if (!matcherEmail.matches()) {
        
        JOptionPane.showMessageDialog(this, "Invalid email format. Please use a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        this.email.setText("");
        this.email.requestFocus();
        return;
    }

    
    

    if (duplicateChecker()) {
        
        System.out.println("Duplicate Exist!");
        return;
    }

    DbConnect conf = new DbConnect();
    int result = conf.insertData("INSERT INTO users (fn, ln, type, em, us, ps, sn, status,image) "
        + "VALUES ('"+fname.getText()+"', '"+lname.getText()+"','"+utype.getSelectedItem()+"', '"+email.getText()+"', '"+uname.getText()+"'"
        + ", '"+pname.getText()+"', '"+contact.getText()+"',  '"+ustatus.getSelectedItem()+"', '"+destination+"')");

    if (result == 1) {
        try {
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
           
            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            UserS login = new UserS();
            login.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            
            System.out.println("Insert Error: " + ex);
        }
    } else {
        
    }
        
    }//GEN-LAST:event_a_addActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     if (fname.getText().isEmpty()
            || lname.getText().isEmpty()
            || email.getText().isEmpty()
            || uname.getText().isEmpty()
            || pname.getText().isEmpty()
            || contact.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All Fields are Required!");
        return;
    }

    if (pname.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be longer than 8 characters!");
        return;
    }

    if (updateChecker()) {
        JOptionPane.showMessageDialog(null, "Username or Email already exists!");
        return;
    }

    if (utype == null || utype.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "User type is not selected.");
        return;
    }

    if (ustatus == null || ustatus.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "User status is not selected.");
        return;
    }

    if (id == null || id.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "User ID is missing. Cannot update.");
        return;
    }

    if (destination == null) {
        destination = "";
    }

    System.out.println("Updating user with ID: " + id.getText());
    System.out.println("Image path: " + destination);

    try {
        
        DbConnect conf = new DbConnect();
        conf.updateData("UPDATE users SET "
                + "fn='" + fname.getText() + "', "
                + "ln='" + lname.getText() + "', "
                + "em='" + email.getText() + "', "
                + "type='" + utype.getSelectedItem().toString() + "', "
                + "us='" + uname.getText() + "', "
                + "status='" + ustatus.getSelectedItem().toString() + "', "
                + "ps='" + pname.getText() + "', "
                + "image='" + destination + "' "
                + "WHERE u_id='" + id.getText() + "'");

        
        if (destination.isEmpty()) {
            if (oldpath != null) {
                File existingFile = new File(oldpath);
                if (existingFile.exists()) {
                    existingFile.delete();
                    System.out.println("Old image deleted.");
                }
            }
        } else {
            if (oldpath != null && path != null && !oldpath.equals(path)) {
                File srcFile = new File(path);
                File destFile = new File(destination);

                if (srcFile.exists()) {
                    Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Image copied to " + destination);
                } else {
                    System.out.println("Source image file does not exist!");
                    JOptionPane.showMessageDialog(null, "Selected image file no longer exists.");
                }
            }
        }

      
        try (Connection connect = new DbConnect().getConnection()) {
            Session sess = Session.getInstance();
            int adminId = sess.getuid();
            String action = "Admin updated a user";

            String logSql = "INSERT INTO logs (user_id, activity, log_time) VALUES (?, ?, NOW())";
            try (PreparedStatement logStmt = connect.prepareStatement(logSql)) {
                logStmt.setInt(1, adminId);
                logStmt.setString(2, action);
                logStmt.executeUpdate();
            }
        } catch (SQLException logEx) {
            logEx.printStackTrace();
            JOptionPane.showMessageDialog(null, "Update successful but logging failed: " + logEx.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        UserS usf = new UserS();
        usf.setVisible(true);
        this.dispose();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Update failed: " + ex.getMessage());
    }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void utypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utypeActionPerformed

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void ustatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ustatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ustatusActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
      JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/Images/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!"+ex);
                    }
                }

    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
         remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination = "";
       path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       UserS usf = new UserS();
       usf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton a_add;
    public javax.swing.JButton back;
    public javax.swing.JButton clear;
    public javax.swing.JTextField contact;
    public javax.swing.JButton delete;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    public javax.swing.JTextField id;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField lname;
    public javax.swing.JPasswordField pname;
    public javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uname;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> ustatus;
    public javax.swing.JComboBox<String> utype;
    // End of variables declaration//GEN-END:variables
}
