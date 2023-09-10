/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yyun
 */
public class SM_ItemEntry extends javax.swing.JFrame {
    private String userID;
    private DefaultTableModel model1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells in jTable1 non-editable
                return false;
            }
        };
    private String ColumnName[] = {"ID","Name","Price","Stock","Supplier ID"};
    private int row = -1;
    
    private String id,name,supplierID;
    private double price;
    private int stock;
    private ArrayList<String> items = new ArrayList<String>();
    Item i1 = new Item();

    /**
     * Creates new form SM_ItemEntry
     */
    public SM_ItemEntry(String userID) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        model1.setColumnIdentifiers(ColumnName);
        this.ViewTable();
        this.userID = userID;
    }

    public void ViewTable(){
        items.clear();
        try {
            items = i1.ViewItemEntry();
            for (String itemArray : items) {
            String[] tokens = itemArray.substring(1, itemArray.length() - 1).split(", ");

            if (tokens.length == 5) {
                id = tokens[0].trim();
                name = tokens[1].trim();
                price = Double.parseDouble(tokens[2].trim());
                stock = Integer.parseInt(tokens[3].trim());
                supplierID = tokens[4].trim();
                Object[] data = {id, name, price, stock, supplierID};
                model1.addRow(data);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
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

        BtnAdd = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        BtnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSupplierID = new javax.swing.JTextField();
        BtnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnExit.setText("Back");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Item ID:");

        jLabel2.setText("Name:");

        jLabel3.setText("Price Per Unit: ");

        jLabel4.setText("In Stock Quantity:");

        txtItemID.setEditable(false);
        txtItemID.setEnabled(false);
        txtItemID.setFocusable(false);

        jTable1.setModel(model1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel5.setText("Item Entry");

        jLabel6.setText("Supplier ID:");

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSave)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnAdd)
                        .addComponent(BtnDelete)
                        .addComponent(BtnExit))
                    .addComponent(BtnClear))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(254, 254, 254))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAdd, BtnClear, BtnDelete, BtnExit, BtnSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnExit)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(BtnSave)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnClear)
                                .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAdd, BtnClear, BtnDelete, BtnExit, BtnSave});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        try {
            items = i1.ViewItemEntry(); // Load data from the data source
        } 
        catch (IOException e) {
            // Handle the exception if loading data fails
            e.printStackTrace();
        }

        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || txtQuantity.getText().isEmpty() || txtSupplierID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the item
        }

        // If everything is valid, proceed to add the item
        id = i1.generateNewId(); // Generate a new item ID based on existing data
        name = txtName.getText();
        price = Double.parseDouble(txtPrice.getText());
        stock = Integer.parseInt(txtQuantity.getText());
        supplierID = txtSupplierID.getText(); // check if exists

        try {
            String status = i1.AddItemEntry(id, name, price, stock, supplierID);
            if (status.equals("SUCCESSFUL")) {
                JOptionPane.showMessageDialog(null, "Item successfully added.", "Item added status", JOptionPane.INFORMATION_MESSAGE);
                txtItemID.setText(null);
                txtName.setText(null);
                txtPrice.setText(null);
                txtQuantity.setText(null);
                txtSupplierID.setText(null);
                model1.setRowCount(0);
                this.ViewTable();
            } else {
                JOptionPane.showMessageDialog(null, "Item unsuccessfully added.\nPlease try again.", "Item added status", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while adding the item. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        setVisible(false);
        SM_Menu form1 = new SM_Menu(userID);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        id = txtItemID.getText();
        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || txtQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the item
        }
        try {
            if (!i1.CheckDuplicate(id)){
                try {
                    i1.DeleteItemEntry(id);
                } catch (IOException ex) {
                    Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
                }
                txtItemID.setText(null);
                txtName.setText(null);
                txtPrice.setText(null);
                txtQuantity.setText(null);
                txtSupplierID.setText(null);
                txtSupplierID.setEnabled(true);
                txtSupplierID.setFocusable(true);
                jTable1.clearSelection();
                model1.setRowCount(0);
                this.ViewTable();
            }else{
                JOptionPane.showMessageDialog(null, "Item does not exist.\n Please check again.", "Item not exists.",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || txtQuantity.getText().isEmpty() || txtSupplierID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the item
        }else{
            id = txtItemID.getText();
            name = txtName.getText();
            price = Double.parseDouble(txtPrice.getText());
            stock = Integer.parseInt(txtQuantity.getText());
            supplierID = txtSupplierID.getText();

            try {
                i1.EditItemEntry(id, name, price, stock, supplierID);
            } catch (IOException ex) {
                Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtItemID.setText(null);
            txtName.setText(null);
            txtPrice.setText(null);
            txtQuantity.setText(null);
            txtSupplierID.setText(null);
            txtSupplierID.setEnabled(true);
            txtSupplierID.setFocusable(true);
            jTable1.clearSelection();
            model1.setRowCount(0);
            this.ViewTable();
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        row = jTable1.getSelectedRow(); 
        this.row = row;
        id = String.valueOf(model1.getValueAt(row, 0));
        name = String.valueOf(model1.getValueAt(row, 1));
        String sprice = String.valueOf(model1.getValueAt(row, 2));
        String sstock = String.valueOf(model1.getValueAt(row, 3));
        supplierID = String.valueOf(model1.getValueAt(row, 4));
        
        txtItemID.setText(id);
        txtName.setText(name);
        txtPrice.setText(sprice);
        txtQuantity.setText(sstock);
        txtSupplierID.setText(supplierID);
        txtSupplierID.setEnabled(false);
        txtSupplierID.setFocusable(false);
    }//GEN-LAST:event_jTable1MouseReleased

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        model1.setRowCount(0);
        txtItemID.setText(null);
        txtName.setText(null);
        txtPrice.setText(null);
        txtQuantity.setText(null);
        txtSupplierID.setText(null);
        txtSupplierID.setEnabled(true);
        txtSupplierID.setFocusable(true);
        jTable1.clearSelection();
        this.ViewTable();
    }//GEN-LAST:event_BtnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSupplierID;
    // End of variables declaration//GEN-END:variables
}
