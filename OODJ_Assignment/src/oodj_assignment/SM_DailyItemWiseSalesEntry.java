/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yyun
 */
public class SM_DailyItemWiseSalesEntry extends javax.swing.JFrame{
    private String userID;
    private DefaultTableModel model1 = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            // Make all cells in jTable1 non-editable
            return false;
        }
    };
    private String []dcolumnsName = {"Item ID", "Item Name", "Quantity Sold"};
    private int quantitySold;
    
    private DefaultTableModel model2 = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            // Make all cells in jTable1 non-editable
            return false;
        }
    };
    private String []icolumnsName = {"Item ID", "Item Name", "Price" ,"In Stock quantity"};
    private String itemID,itemName, stock, salesDate;
    private double itemPrice,total;
    private int row = -1;
    private ArrayList<DailyItemwiseSalesEntry> dailyItemWiseSalesEntry = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    DailyItemwiseSalesEntry d1 = new DailyItemwiseSalesEntry();
    private DefaultComboBoxModel<String> dateListModel = new DefaultComboBoxModel();
    Item i = new Item();
    
    /**
     * Creates new form SM_DailyItemWiseSalesEntry
     */
    public SM_DailyItemWiseSalesEntry(String userID) {
        initComponents();
        initTxtQuantitySoldDocumentListener();
        setVisible(true);
        setLocationRelativeTo(null);    
        this.LoadCmbBoxDateList();
        model2.setColumnIdentifiers(icolumnsName);
        this.LoadItemTable();
        txtItemID.setFocusable(false);
        txtItemID.setEnabled(false);
        txtItemName.setFocusable(false);
        txtItemName.setEnabled(false);
        txtStockLeft.setFocusable(false);
        txtStockLeft.setEnabled(false);
        this.userID = userID;
    }
    
    public void LoadItemTable(){
        model2.setRowCount(0);
        items.clear();
        try {
            items = i.ViewItemEntry();
            for ( String item : items){
               
            String[] tokens = item.substring(1, item.length() - 1).split(", ");

            if (tokens.length == 5) {
                itemID = tokens[0].trim();
                itemName = tokens[1].trim();
                itemPrice = Double.parseDouble(tokens[2].trim());
                stock = tokens[3].trim();
                Object[] data = {itemID, itemName,itemPrice,stock};
                model2.addRow(data);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_DailyItemWiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadCmbBoxDateList(){
        dateListModel.removeAllElements();
        ArrayList<String> existingDates = d1.getExistingDates(); // Replace this with your actual data source
        for (String date : existingDates) {
            dateListModel.addElement(date);
        }
    }
    
    public void ViewDailySalesEntry(String date){
       model1.setRowCount(0);
       dailyItemWiseSalesEntry.clear();
       model1.setColumnIdentifiers(dcolumnsName);
       dailyItemWiseSalesEntry = d1.ViewDailyItemwiseSalesEntry();
        for (DailyItemwiseSalesEntry entry : dailyItemWiseSalesEntry) {
            itemID = entry.getItemID();
            itemName = entry.getItemName();
            quantitySold = entry.getQuantitySold();
            salesDate = entry.getSalesDate();
            Object[] data = {itemID,itemName,quantitySold};
            model1.addRow(data);
        }
        jTable1.clearSelection();
        jTable2.clearSelection();
    }

    public boolean containsUnexpectedCharacters(String input) {
        // Define a pattern that allows only digits (0-9)
        String pattern = "\\d+";

        // Use regular expressions to check if the input matches the pattern
        return !input.matches(pattern);
    }   
    
    private boolean updateStock(){
        if(txtQuantitySold.getText().isEmpty() || txtItemID.getText().isEmpty() || txtItemName.getText().isEmpty() ){
            txtStockLeft.setText(null);
            System.out.println("no select lah");
            return false;
        } else if (jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Please select an item from the lower table.", "No item selected", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if (containsUnexpectedCharacters(txtQuantitySold.getText())){
            JOptionPane.showMessageDialog(null, "Please enter integer for quantity sold.", "Format Errer",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error again lah ");
            return false;
        }else{
                if (jTable2.getSelectedRow() == -1 || jTable2.getRowCount()<=0){
                    JOptionPane.showMessageDialog(null, "Please select an item from the lower table.", "No item selected", JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    row = jTable1.getSelectedRow(); 
                    itemID = txtItemID.getText();
                    quantitySold = Integer.parseInt(txtQuantitySold.getText());
                    try{
                        int currentStock = i.checkStock(itemID);
                        int soldStock =0;
                        try{
                            soldStock = Integer.parseInt(String.valueOf(model1.getValueAt(row, 2)));
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Nothing from the table lah");
                        }
                        int totalStock = currentStock + soldStock;
                        int updatedStock = totalStock - quantitySold;      
                        txtStockLeft.setText(String.valueOf(updatedStock));
                    } catch (java.lang.NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter integer for quantity sold.", "Format Errer",JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error le leh");
                    }catch(IOException e){
                        System.out.println("Item stock cannot found");
                        e.printStackTrace();
                    }
                    return true;
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        BtnAdd = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        txtQuantitySold = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CmbBoxDateList = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtItemName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtnClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtStockLeft = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        jLabel1.setText("Daily Item-wise Sales Entry");

        jLabel2.setText("Date:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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

        jTable1.setModel(model1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Item ID: ");

        jLabel4.setText("Quantity Sold: ");

        CmbBoxDateList.setModel(dateListModel
        );

        jTable2.setModel(model2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Item Name:");

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        jLabel6.setText("Stock Left:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbBoxDateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantitySold, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnSave)
                            .addComponent(BtnAdd)
                            .addComponent(BtnDelete)
                            .addComponent(btnSearch)
                            .addComponent(BtnBack)
                            .addComponent(BtnClear)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAdd, BtnBack, BtnClear, BtnDelete, BtnSave, btnSearch});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CmbBoxDateList, txtItemID, txtItemName, txtQuantitySold, txtStockLeft});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnBack)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(BtnSave)
                                .addGap(18, 18, 18)
                                .addComponent(BtnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(CmbBoxDateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQuantitySold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtStockLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAdd, BtnBack, BtnClear, BtnDelete, BtnSave, btnSearch});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbBoxDateList, txtItemID, txtItemName, txtQuantitySold, txtStockLeft});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initTxtQuantitySoldDocumentListener() {       
        txtQuantitySold.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStock();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStock(); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text components
            }
        });
    }
    
    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        setVisible(false);
        SM_Menu form1 = new SM_Menu(userID);
    }//GEN-LAST:event_BtnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        salesDate = (String)CmbBoxDateList.getSelectedItem();
        model1.setRowCount(0);
        this.ViewDailySalesEntry(salesDate);
        jTable1.clearSelection();
        jTable2.clearSelection();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        if(txtQuantitySold.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter quantity sold.", "Blank exist", JOptionPane.ERROR_MESSAGE);
            return;
        } else{
            itemID = txtItemID.getText();
            itemName = txtItemName.getText();
            quantitySold = Integer.parseInt(txtQuantitySold.getText());
            try {
                if(d1.checkStock(itemID, quantitySold)){
                   try {
                        d1.AddDailyItemwiseSalesEntry(itemID, itemName, quantitySold);
                        this.LoadCmbBoxDateList();
                        this.ViewDailySalesEntry(salesDate);
                   } catch (IOException ex) {
                       Logger.getLogger(SM_DailyItemWiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                this.clearAll();
            } catch (IOException ex) {   
                Logger.getLogger(SM_DailyItemWiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        jTable1.removeAll();
        this.ViewDailySalesEntry(d1.getCurrentDate());
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        salesDate = (String)CmbBoxDateList.getSelectedItem();
        row = jTable1.getSelectedRow();
        itemID = String.valueOf(model1.getValueAt(row, 0));
        quantitySold = Integer.parseInt(String.valueOf(model1.getValueAt(row, 2)));
        if (row<0){
            JOptionPane.showMessageDialog(null, "Please selected a row from the upper table.","Error in selecting row.",JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            try {
                d1.DeleteDailyItemwiseSalesEntry(itemID);
                this.LoadCmbBoxDateList();
                this.ViewDailySalesEntry(salesDate);
                i.EditItemStock(itemID, -quantitySold);
                this.clearAll(); 
            } catch (IOException ex) {
                Logger.getLogger(SM_DailyItemWiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        quantitySold = Integer.parseInt(txtQuantitySold.getText());
        itemID = txtItemID.getText();
        salesDate = (String)CmbBoxDateList.getSelectedItem();
        try {
            if(d1.checkStock(itemID, quantitySold)){
            d1.EditDailyItemwiseSalesEntry(itemID, quantitySold, salesDate);
            this.LoadItemTable();
            this.ViewDailySalesEntry(salesDate);
            this.clearAll();
            }
        } catch (IOException ex) {
            Logger.getLogger(SM_DailyItemWiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        row = jTable2.getSelectedRow(); 
        itemID = String.valueOf(model2.getValueAt(row, 0));
        itemName = String.valueOf(model2.getValueAt(row, 1));
        itemPrice = Double.parseDouble(String.valueOf(model2.getValueAt(row, 2)));
        stock = String.valueOf(model2.getValueAt(row, 3));
        txtItemID.setText(itemID);
        txtItemName.setText(itemName);
        txtQuantitySold.setText("");
        txtStockLeft.setText(stock);
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        row = jTable1.getSelectedRow(); 
        itemID = String.valueOf(model1.getValueAt(row, 0));
        itemName = String.valueOf(model1.getValueAt(row, 1));
        quantitySold = Integer.parseInt(String.valueOf(model1.getValueAt(row, 2)));
        txtItemID.setText(itemID);
        txtItemName.setText(itemName);
        txtQuantitySold.setText(String.valueOf(quantitySold));
        try {
            txtStockLeft.setText(String.valueOf(i.checkStock(itemID)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void clearAll(){
        txtItemID.setText(null);
        txtItemName.setText(null);
        txtQuantitySold.setText(null);
        txtStockLeft.setText(null);
        jTable1.clearSelection();
        jTable2.clearSelection();
    }

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        clearAll();
    }//GEN-LAST:event_BtnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSave;
    private javax.swing.JComboBox<String> CmbBoxDateList;
    private javax.swing.JButton btnSearch;
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
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtQuantitySold;
    private javax.swing.JTextField txtStockLeft;
    // End of variables declaration//GEN-END:variables
}
