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
public class SM_SupplierEntry extends javax.swing.JFrame {
    private String userID;
    private DefaultTableModel model = new DefaultTableModel();
    private int size ,row = -1;
    private String id,name,contactNumber,address;
    private String itemID, itemName;
    private String iColumnName[] = {"Item ID","Item Name","Item Stock"};
    private String sColumnName[] = {"Supplier ID","Supplier Name","Contact Number","Address"};
    private ArrayList<String> supplier = new ArrayList<String>();
    private ArrayList<String> items = new ArrayList<String>();
    Supplier s1 = new Supplier();
    Item i1 = new Item();

    /**
     * Creates new form SM_SupplierEntry
     */
    public SM_SupplierEntry(String userID) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        model.setColumnIdentifiers(sColumnName);        
        this.ViewSupplierTable();
        model.isCellEditable(model.getRowCount(), model.getColumnCount());
        this.userID = userID;
    }
    
    public void ViewSupplierTable() {
        // Set column headers
        model.setColumnIdentifiers(sColumnName);

        // Clear any existing data in the supplier list
        supplier.clear();

        try {
            // Retrieve supplier data from some source (e.g., ViewSupplierEntry)
            supplier = s1.ViewSupplierEntry();

            // Iterate through each supplier entry
            for (String supplierArray : supplier) {
                // Split the data using the delimiter ", "
                String[] tokens = supplierArray.substring(1, supplierArray.length() - 1).split(", ");

                // Check if the data has four tokens (assumed to be valid)
                if (tokens.length == 4) {
                    // Extract individual fields
                    id = tokens[0].trim();
                    name = tokens[1].trim();
                    contactNumber = tokens[2].trim();
                    address = tokens[3].trim();

                    // Create an object array to represent a row of data
                    Object[] data = {id, name, contactNumber, address};

                    // Add the row to the table model
                    model.addRow(data);
                }
            }
        } catch (IOException ex) {
            // Handle any exceptions (e.g., logging or showing an error message)
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Enable and focus the table
        jTable1.setEnabled(true);
        jTable1.setFocusable(true);
    }


    public void ViewItemTable(String supplierID) {
        model.setColumnIdentifiers(iColumnName);
        items.clear();

        try {
            items = i1.ViewItemEntry();
            for (String itemArray : items) {
                String[] tokens = itemArray.substring(1, itemArray.length() - 1).split(",");
                if (tokens.length >= 5) {
                    itemID = tokens[0].trim();
                    itemName = tokens[1].trim();
                    String stock = tokens[3].trim();
                    id = tokens[4].trim();
                    Object[] data = {itemID, itemName, stock};

                    // Check if the item's supplier ID matches the specified supplier ID
                    if (id.equals(supplierID)) {
                        model.addRow(data);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnAdd = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        BtnClear = new javax.swing.JButton();
        BtnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel1.setText("Supplier Entry");

        jLabel2.setText("ID:");

        jLabel3.setText("Name: ");

        jLabel4.setText("Address: ");

        jLabel5.setText("Contact Number: ");

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

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

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContactNumber)
                    .addComponent(txtID))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnAdd)
                    .addComponent(BtnDelete)
                    .addComponent(BtnSave)
                    .addComponent(BtnBack)
                    .addComponent(BtnClear)
                    .addComponent(BtnSearch))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(179, 179, 179))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAdd, BtnBack, BtnClear, BtnDelete, BtnSave, BtnSearch});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress, txtContactNumber, txtID, txtName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBack)
                .addGap(18, 18, 18)
                .addComponent(BtnSearch)
                .addGap(18, 18, 18)
                .addComponent(BtnAdd)
                .addGap(18, 18, 18)
                .addComponent(BtnDelete)
                .addGap(18, 18, 18)
                .addComponent(BtnSave)
                .addGap(18, 18, 18)
                .addComponent(BtnClear)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAddress, txtContactNumber, txtID, txtName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAdd, BtnBack, BtnClear, BtnDelete, BtnSave, BtnSearch});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        setVisible(false);
        SM_Menu form1 = new SM_Menu(userID);
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        try {
            supplier = s1.ViewSupplierEntry();
            System.out.println("Supplier Data: " + supplier);
        } 
        catch (IOException ex) {
            System.out.print(ex);
        }

        // Generate a new supplier ID
        String newSupId = s1.generateNewId();
        txtID.setText(newSupId);

        // Check if the generated ID is not a duplicate
        try {
            if (s1.CheckDuplicate(newSupId)) {
                JOptionPane.showMessageDialog(null, "ItemID is already in use. Please try again.", "Duplicate ItemID", JOptionPane.ERROR_MESSAGE);
                System.out.println("Duplicate ID detected");
                return;
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while checking for duplicates. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error checking for duplicates: " + ex.getMessage());
            return;
        }

        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtContactNumber.getText().isEmpty() || txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            System.out.println("Required fields are empty");
            return;
        }

        // If everything is valid, proceed to add the item
        id = newSupId; // Use the generated ID
        name = txtName.getText();
        contactNumber = txtContactNumber.getText();
        address = txtAddress.getText();

        try {
            String status = s1.AddSupplierEntry(id, name, contactNumber, address);
            if (status.equals("SUCCESSFUL")) {
                JOptionPane.showMessageDialog(null, "Supplier successfully added.", "Supplier added status", JOptionPane.INFORMATION_MESSAGE);
                txtID.setText(null);
                txtID.setEnabled(true);
                txtID.setFocusable(true);
                txtName.setText(null);
                txtContactNumber.setText(null);
                txtAddress.setText(null);
                jTable1.clearSelection();
                model.setRowCount(0);
                System.out.println("Before ViewSupplierTable");
                this.ViewSupplierTable();
                System.out.println("After ViewSupplierTable");
            } else {
                JOptionPane.showMessageDialog(null, "Supplier unsuccessfully added.\nPlease try again.", "Supplier added status", JOptionPane.ERROR_MESSAGE);
                System.out.println("Supplier not added successfully");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while adding the item. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error adding supplier: " + ex.getMessage());
        }

    }//GEN-LAST:event_BtnAddActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        int selectedRow = jTable1.getSelectedRow();
    
        if (selectedRow >= 0) {
            // A row is selected
            row = selectedRow;
            id = String.valueOf(model.getValueAt(row, 0));
            name = String.valueOf(model.getValueAt(row, 1));
            contactNumber = String.valueOf(model.getValueAt(row, 2));
            address = String.valueOf(model.getValueAt(row, 3));

            txtID.setText(id);
            txtID.setEnabled(false);
            txtID.setFocusable(false);
            txtName.setText(name);
            txtContactNumber.setText(contactNumber);
            txtAddress.setText(address);
        } 
        else {
            // No row is selected, you might want to clear the fields or take appropriate action
            row = -1;
            id = "";
            name = "";
            contactNumber = "";
            address = "";

            txtID.setText("");
            txtID.setEnabled(true);
            txtID.setFocusable(true);
            txtName.setText("");
            txtContactNumber.setText("");
            txtAddress.setText("");
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtContactNumber.getText().isEmpty() || txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the item
        }else{
            id = txtID.getText();
            name = txtName.getText();
            contactNumber = txtContactNumber.getText();
            address = txtAddress.getText();

            try {
                s1.EditSupplierEntry(id, name, contactNumber, address);
            } catch (IOException ex) {
                Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtID.setText(null);
            txtID.setEnabled(true);
            txtID.setFocusable(true);
            txtName.setText(null);
            txtContactNumber.setText(null);
            txtAddress.setText(null);
            jTable1.clearSelection();
            model.setRowCount(0);
            this.ViewSupplierTable();
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        id = txtID.getText();
        // Check if the required fields are empty
        if (txtName.getText().isEmpty() || txtContactNumber.getText().isEmpty() || txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the item
        }
        try {
            if (!s1.CheckDuplicate(id)){
                try {
                    s1.DeleteSupplierEntry(id);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Supplier ID does not exist.\n Please check again.", "Supplier ID not exists.",JOptionPane.INFORMATION_MESSAGE);
                }
                txtID.setText(null);
                txtID.setEnabled(true);
                txtID.setFocusable(true);
                txtName.setText(null);
                txtContactNumber.setText(null);
                txtAddress.setText(null);
                jTable1.clearSelection();
                model.setRowCount(0);
                this.ViewSupplierTable();
            }else{
                JOptionPane.showMessageDialog(null, "Item does not exist.\n Please check again.", "Item not exists.",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_ItemEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        jTable1.clearSelection();
        model.setRowCount(0);
        id = txtID.getText();
        try {
            if(!s1.CheckDuplicate(id)){
                this.ViewItemTable(id);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Supplier ID does not exist.\n Please check again.", "Supplier ID not exists.",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        txtID.setText(null);
        txtID.setEnabled(true);
        txtID.setFocusable(true);
        txtName.setText(null);
        txtContactNumber.setText(null);
        txtAddress.setText(null);
        jTable1.clearSelection();
        model.setRowCount(0);
        this.ViewSupplierTable();
    }//GEN-LAST:event_BtnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
