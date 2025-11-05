
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

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(106, 106, 106)
                        .addComponent(srcUser, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(srcUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
