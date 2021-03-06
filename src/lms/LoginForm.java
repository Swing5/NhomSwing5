package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    FormDT Dt = new FormDT();
    FormGV Gv = new FormGV();
    Connects a = new Connects();
    Connection con;

    public LoginForm() throws Exception {
        con = Connects.openConnection();
        initComponents();
        setTitle("Form Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 255, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblform = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        lblpassword = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        tfpassword = new javax.swing.JPasswordField();
        rbvie = new javax.swing.JRadioButton();
        rben = new javax.swing.JRadioButton();
        lbllanguage = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        lblform.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblform.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblform.setText("LOGIN FORM");

        lblusername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblusername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/a.png"))); // NOI18N
        lblusername.setText("Username");

        lblpassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblpassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/c.png"))); // NOI18N
        lblpassword.setText("Password");

        tfusername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfusername.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfusernameCaretUpdate(evt);
            }
        });

        tfpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfpassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfpasswordCaretUpdate(evt);
            }
        });

        rbvie.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rbvie);
        rbvie.setText("VIE");
        rbvie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbvieActionPerformed(evt);
            }
        });

        rben.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rben);
        rben.setSelected(true);
        rben.setText("EN");
        rben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbenActionPerformed(evt);
            }
        });

        lbllanguage.setText("Language");

        btnlogin.setBackground(new java.awt.Color(255, 0, 0));
        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 0, 0));
        btnexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnreset.setBackground(new java.awt.Color(255, 0, 0));
        btnreset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreset.setForeground(new java.awt.Color(255, 255, 255));
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbllanguage)
                .addGap(18, 18, 18)
                .addComponent(rbvie)
                .addGap(18, 18, 18)
                .addComponent(rben))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfusername)
                                    .addComponent(tfpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblform, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogin)
                    .addComponent(btnexit)
                    .addComponent(btnreset))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rben)
                    .addComponent(rbvie)
                    .addComponent(lbllanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbvieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbvieActionPerformed
        lblform.setText("Th??ng tin ????ng nh???p");
        lblusername.setText("T??i kho???n");
        lblpassword.setText("M???t kh???u");
        btnlogin.setText("????ng nh???p");
        btnexit.setText("Tho??t");
        btnreset.setText("X??a tr???ng");
        lbllanguage.setText("Ng??n ng???");
        tfusername.setToolTipText("M???i b???n nh???p t??i kho???n");
        tfpassword.setToolTipText("M???i b???n nh???p m???t kh???u");
    }//GEN-LAST:event_rbvieActionPerformed

    private void rbenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbenActionPerformed
        lblform.setText("LOGIN FORM");
        lblusername.setText("Username");
        lblpassword.setText("Password");
        btnlogin.setText("Login");
        lbllanguage.setText("Language");
        btnexit.setText("Exit");
        btnreset.setText("Reset");
        tfusername.setToolTipText("Enter a account");
        tfpassword.setToolTipText("Enter a password");
    }//GEN-LAST:event_rbenActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed

        try {

            String sql = "SELECT * FROM USERS WHERE TAIKHOAN=? AND MATKHAU=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfusername.getText());
            ps.setString(2, tfpassword.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("CHUCNANG").equals("GV")) {
                    JOptionPane.showMessageDialog(null, "????ng nh???p th??nh c??ng");
                    Dt.hide();
                    Gv.show();
                    this.hide();
                } else {
                    JOptionPane.showMessageDialog(null, "????ng nh???p th??nh c??ng");
                    Dt.show();
                    Gv.hide();
                    this.hide();
                }
            } else {
                JOptionPane.showMessageDialog(null, "T??n t??i kho???n ho???c m???t kh???u kh??ng ch??nh x??c");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "L???i : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnloginActionPerformed

    private void tfusernameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfusernameCaretUpdate
        if (tfusername.getText().length() > 2) {
            tfpassword.setEnabled(true);
            btnlogin.setEnabled(true);
        } else {
            tfpassword.setEnabled(false);
            btnlogin.setEnabled(false);
        }
    }//GEN-LAST:event_tfusernameCaretUpdate

    private void tfpasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfpasswordCaretUpdate
        if (tfpassword.getText().length() > 2) {
            btnlogin.setEnabled(true);
        } else {
            btnlogin.setEnabled(false);
        }
    }//GEN-LAST:event_tfpasswordCaretUpdate

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if (rbvie.isSelected()) {
            if (JOptionPane.showConfirmDialog(null, "B???n c?? mu???n tho??t kh??ng?") == 0) {
                JOptionPane.showMessageDialog(null, "B???n ???? tho??t");
                System.exit(0);
            }
        } else {
            if (JOptionPane.showConfirmDialog(null, "Do you want to exit?") == 0) {
                JOptionPane.showMessageDialog(null, "You exited");
                System.exit(0);
            }
        }


    }//GEN-LAST:event_btnexitActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        tfusername.setText(null);
        tfpassword.setText(null);
    }//GEN-LAST:event_btnresetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnreset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblform;
    private javax.swing.JLabel lbllanguage;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JRadioButton rben;
    private javax.swing.JRadioButton rbvie;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
