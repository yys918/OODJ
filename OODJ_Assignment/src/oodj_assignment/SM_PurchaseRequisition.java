
package oodj_assignment;


import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author yyun
 */
public class SM_PurchaseRequisition extends javax.swing.JFrame {
    
    //jtable1
    private DefaultTableModel model;
    private String [] columnsName = {"ID","Item ID","Name","Quantity","Total Amount (RM)","Request Delivery Date","Sales Manager ID","Supplier ID"};
    private int row = -1;
    
    private JTable lastSelectedTable = null;
    SM_Menu f1 = new SM_Menu();
    String SMid = f1.userID;
    /**
     * Creates new form SM_PurchaseRequisition
     */
    public SM_PurchaseRequisition() {
        this.model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells in jTable1 non-editable
                return false;
            }
        };
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        model.setColumnIdentifiers(columnsName);
        //display text file data to table (Order List)
        SalesManager req = new SalesManager(); //create an object from PM class        
        req.ViewPurchaseRequisition("requisition.txt",model);//call method from PM class        
        jTable1.setModel(model);//display data
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set single selection mode
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnClear = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        BtnAdd = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDDate = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        txtDDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel1.setText("Purchase Requisition ");

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Name");

        jLabel3.setText("Quantity");

        jLabel4.setText("Total Amount (RM)");

        lblDDate.setText("Request Delivery Date");

        txtDDate.setForeground(new java.awt.Color(153, 153, 153));
        txtDDate.setText("dd/mm/yyyy");
        txtDDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDDateFocusLost(evt);
            }
        });

        jLabel5.setText("Item ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(318, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(BtnAdd)
                        .addGap(99, 99, 99))
                    .addComponent(BtnBack, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblDDate)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(BtnSave))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnClear)))
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(299, 299, 299))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDDate)
                                    .addComponent(txtDDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAdd)
                            .addComponent(BtnSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnDelete)
                            .addComponent(BtnClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBack)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // back to main
        SM_Menu form1 = new SM_Menu(SMid);
        this.dispose();
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // Add requisition
        String name = txtName.getText();
        String quantity = txtQuantity.getText();
        String amount = txtAmount.getText();
        String Ddate = txtDDate.getText();
        String ItemID = txtItemID.getText();
        
         try {
            //check empty name
            SalesManager n = new SalesManager();
                if (!n.isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty.");
                return; // Exit the method if the name is empty
            }
            //check item id
            SalesManager s = new SalesManager();
            if (!s.isValidItemID(ItemID)) {
                JOptionPane.showMessageDialog(null, "Item ID must be in the format I##### (e.g., I1233).");
                return; // Exit the method if the supplier ID format is invalid
            }
             
             //Check the date format
            SalesManager date = new SalesManager();
            if (!date.isValidDateFormat(Ddate)) {
            JOptionPane.showMessageDialog(null, "Delivery Date must be in the format dd/mm/yyyy.");
            return; // Exit the method if the date format is invalid
            }
            Item sup = new Item();
            sup.getId();
            // Attempt to parse quantity as an integer
            int parsedQuantity = Integer.parseInt(quantity);
            double parsedamount = Double.parseDouble(amount);

            // Valid numeric input, proceed to add
            SalesManager add = new SalesManager();
            String generatedID = add.AddPurchaseRequisition(name, quantity, amount, Ddate, ItemID);
            if (generatedID != null) {
                // Create an array to store the values from text fields
                String[] values = {generatedID,ItemID, name, quantity, amount, Ddate };

                // Add row to jTable1
                model.addRow(values);

                // Clear the text fields
                txtName.setText("");
                txtQuantity.setText("");
                txtAmount.setText("");
                txtDDate.setText("");
                txtItemID.setText("");

                // Save the changes to the text file
                SalesManager obj1 = new SalesManager();
                obj1.Save(jTable1, "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\requisition.txt");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Failed to generate a unique ID.");
            }


        } 
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Input.");        
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // selected row
        row = jTable1.getSelectedRow();
        
        //get values from the column
        
        String ItemID = String.valueOf(model.getValueAt(row, 1));
        String name = String.valueOf(model.getValueAt(row, 2));        
        String quantity = String.valueOf(model.getValueAt(row, 3));
        String amount = String.valueOf(model.getValueAt(row, 4));
        String date = String.valueOf(model.getValueAt(row, 5));
        
        //set the value selected into the text field
        txtName.setText(name);
        txtQuantity.setText(quantity);
        txtAmount.setText(amount);
        txtDDate.setText(date);
        txtItemID.setText(ItemID);
        
        SalesManager obj1 = new SalesManager();
        obj1.Save(jTable1, "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\requisition.txt");
    }//GEN-LAST:event_jTable1MouseReleased

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        //Clear text field
        txtName.setText("");
        txtQuantity.setText("");
        txtAmount.setText("");
        txtDDate.setText("");
        txtItemID.setText("");
    }//GEN-LAST:event_BtnClearActionPerformed

    private void txtDDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDDateFocusGained
        // Set placeholder 
        if (txtDDate.getText().equals("dd/mm/yyyy")){
            txtDDate.setText("");
            txtDDate.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtDDateFocusGained

    private void txtDDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDDateFocusLost
        // Set Placeholder text
        if (txtDDate.getText().equals("")){
            txtDDate.setText("dd/mm/yyyy");
            txtDDate.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtDDateFocusLost

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // Edit        
        try {
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            } else {
                if (row == jTable1.getSelectedRow()) { // Only allow editing in jTable1
                    String name = txtName.getText();
                    String quantity = txtQuantity.getText();
                    String totalAmount = txtAmount.getText();
                    String DDate = txtDDate.getText();
                    String ItemID = txtItemID.getText();
                    //check empty name
                    SalesManager n = new SalesManager();
                    if (!n.isValidName(name)) {
                        JOptionPane.showMessageDialog(null, "Name cannot be empty.");
                        return; // Exit the method if the name is empty
                    }
                    //check item id
                    SalesManager s = new SalesManager();
                    if (!s.isValidItemID(ItemID)) {
                        JOptionPane.showMessageDialog(null, "Item ID must be in the format I#### (e.g., I1123).");
                        return; // Exit the method if the supplier ID format is invalid
                    }
                    
                    //Check the date format
                    SalesManager date = new SalesManager();
                    if (!date.isValidDateFormat(DDate)) {
                        JOptionPane.showMessageDialog(null, "Delivery Date must be in the format dd/mm/yyyy.");
                        return; // Exit the method if the date format is invalid
                    }

                    // Attempt to parse quantity as an integer
                    int parsedQuantity = Integer.parseInt(quantity);
                    double parsedamount = Double.parseDouble(totalAmount);

                    // Update value in the selected row
                    model.setValueAt(ItemID, row, 1);
                    model.setValueAt(name, row, 2);                    
                    model.setValueAt(quantity, row, 3);
                    model.setValueAt(totalAmount, row, 4);
                    model.setValueAt(DDate, row, 5);
                    

                    // Save the changes to the text file
                    SalesManager obj1 = new SalesManager();
                    obj1.Save(jTable1, "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\requisition.txt");

                    // Clear the text fields
                    txtName.setText("");
                    txtQuantity.setText("");
                    txtAmount.setText("");
                    txtDDate.setText("");
                    txtItemID.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Select an row");
                }
            }
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Input.");
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // Delete by clicking the row
        if (row != -1) {
            SalesManager deleted = new SalesManager();
            String repID = String.valueOf(model.getValueAt(row, 0)); // Get the repId

            String filePath = ("C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\requisition.txt");

            try {
                if (deleted.DeleteRequisition(model, repID, filePath)) {
                    row = -1; // Reset the last selected row
                    // If the deletion was successful, you may also want to refresh the JTable
                    jTable1.repaint(); // or jTable1.updateUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete data.");
                }
            } catch (Exception e) {
                // Handle any exceptions that may occur during the deletion process
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while deleting data: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a valid row.");
        }

        // Clear text fields
        txtName.setText("");
        txtQuantity.setText("");
        txtAmount.setText("");
        txtDDate.setText("");
        txtItemID.setText("");
    }//GEN-LAST:event_BtnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(SM_PurchaseRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SM_PurchaseRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SM_PurchaseRequisition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDDate;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDDate;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
