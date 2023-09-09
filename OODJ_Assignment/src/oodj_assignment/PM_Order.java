/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PM_Order extends javax.swing.JFrame {
    //Order list
    private DefaultTableModel model;
    private String [] columnsName = {"ID","Item ID","Name","Quantity","Total Amount (RM)","Request Order Date","Sales Manager ID","Supplier ID"};
    private int row = -1;
    private boolean isTable1Active = true; 
    
    //Requisition list
    private DefaultTableModel model2;
    private String [] columnsName2 = {"ID","Item ID","Name","Quantity","Total Amount (RM)","Request Order Date","Sales Manager ID","Supplier ID"};
    private int row2 = -1;
    
    // Keep track of the last selected table and row
    private JTable lastSelectedTable = null;
    private int lastSelectedRow = -1;

    /**
     * Creates new form PM_Order
     */
    public PM_Order() {
        this.model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells in jTable1 non-editable
                return false;
            }
        };
        this.model2 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells in jTable2 non-editable
                return false;
            }
        };
        

        initComponents();
        model.setColumnIdentifiers(columnsName);

        
        //display text file data to table (Order List)
        PMView order = new PMView(); //create an object from PM class        
        order.ViewOrder("order.txt",model);//call method from PM class        
        jTable1.setModel(model);//display data
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set single selection mode
        
        //Requisition
        model2.setColumnIdentifiers(columnsName2);
        PMView r = new PMView();
        r.ViewRequisition("requisition.txt", model2);
        jTable2.setModel(model2);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set single selection mode
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
        txtName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblRequisition = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOrderDate = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        lblSupID = new javax.swing.JLabel();
        txtSupID = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Order list");

        jLabel2.setText("Name");

        jLabel3.setText("Quantity");

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jTable2.setModel(model2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        lblRequisition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRequisition.setText("Requisition List");

        jLabel5.setText("Total Amount (RM)");

        jLabel6.setText("Order Date");

        txtOrderDate.setForeground(new java.awt.Color(153, 153, 153));
        txtOrderDate.setText("dd/mm/yyyy");
        txtOrderDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrderDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrderDateFocusLost(evt);
            }
        });

        lblSupID.setText("Supplier ID");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel4.setText("Item ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(77, 77, 77))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtItemID)
                                    .addGap(48, 48, 48)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(lblSupID))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(112, 112, 112))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRequisition))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSupID))
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblRequisition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // back to main
        PM_Main b = new PM_Main();
        b.show();
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Add order
        String name = txtName.getText();
        String quantity = txtQuantity.getText();
        String amount = txtTotalAmount.getText();
        String orderdate = txtOrderDate.getText();
        String SupplierID = txtSupID.getText();
        


        
         try {
            //check empty name
            PurchaseManager n = new PurchaseManager();
                if (!n.isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty.");
                return; // Exit the method if the name is empty
            }
            //check supplier id
            PurchaseManager s = new PurchaseManager();
            if (!s.isValidSupplierID(SupplierID)) {
                JOptionPane.showMessageDialog(null, "Supplier ID must be in the format S### (e.g., S123).");
                return; // Exit the method if the supplier ID format is invalid
            }
             
             //Check the date format
            PurchaseManager date = new PurchaseManager();
            if (!date.isValidDateFormat(orderdate)) {
            JOptionPane.showMessageDialog(null, "Order Date must be in the format dd/mm/yyyy.");
            return; // Exit the method if the date format is invalid
            }
            
            // Attempt to parse quantity as an integer
            int parsedQuantity = Integer.parseInt(quantity);
            double parsedamount = Double.parseDouble(amount);

            // Valid numeric input, proceed to add
            PurchaseManager add = new PurchaseManager();
            String generatedID = add.AddOrder(name, quantity, amount, orderdate, SupplierID);
            if (generatedID != null) {
                // Create an array to store the values from text fields
                String[] values = {generatedID, name, quantity, amount, orderdate, SupplierID};

                // Add row to jTable1
                model.addRow(values);

                // Clear the text fields
                txtName.setText("");
                txtQuantity.setText("");
                txtTotalAmount.setText("");
                txtOrderDate.setText("");
                txtSupID.setText("");

                // Remove the selected row from jTable2
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
                    tableModel2.removeRow(selectedRow);
                }

                // Save the changes to the text file
                PurchaseManager obj1 = new PurchaseManager();
                obj1.Save(jTable1, "order.txt");
                obj1.Save(jTable2, "requisition.txt");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Failed to generate a unique ID.");
            }


        } 
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Input.");        
        }

        

    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        lastSelectedTable = jTable1;
        isTable1Active = true;
        jTable2.clearSelection();
        
        // selected row
        lastSelectedRow = jTable1.getSelectedRow();
        txtName.setEditable(false);
        txtSupID.setEditable(false);
        txtItemID.setEditable(false);  
        
        //get values from the column
        String itemID = String.valueOf(model.getValueAt(lastSelectedRow, 1));
        String name = String.valueOf(model.getValueAt(lastSelectedRow, 2));
        String quantity = String.valueOf(model.getValueAt(lastSelectedRow, 3));
        String amount = String.valueOf(model.getValueAt(lastSelectedRow, 4));
        String date = String.valueOf(model.getValueAt(lastSelectedRow, 5));
        String supID = String.valueOf(model.getValueAt(lastSelectedRow, 6));
        
        
        //set the value selected into the text field
        txtName.setText(name);
        txtQuantity.setText(quantity);
        txtTotalAmount.setText(amount);
        txtOrderDate.setText(date);
        txtSupID.setText(supID);
        txtItemID.setText(itemID);       
     
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // delete by click the row   
        if (lastSelectedTable != null && lastSelectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) lastSelectedTable.getModel();
            PurchaseManager deleted = new PurchaseManager();
            String orderId = String.valueOf(tableModel.getValueAt(lastSelectedRow, 0)); // Get the orderId

            String filePath = "";

            if (lastSelectedTable == jTable1) {
                filePath = "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\order.txt";
            } 
            else if (lastSelectedTable == jTable2) {
                filePath = "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\requisition.txt";
            }

            if (deleted.DeleteOrder(tableModel, orderId, filePath)) {
                lastSelectedRow = -1; // Reset the last selected row
            } 
            else {
                JOptionPane.showMessageDialog(null, "Failed to delete data.");
            }
        } 
        else {
        JOptionPane.showMessageDialog(null, "Please select a valid row.");
        }

    // Clear text fields
    txtName.setText("");
    txtQuantity.setText("");
    txtTotalAmount.setText("");
    txtOrderDate.setText("");
    txtSupID.setText("");
    txtItemID.setText("");
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    // Edit
    try {
        if (lastSelectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        } else {
            if (lastSelectedTable == jTable1) { // Only allow editing in jTable1
                String name = txtName.getText();
                String quantity = txtQuantity.getText();
                String totalAmount = txtTotalAmount.getText();
                String orderDate = txtOrderDate.getText();
                String supplierID = txtSupID.getText();
                String itemID = txtItemID.getText();
                //check empty name
                PurchaseManager n = new PurchaseManager();
                    if (!n.isValidName(name)) {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty.");
                    return; // Exit the method if the name is empty
                }
                //check supplier id
                PurchaseManager s = new PurchaseManager();
                if (!s.isValidSupplierID(supplierID)) {
                    JOptionPane.showMessageDialog(null, "Supplier ID must be in the format S#### (e.g., S1123).");
                    return; // Exit the method if the supplier ID format is invalid
                }

                 //Check the date format
                PurchaseManager date = new PurchaseManager();
                if (!date.isValidDateFormat(orderDate)) {
                JOptionPane.showMessageDialog(null, "Order Date must be in the format dd/mm/yyyy.");
                return; // Exit the method if the date format is invalid
                }

                // Attempt to parse quantity as an integer
                int parsedQuantity = Integer.parseInt(quantity);
                double parsedamount = Double.parseDouble(totalAmount);

                // Update value in the selected row
                model.setValueAt(name, lastSelectedRow, 1);
                model.setValueAt(quantity, lastSelectedRow, 2);
                model.setValueAt(totalAmount, lastSelectedRow, 3);
                model.setValueAt(orderDate, lastSelectedRow, 4);
                model.setValueAt(supplierID, lastSelectedRow, 5);
                
                // Save the changes to the text file
                PurchaseManager obj1 = new PurchaseManager();
                obj1.Save(jTable1, "order.txt");

                // Clear the text fields
                txtName.setText("");
                txtQuantity.setText("");
                txtTotalAmount.setText("");
                txtOrderDate.setText("");
                txtSupID.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "You can only edit rows in Order List.");
            }
        }
    } 
    catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Input.");
    }

        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        lastSelectedTable = jTable2;
        isTable1Active = false;
        jTable1.clearSelection();
        
        // selected row
        lastSelectedRow = jTable2.getSelectedRow();
        txtName.setEditable(false);
        txtSupID.setEditable(false);
        txtItemID.setEditable(false); 
        
        //get values from the column
        String itemID = String.valueOf(model2.getValueAt(lastSelectedRow, 1));
        String name = String.valueOf(model2.getValueAt(lastSelectedRow, 2));
        String quantity = String.valueOf(model2.getValueAt(lastSelectedRow, 3));
        String amount = String.valueOf(model2.getValueAt(lastSelectedRow, 4));
        String date = String.valueOf(model2.getValueAt(lastSelectedRow, 5));
        String supID = String.valueOf(model2.getValueAt(lastSelectedRow, 6));
        
        
        //set the value selected into the text field
        txtName.setText(name);
        txtQuantity.setText(quantity);
        txtTotalAmount.setText(amount);
        txtOrderDate.setText(date);
        txtSupID.setText(supID);
        txtItemID.setText(itemID);
        

    }//GEN-LAST:event_jTable2MouseReleased

    private void txtOrderDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderDateFocusGained
        // Set placeholder 
        if (txtOrderDate.getText().equals("dd/mm/yyyy")){
            txtOrderDate.setText("");
            txtOrderDate.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtOrderDateFocusGained

    private void txtOrderDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderDateFocusLost
        // Set Placeholder text
        if (txtOrderDate.getText().equals("")){
            txtOrderDate.setText("dd/mm/yyyy");
            txtOrderDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtOrderDateFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Order List Report");
        MessageFormat footer = new MessageFormat("SIGMA SDN BHD (SSB) {0,number,integer}");
        try{
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header,footer,true,set,true);
            JOptionPane.showMessageDialog(null, "Printed Successfully");
        }
        catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(PM_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PM_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PM_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PM_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PM_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblRequisition;
    private javax.swing.JLabel lblSupID;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSupID;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
