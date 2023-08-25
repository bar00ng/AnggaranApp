/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package anggaranapp;
import java.sql.*;
import java.util.HashMap;
import helper.Database;
import helper.reset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author my
 */
public class TripFrame extends javax.swing.JFrame {
    private HashMap<String, Integer> userMap = new HashMap<>();
    
    private Connection conn = new helper.Database().connect();
    Database db = new Database();
    private DefaultTableModel defaulTableModel;
    reset Clear = new reset();
   
    /**
     * Creates new form TripFrame
     */
    public TripFrame() {
        initComponents();
        initTable();
        initParticipantData();
        submitButton.setVisible(true);
        deleteButton.setVisible(false);
        editButton.setVisible(false);
        idInput.setVisible(false);
    }
    
    protected void initTable() {
        Object[] Row = {
            "Trip ID",
            "Title",
            "Partisipan",
            "Destinasi",
            "Tgl. Mulai",
            "Tgl. Selesai",
            "Budget",
            "Actual Expense",
        };
        
        defaulTableModel = new DefaultTableModel(null, Row);
        tripTable.setModel(defaulTableModel);
        
        String query = "SELECT Trip.trip_id, Trip.title, User.full_name, Trip.destination, Trip.start_date, Trip.end_date, Trip.total_budget, Trip.actual_expenses FROM Trip INNER JOIN User ON Trip.user_id = User.user_id";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                String tripId = rs.getString("trip_id");
                String tripTitle = rs.getString("title");
                String partisipan = rs.getString("full_name");
                String destinasi = rs.getString("destination");
                String tglMulai = rs.getString("start_date");
                String tglSelesai = rs.getString("end_date");
                String budgetTrip = rs.getString("total_budget");
                String actualExpense = rs.getString("actual_expenses");
                String[] data = {
                    tripId,
                    tripTitle,
                    partisipan,
                    destinasi,
                    tglMulai,
                    tglSelesai,
                    budgetTrip,
                    actualExpense,
                };
                defaulTableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TripFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Clear() {
        Clear.resetTextFields(this.getContentPane());
    }
    
    private void initParticipantData() {
        int i = 0;
        String query = "SELECT * FROM User WHERE full_name != 'SUPERADMIN'";
        try (PreparedStatement stm = conn.prepareStatement(query);
                ResultSet res =  stm.executeQuery()) {
            while(res.next()) {
                int idUser = res.getInt("user_id");
                String userFullName = res.getString("full_name");
                partisipanInput.addItem(userFullName);
                userMap.put(userFullName, idUser);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        destinasiInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tanggalMulaiInput = new com.toedter.calendar.JDateChooser();
        tglSelesaiInput = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        partisipanInput = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        budgetInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        actualExpenseInput = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        idInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        titleInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tripTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));

        jLabel1.setText("Destinasi");

        jLabel2.setText("Tgl. Mulai");

        jLabel3.setText("Tgl. Selesai");

        jLabel4.setText("Partisipan");

        jLabel5.setText("Budget");

        jLabel6.setText("Actual Expense");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Title");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(destinasiInput)
                                    .addComponent(tanggalMulaiInput, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(tglSelesaiInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(partisipanInput, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(budgetInput)
                                    .addComponent(titleInput)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(submitButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clearButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(editButton))
                                    .addComponent(actualExpenseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(destinasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tanggalMulaiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tglSelesaiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(partisipanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(budgetInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(actualExpenseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        tripTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tripTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tripTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tripTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String destinasi = destinasiInput.getText();
        java.sql.Date tglMulai = new java.sql.Date(tanggalMulaiInput.getDate().getTime());
        java.sql.Date tglSelesai = new java.sql.Date(tglSelesaiInput.getDate().getTime());
        String userFullName = (String) partisipanInput.getSelectedItem();
        String title = titleInput.getText();
        int idUser = userMap.get(userFullName);
        double budget = Double.parseDouble(budgetInput.getText());
        double actualExpense = Double.parseDouble(actualExpenseInput.getText());
        
        String[] col = {
            "user_id",
            "title",
            "destination",
            "start_date",
            "end_date",
            "total_budget",
            "actual_expenses",
        };
        
        Object[] val = {
            idUser,
            title,
            destinasi,
            tglMulai,
            tglSelesai,
            budget,
            actualExpense,
        };
        
        try {
            db.insertData(conn, "Trip", col, val);
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan data Trip");
            initTable();
            Clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data Trip");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        Clear();
        submitButton.setVisible(true);
        deleteButton.setVisible(false);
        editButton.setVisible(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String idTrip = idInput.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                db.deleteData(conn, "Trip", "trip_id = " + idTrip);
                JOptionPane.showMessageDialog(this, "Trip berhasil dihapus");
                initTable();
                Clear();
                
                deleteButton.setVisible(false);
                editButton.setVisible(false);
                
                submitButton.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus barang: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        String tripId = idInput.getText();
        String destinasi = destinasiInput.getText();
        java.sql.Date tglMulai = new java.sql.Date(tanggalMulaiInput.getDate().getTime());
        java.sql.Date tglSelesai = new java.sql.Date(tglSelesaiInput.getDate().getTime());
        String userFullName = (String) partisipanInput.getSelectedItem();
        String title = titleInput.getText();
        int idUser = userMap.get(userFullName);
        double budget = Double.parseDouble(budgetInput.getText());
        double actualExpense = Double.parseDouble(actualExpenseInput.getText());
        
        String[] col = {
            "user_id",
            "title",
            "destination",
            "start_date",
            "end_date",
            "total_budget",
            "actual_expenses",
        };
        
        Object[] val = {
            idUser,
            title,
            destinasi,
            tglMulai,
            tglSelesai,
            budget,
            actualExpense,
        };
        
        try {
            db.updateData(conn, "Trip", col, val, "trip_id = " + tripId);
            JOptionPane.showMessageDialog(null, "Data berhasil diperbaharui");
            initTable();
            Clear();

            deleteButton.setVisible(false);
            editButton.setVisible(false);

            submitButton.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memperbaharui data");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void tripTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tripTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = tripTable.getSelectedRow();
        if (selectedRow != -1) {
            String tripId = tripTable.getValueAt(selectedRow, 0).toString();
            String titleTrip = tripTable.getValueAt(selectedRow, 1).toString();
            String partisipan = tripTable.getValueAt(selectedRow, 2).toString();
            String destinasi = tripTable.getValueAt(selectedRow, 3).toString();
            String budgetTrip = tripTable.getValueAt(selectedRow, 6).toString();
            String actualExpense = tripTable.getValueAt(selectedRow, 7).toString();
            
            idInput.setText(tripId);
            titleInput.setText(titleTrip);
            partisipanInput.setSelectedItem(partisipan);
            destinasiInput.setText(destinasi);
            budgetInput.setText(budgetTrip);
            actualExpenseInput.setText(actualExpense);
            
            deleteButton.setVisible(true);
            editButton.setVisible(true);
            
            submitButton.setVisible(false);
        }
    }//GEN-LAST:event_tripTableMouseClicked

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
            java.util.logging.Logger.getLogger(TripFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TripFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TripFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TripFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TripFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualExpenseInput;
    private javax.swing.JTextField budgetInput;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField destinasiInput;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField idInput;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> partisipanInput;
    private javax.swing.JButton submitButton;
    private com.toedter.calendar.JDateChooser tanggalMulaiInput;
    private com.toedter.calendar.JDateChooser tglSelesaiInput;
    private javax.swing.JTextField titleInput;
    private javax.swing.JTable tripTable;
    // End of variables declaration//GEN-END:variables
}