package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormGV extends javax.swing.JFrame {

    DefaultTableModel dftb = new DefaultTableModel();

    public FormGV() {
        initComponents();
        loadData();
        loadtop3();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 255, 255));
    }

    private void tinhdiemtb() {
        try {
            float ta = Float.parseFloat(tfdiemta.getText());
            float th = Float.parseFloat(tfdiemth.getText());
            float gdtc = Float.parseFloat(tfdiemgdtc.getText());
            float diemtb = (ta + th + gdtc) / 3;
            String abc = String.valueOf(diemtb);
            tfdiemtb.setText(abc);
        } catch (Exception ex) {
            if (tfdiemta.getText().equals("") || tfdiemgdtc.getText().equals("") || tfdiemgdtc.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống điểm");
            } else {
                JOptionPane.showMessageDialog(null, "Nhập sai giá trị điểm");
            }
        }
    }

    private void loadData() {

        try {
            Connects a = new Connects();
            Connection con = Connects.openConnection();
            String sql = "SELECT * FROM BANGDIEM";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName(i + 1));
            }
            dftb.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb.addRow(row);

            }
            tblSV.setModel(dftb);
            tblSV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tblSV.getSelectedRow() >= 0) {
                        tfmasv.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 0).toString());
                        tfdiemta.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 1).toString());
                        tfdiemth.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 2).toString());
                        tfdiemgdtc.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 3).toString());
                        tinhdiemtb();
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadtop3() {
        try {
            DefaultTableModel dftb2 = new DefaultTableModel();
            Connects a = new Connects();
            Connection con = Connects.openConnection();
            String sql = "SELECT TOP 3 BANGDIEM.MASV,DIEMTB FROM BANGDIEM JOIN SINHVIEN ON SINHVIEN.MASV=BANGDIEM.MASV ORDER BY DIEMTB DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta2 = rs.getMetaData();
            int n = meta2.getColumnCount();
            Vector col2 = new Vector();
            for (int i = 0; i < n; i++) {
                col2.add(meta2.getColumnName(i + 1));
            }
            dftb2.setColumnIdentifiers(col2);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb2.addRow(row);

            }
            lblSV2.setModel(dftb2);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnnhapdiem = new javax.swing.JButton();
        btnsuadiem = new javax.swing.JButton();
        btnxoadiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfmasv = new javax.swing.JTextField();
        tfdiemta = new javax.swing.JTextField();
        tfdiemth = new javax.swing.JTextField();
        tfdiemgdtc = new javax.swing.JTextField();
        tfdiemtb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblSV2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnexit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnabout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỨC NĂNG QUẢN LÝ ĐIỂM");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("MaSV");

        btnnhapdiem.setText("Nhập điểm");
        btnnhapdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhapdiemActionPerformed(evt);
            }
        });

        btnsuadiem.setText("Sửa điểm");
        btnsuadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuadiemActionPerformed(evt);
            }
        });

        btnxoadiem.setText("Xóa điểm");
        btnxoadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoadiemActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaSV", "Điểm Tiếng Anh", "Điểm Tin học", "ĐIểm GDTC", "Điểm Trung Bình"
            }
        ));
        jScrollPane2.setViewportView(tblSV);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Điểm TH");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Điểm TA");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Điểm GDTC");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Điểm TB");

        tfdiemtb.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin sinh viên");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Top 3 sinh viên");

        lblSV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MaSV", "DiemTB"
            }
        ));
        jScrollPane1.setViewportView(lblSV2);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        btnexit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jMenu1.add(btnexit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        btnabout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        btnabout.setText("About");
        btnabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaboutActionPerformed(evt);
            }
        });
        jMenu2.add(btnabout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiemth, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiemta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiemgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnsuadiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnhapdiem, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(btnxoadiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnhapdiem)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiemta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsuadiem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiemth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoadiem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiemgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnnhapdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhapdiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = Connects.openConnection();
            String sql = "INSERT INTO BANGDIEM values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.setString(2, tfdiemta.getText());
            ps.setString(3, tfdiemth.getText());
            ps.setString(4, tfdiemth.getText());
            tinhdiemtb();
            ps.setString(5, tfdiemtb.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không nhập được điểm");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnnhapdiemActionPerformed

    private void btnxoadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoadiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = Connects.openConnection();
            String sql = "DELETE FROM BANGDIEM WHERE MASV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xóa được nữa !");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoadiemActionPerformed

    private void btnsuadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuadiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = Connects.openConnection();
            String sql = "UPDATE BANGDIEM SET DIEMTA = ?,DIEMTH = ?,DIEMGDQP = ?,DIEMTB= ? WHERE MASV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfdiemta.getText());
            ps.setString(2, tfdiemth.getText());
            ps.setString(3, tfdiemgdtc.getText());
            tinhdiemtb();
            ps.setString(4, tfdiemtb.getText());
            ps.setString(5, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
            loadtop3();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không update được điểm");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsuadiemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginForm Lg = null;
        try {
            Lg = new LoginForm();
        } catch (Exception ex) {
            Logger.getLogger(FormGV.class.getName()).log(Level.SEVERE, null, ex);
        }
        Lg.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?") == 0) {
            JOptionPane.showMessageDialog(null, "Bạn đã thoát");
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        JOptionPane.showMessageDialog(null, "Bạn đang sử dụng phiên bản Beta 1.0");
    }//GEN-LAST:event_btnaboutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnabout;
    private javax.swing.JMenuItem btnexit;
    private javax.swing.JButton btnnhapdiem;
    private javax.swing.JButton btnsuadiem;
    private javax.swing.JButton btnxoadiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable lblSV2;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField tfdiemgdtc;
    private javax.swing.JTextField tfdiemta;
    private javax.swing.JTextField tfdiemtb;
    private javax.swing.JTextField tfdiemth;
    private javax.swing.JTextField tfmasv;
    // End of variables declaration//GEN-END:variables
}
