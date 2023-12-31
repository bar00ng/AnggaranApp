/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package anggaranapp;

import helper.Database;
import helper.reset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author my
 */
public class PengeluaranFrame extends javax.swing.JFrame {
    private HashMap<String, Integer> tripMap = new HashMap<>();
    private HashMap<String, Integer> categoryMap = new HashMap<>();

    
    private Connection conn = new helper.Database().connect();
    Database db = new Database();
    private DefaultTableModel defaulTableModel;
    reset Clear = new reset();
    /**
     * Creates new form PengeluaranFrame
     */
    public PengeluaranFrame() {
        initComponents();
        initTable();
        initCategoryData();
        initTripData();
        submitButton.setVisible(true);
        deleteButton.setVisible(false);
        editButton.setVisible(false);
        idInput.setVisible(false);
    }
    
    protected void initTable() {
        Object[] Row = {
            "Expense ID",
            "Perjalanan",
            "Tgl. Pengeluaran",
            "Deskripsi",
            "Nominal",
            "Kategori",
        };
        
        defaulTableModel = new DefaultTableModel(null, Row);
        pengeluaranTable.setModel(defaulTableModel);
        
        String query = "SELECT Expenses. expense_id, Trip.title, Expenses.expense_date, Expenses.description, Expenses.amount, Categories.category_name FROM Expenses JOIN Categories ON Expenses.category_id = Categories.category_id JOIN Trip ON Expenses.trip_id = Trip.trip_id";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                String expenseId = rs.getString("expense_id");
                String titleTrip = rs.getString("title");
                String tglPengeluaran = rs.getString("expense_date");
                String desc = rs.getString("description");
                String nominal = rs.getString("amount");
                String category = rs.getString("category_name");
                String[] data = {
                    expenseId,
                    titleTrip,
                    tglPengeluaran,
                    desc,
                    nominal,
                    category
                };
                defaulTableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengeluaranFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Clear() {
        Clear.resetTextFields(this.getContentPane());
    }
    
    private void initTripData() {
        int i = 0;
        String query = "SELECT * FROM Trip";
        try (PreparedStatement stm = conn.prepareStatement(query);
                ResultSet res =  stm.executeQuery()) {
            while(res.next()) {
                int idTrip = res.getInt("trip_id");
                String titleTrip = res.getString("title");
                tripInput.addItem(titleTrip);
                tripMap.put(titleTrip, idTrip);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initCategoryData() {
        int i = 0;
        String query = "SELECT * FROM Categories";
        try (PreparedStatement stm = conn.prepareStatement(query);
                ResultSet res =  stm.executeQuery()) {
            while(res.next()) {
                int idCategory = res.getInt("category_id");
                String nameCategory = res.getString("category_name");
                kategoriInput.addItem(nameCategory);
                categoryMap.put(nameCategory, idCategory);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        pengeluaranTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tglPengeluaranInput = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        nominalInput = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        idInput = new javax.swing.JTextField();
        tripInput = new javax.swing.JComboBox<>();
        scrollPane = new javax.swing.JScrollPane();
        deskripsiInput = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        kategoriInput = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pengeluaranTable.setModel(new javax.swing.table.DefaultTableModel(
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
        pengeluaranTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengeluaranTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pengeluaranTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));

        jLabel1.setText("Trip");

        jLabel2.setText("Tgl. Pengeluaran");

        jLabel3.setText("Deskripsi");

        jLabel4.setText("Nominal");

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

        deskripsiInput.setColumns(20);
        deskripsiInput.setRows(5);
        scrollPane.setViewportView(deskripsiInput);

        jLabel5.setText("Kategori");

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
                                .addGap(118, 118, 118)
                                .addComponent(submitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglPengeluaranInput, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(nominalInput)
                                    .addComponent(tripInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kategoriInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                    .addComponent(tripInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kategoriInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tglPengeluaranInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nominalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pengeluaranTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengeluaranTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = pengeluaranTable.getSelectedRow();
        if (selectedRow != -1) {
            String expenseId = pengeluaranTable.getValueAt(selectedRow, 0).toString();
            String trip = pengeluaranTable.getValueAt(selectedRow, 1).toString();
            String deskripsi = pengeluaranTable.getValueAt(selectedRow, 3).toString();
            String nominal = pengeluaranTable.getValueAt(selectedRow, 4).toString();
            String kategori = pengeluaranTable.getValueAt(selectedRow, 5).toString();

            idInput.setText(expenseId);
            tripInput.setSelectedItem(trip);
            deskripsiInput.setText(deskripsi);
            nominalInput.setText(nominal);
            kategoriInput.setSelectedItem(kategori);

            deleteButton.setVisible(true);
            editButton.setVisible(true);

            submitButton.setVisible(false);
        }
    }//GEN-LAST:event_pengeluaranTableMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String tripTitle = (String) tripInput.getSelectedItem();
        int idTrip = tripMap.get(tripTitle);
        String category = (String) kategoriInput.getSelectedItem();
        int idCategory = categoryMap.get(category);
        java.sql.Date tglPengeluaran = new java.sql.Date(tglPengeluaranInput.getDate().getTime());
        String deskripsi = deskripsiInput.getText();
        double nominal = Double.parseDouble(nominalInput.getText());

        String[] col = {
            "trip_id",
            "expense_date",
            "description",
            "amount",
            "category_id",
        };

        Object[] val = {
            idTrip,
            tglPengeluaran,
            deskripsi,
            nominal,
            idCategory,
        };

        try {
            db.insertData(conn, "Expenses", col, val);
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan data Pengeluaran");
            initTable();
            Clear();
            deskripsiInput.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data Pengeluara");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        Clear();
        deskripsiInput.setText("");
        submitButton.setVisible(true);
        deleteButton.setVisible(false);
        editButton.setVisible(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String idExpense = idInput.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                db.deleteData(conn, "Expenses", "expense_id = " + idExpense);
                JOptionPane.showMessageDialog(this, "Pengeluaran berhasil dihapus");
                initTable();
                Clear();

                deskripsiInput.setText("");
                
                deleteButton.setVisible(false);
                editButton.setVisible(false);

                submitButton.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        String idExpense = idInput.getText();
        String tripTitle = (String) tripInput.getSelectedItem();
        int idTrip = tripMap.get(tripTitle);
        String category = (String) kategoriInput.getSelectedItem();
        int idCategory = categoryMap.get(category);
        java.sql.Date tglPengeluaran = new java.sql.Date(tglPengeluaranInput.getDate().getTime());
        String deskripsi = deskripsiInput.getText();
        double nominal = Double.parseDouble(nominalInput.getText());

        String[] col = {
            "trip_id",
            "expense_date",
            "description",
            "amount",
            "category_id",
        };

        Object[] val = {
            idTrip,
            tglPengeluaran,
            deskripsi,
            nominal,
            idCategory,
        };

        try {
            db.updateData(conn, "Expenses", col, val, "expense_id = " + idExpense);
            JOptionPane.showMessageDialog(null, "Data berhasil diperbaharui");
            initTable();
            Clear();
            
            deskripsiInput.setText("");

            deleteButton.setVisible(false);
            editButton.setVisible(false);

            submitButton.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memperbaharui data");
        }
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengeluaranFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea deskripsiInput;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategoriInput;
    private javax.swing.JTextField nominalInput;
    private javax.swing.JTable pengeluaranTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton submitButton;
    private com.toedter.calendar.JDateChooser tglPengeluaranInput;
    private javax.swing.JComboBox<String> tripInput;
    // End of variables declaration//GEN-END:variables
}
