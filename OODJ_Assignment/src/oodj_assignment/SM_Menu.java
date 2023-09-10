/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

/**
 *
 * @author yyun
 */
public class SM_Menu extends javax.swing.JFrame {
    public String userID;
    /**
     * Creates new form SM_Menu
     */

    public SM_Menu(String userID) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        lblWelcome.setText("Welcome, " + userID);
        this.userID = userID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnItemEntry = new javax.swing.JButton();
        btnSupplierEntry = new javax.swing.JButton();
        btnDailyItemwiseSalesEntry = new javax.swing.JButton();
        btnPurchaseRequisition = new javax.swing.JButton();
        btnListOfPurchaserOrders = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        lblWelcome.setText("Welcome, ");

        btnItemEntry.setText("Item Entry");
        btnItemEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemEntryActionPerformed(evt);
            }
        });

        btnSupplierEntry.setText("Supplier Entry");
        btnSupplierEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierEntryActionPerformed(evt);
            }
        });

        btnDailyItemwiseSalesEntry.setText("Daily Item-wise Sales Entry");
        btnDailyItemwiseSalesEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailyItemwiseSalesEntryActionPerformed(evt);
            }
        });

        btnPurchaseRequisition.setText("Purchase Requisition");
        btnPurchaseRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseRequisitionActionPerformed(evt);
            }
        });

        btnListOfPurchaserOrders.setText("List of Purchaser Orders");
        btnListOfPurchaserOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListOfPurchaserOrdersActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnItemEntry)
                    .addComponent(btnSupplierEntry)
                    .addComponent(btnDailyItemwiseSalesEntry)
                    .addComponent(btnPurchaseRequisition)
                    .addComponent(btnListOfPurchaserOrders))
                .addGap(42, 42, 42)
                .addComponent(btnLogOut)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblWelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDailyItemwiseSalesEntry, btnItemEntry, btnListOfPurchaserOrders, btnPurchaseRequisition, btnSupplierEntry});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addGap(12, 12, 12)
                .addComponent(btnItemEntry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupplierEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDailyItemwiseSalesEntry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPurchaseRequisition)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListOfPurchaserOrders)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut)
                        .addGap(14, 14, 14))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDailyItemwiseSalesEntry, btnItemEntry, btnListOfPurchaserOrders, btnPurchaseRequisition, btnSupplierEntry});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemEntryActionPerformed
        setVisible(false);
        SM_ItemEntry form1 = new SM_ItemEntry(userID);
    }//GEN-LAST:event_btnItemEntryActionPerformed

    private void btnSupplierEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierEntryActionPerformed
        setVisible(false);
        SM_SupplierEntry form1 = new SM_SupplierEntry( userID);
    }//GEN-LAST:event_btnSupplierEntryActionPerformed

    private void btnDailyItemwiseSalesEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailyItemwiseSalesEntryActionPerformed
        setVisible(false);
        SM_DailyItemWiseSalesEntry form1 = new SM_DailyItemWiseSalesEntry(userID);
    }//GEN-LAST:event_btnDailyItemwiseSalesEntryActionPerformed

    private void btnPurchaseRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseRequisitionActionPerformed
        setVisible(false);
        SM_PurchaseRequisition form1 = new SM_PurchaseRequisition(userID);
    }//GEN-LAST:event_btnPurchaseRequisitionActionPerformed

    private void btnListOfPurchaserOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListOfPurchaserOrdersActionPerformed
        setVisible(false);
        SM_Order form1 = new SM_Order(userID);
        form1.show();
    }//GEN-LAST:event_btnListOfPurchaserOrdersActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        loginPage out = new loginPage();
        out.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDailyItemwiseSalesEntry;
    private javax.swing.JButton btnItemEntry;
    private javax.swing.JButton btnListOfPurchaserOrders;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPurchaseRequisition;
    private javax.swing.JButton btnSupplierEntry;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
