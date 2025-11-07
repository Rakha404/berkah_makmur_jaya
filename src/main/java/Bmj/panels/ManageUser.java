
package Bmj.panels;

import Bmj.dialogs.AddNewUser;
import Bmj.dialogs.EditUser;
import Bmj.dialogs.HapusUser;
import Bmj.util.Koneksi;
import Bmj.util.Pegawai;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ManageUser extends javax.swing.JPanel {
    
    Pegawai Px;
    
    public ManageUser () {
        initComponents();
        
        refreshData("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        srcUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 40, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon tambah.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon edit.png"))); // NOI18N
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon hapus.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, 40));

        jTable1.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "USERNAME", "PASSWORD"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 76, 580, 280));

        srcUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcUserActionPerformed(evt);
            }
        });
        srcUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srcUserKeyReleased(evt);
            }
        });
        jPanel2.add(srcUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon search.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 30, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg manage user.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddNewUser NU = new AddNewUser(null,true);
        NU.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HapusUser hu = new HapusUser(null, true);
        hu.P = Px;
        hu.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jTable1.clearSelection();
        srcUser.setText("");
        refreshData("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int n = jTable1.getSelectedRow();
        if(n != -1){
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            //ekstraksi data
            Px = new Pegawai();
            String IDuser = jTable1.getValueAt(n, 0).toString();
            int ID = Integer.valueOf(IDuser);
            String Nama = jTable1.getValueAt(n, 1).toString();
            String Jabatan = jTable1.getValueAt(n, 2).toString();
            String Username = jTable1.getValueAt(n, 3).toString();
            String Password = jTable1.getValueAt(n, 4).toString();

            Px.setId(ID);
            Px.setNama(Nama);
            Px.setJabatan(Jabatan);
            Px.setUsername(Username);
            Px.setPassword(Password);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRow() != -1){
            EditUser em = new EditUser(null, true);
            em.P = Px;
            em.setVisible(true); 
        }else {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void srcUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcUserActionPerformed

    }//GEN-LAST:event_srcUserActionPerformed

    private void srcUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcUserKeyReleased
        searchDataUser();
    }//GEN-LAST:event_srcUserKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JTextField srcUser;
    // End of variables declaration//GEN-END:variables
   
    public static void refreshData(String W) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            Connection K = Koneksi.Go();
            String Q = "SELECT * FROM pegawai" + W;
            Statement S = K.createStatement();
            ResultSet R = S.executeQuery(Q);
            while (R.next()) {
                int id = R.getInt("id_pegawai");
                String nama = R.getString("nama");
                String jabatan = R.getString("jabatan");
                String username = R.getString("username");
                String password = R.getString("password");
                Object[] datausers = {id, nama, jabatan, username, password};
                model.addRow(datausers);
            }

        } catch (Exception e) {
        }
    }

    private void searchDataUser() {
        String key = srcUser.getText();
        String where = " WHERE "
                + "id_pegawai LIKE '%" + key + "%' OR "
                + "nama LIKE '%" + key + "%' OR "
                + "jabatan LIKE '%" + key + "%' OR "
                + "username LIKE '%" + key + "%' OR "
                + "password LIKE '%" + key + "%'";
        
        System.out.println("String WHERE yang dibuat: " + where);
        refreshData(where);
    }
}
