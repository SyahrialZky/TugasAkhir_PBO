/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nocompany.tugasakhir_pbo.pages;

import nocompany.tugasakhir_pbo.model.Transaction;
import java.sql.SQLException;
import java.time.LocalDateTime;
import nocompany.tugasakhir_pbo.model.Items;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import nocompany.tugasakhir_pbo.model.DetailTransaction;
import nocompany.tugasakhir_pbo.model.Inventories;

/**
 *
 * @author hp
 */
public class Home1 extends javax.swing.JFrame {

    List<String> addedItems = new ArrayList<>();
    private static Home1 instance;

    /**
     * Creates new form Home1
     */
    public Home1() {
        initComponents();
        populateItemsTable();
    }

    private void populateItemsTable() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0); // Menghapus semua baris pada tabel sebelum mengisi data baru

        // Mendapatkan daftar item dari database
        List<Items> itemsList = Items.getAllItems();

        // Memasukkan data ke dalam tabel
        for (Items item : itemsList) {
            Object[] row = {item.getName(), item.getStock(), item.getPrice()};
            model.addRow(row);
        }
    }
     public static Home1 getInstance() {
        if (instance == null) {
            instance = new Home1();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        addItemsBtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "name", "qty", "price"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "pice", "qty", "total"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        jLabel2.setText("Transaction");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Total          :");

        jLabel4.setText("Payment  :");

        jLabel5.setText("Change    :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("Bayar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jToggleButton1.setText("Home");
        jToggleButton1.setBorder(null);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Item");
        jToggleButton2.setBorder(null);
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("History");
        jToggleButton3.setBorder(null);
        jToggleButton3.setContentAreaFilled(false);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jToggleButton1)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        addItemsBtn.setText("Tambah");
        addItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addItemsBtn))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(562, 562, 562)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(addItemsBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        pack();

        //add onchange function to get change
        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Gather data from jTable4
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        List<DetailTransaction> details = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            String name = (String) model.getValueAt(i, 0);

            // Check and cast the type of price
            Object priceObj = model.getValueAt(i, 1);
            int price;
            if (priceObj instanceof Double) {
                price = ((Double) priceObj).intValue();
            } else if (priceObj instanceof Integer) {
                price = (Integer) priceObj;
            } else {
                throw new IllegalArgumentException("Unsupported type for price: " + priceObj.getClass());
            }

            // Check and cast the type of qty
            Object qtyObj = model.getValueAt(i, 2);
            int qty;
            if (qtyObj instanceof Double) {
                qty = ((Double) qtyObj).intValue();
            } else if (qtyObj instanceof Integer) {
                qty = (Integer) qtyObj;
            } else {
                throw new IllegalArgumentException("Unsupported type for quantity: " + qtyObj.getClass());
            }

            // Get itemId from name
            int itemId;
            try {
                itemId = Items.getItemIdByName(name);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to retrieve item ID: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add to details list
            details.add(new DetailTransaction(name, price, qty, itemId));

            // Update inventory for items going out
            try {
                Inventories.addInventory(itemId, qty, "barang keluar");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to update inventory: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

// Calculate total amount, payment, and changeAmount
        int totalAmount = details.stream().mapToInt(detail -> detail.getPrice() * detail.getQty()).sum();
        int payment = Integer.parseInt(jTextField2.getText());
        int changeAmount = payment - totalAmount;

// Create transaction
        boolean success = Transaction.createTransaction(details, payment);
        if (success) {
            model.setRowCount(0);
            jTextField1.setText(Integer.toString(totalAmount));
            jTextField3.setText(Integer.toString(changeAmount));
            JOptionPane.showMessageDialog(this, "Transaction saved successfully.");
//            Transaction transaction = new Transaction(totalAmount);
//            String transactionDetails = transaction.toString(); // Memanggil metode toString()
            Struk struk = new Struk(details, totalAmount, payment, changeAmount);
            String strukText = struk.generateStrukText();
            JOptionPane.showMessageDialog(this, "Transaction details:\n" + strukText, "Transaction Details", JOptionPane.INFORMATION_MESSAGE);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            populateItemsTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save transaction.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
//        calculateChange();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        double total = 0;
        for (int i = 0; i < jTable4.getRowCount(); i++) {
            total += Double.parseDouble(jTable4.getValueAt(i, 3).toString());
        }

        jTextField1.setText(String.valueOf(total));
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = jTable4.getSelectedRow();

        if (selectedRowIndex != -1) {
            String itemName = jTable4.getValueAt(selectedRowIndex, 0).toString();
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

            // Get the current quantity of the selected item
            int currentQty = Integer.parseInt(jTable4.getValueAt(selectedRowIndex, 2).toString());

            if (currentQty > 1) {
                // Decrease the quantity by 1
                int newQty = currentQty - 1;
                jTable4.setValueAt(newQty, selectedRowIndex, 2);

                // Update the total price for this item
                double price = Double.parseDouble(jTable4.getValueAt(selectedRowIndex, 1).toString());
                double newTotal = newQty * price;
                jTable4.setValueAt(newTotal, selectedRowIndex, 3);
            } else {
                // If the quantity is 1, remove the item from the table
                model.removeRow(selectedRowIndex);
                addedItems.remove(itemName);
            }

            // Recalculate the total and the change
            calculateTotal();
            calculateChange();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item from the list.", "No item selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the selected row index from jTable3
        int selectedRowIndex = jTable3.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Get the selected item details from jTable3
            String name = jTable3.getValueAt(selectedRowIndex, 0).toString();
            double price = Double.parseDouble(jTable3.getValueAt(selectedRowIndex, 2).toString());

            // Check if the item already exists in the list
            if (addedItems.contains(name)) {
                // If it exists, find its index in jTable4
                int rowIndex = -1;
                for (int i = 0; i < jTable4.getRowCount(); i++) {
                    if (jTable4.getValueAt(i, 0).toString().equals(name)) {
                        rowIndex = i;
                        break;
                    }
                }
                // Increment the quantity by 1
                int qty = Integer.parseInt(jTable4.getValueAt(rowIndex, 2).toString()) + 1;
                jTable4.setValueAt(qty, rowIndex, 2);
                // Update the total
                double total = qty * price;
                jTable4.setValueAt(total, rowIndex, 3);
            } else {
                // If it doesn't exist, add it to the list with a quantity of 1
                addedItems.add(name);
                int qty = 1;
                double total = qty * price;
                // Add the selected item to jTable4
                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                model.addRow(new Object[]{name, price, qty, total});
            }

            // Recalculate the total and display it in jTextField1
            calculateTotal();
        } else {
            // If no row is selected, show a message
            JOptionPane.showMessageDialog(this, "Please select an item from the list.", "No item selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void calculateTotal() {
        // Calculate the total of all prices in jTable4
        double total = 0;
        for (int i = 0; i < jTable4.getRowCount(); i++) {
            total += Double.parseDouble(jTable4.getValueAt(i, 3).toString());
        }

        // Display the total in jTextField1
        jTextField1.setText(String.valueOf(total));
    }

    private void calculateChange() {
        try {
            // Get the total amount and payment from jTextField1 and jTextField2
            double totalAmount = Double.parseDouble(jTextField1.getText());
            double payment = Double.parseDouble(jTextField2.getText());

            // Calculate the change
            double change = payment - totalAmount;

            // Set the change to jTextField3
            jTextField3.setText(String.valueOf(change));
        } catch (NumberFormatException ex) {
            // Handle invalid input
            jTextField3.setText("");
        }
    }
       private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Home1 homeFrame = Home1.getInstance();
        homeFrame.setVisible(true);
        this.dispose();  // Sembunyikan window utama
    }
        private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Product productFrame = new Product();
        productFrame.setVisible(true);
        this.dispose();  // Sembunyikan window utama
    }
        private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        History historyFrame = new History();
        historyFrame.setVisible(true);
        this.dispose();  // Sembunyikan window utama
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemsBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}
