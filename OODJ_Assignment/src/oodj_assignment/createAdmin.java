/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author tayya
 */
public class createAdmin extends javax.swing.JFrame {

    /**
     * Creates new form createAdmin
     */
    public createAdmin() {
        initComponents();
        setTitle("Create Admin");
        this.setSize(550, 550);
        this.setLocation(600,300);
        ButtonGroup gen = new ButtonGroup();
        gen.add(radMale);
        gen.add(radFemale);
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
        lblAge = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        txtAddress = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Password");

        lblAge.setText("Age:");

        jLabel2.setText("Confirm password");

        lblGender.setText("Gender:");

        lblAddress.setText("Address");

        lblEmail.setText("Email Address:");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        radMale.setText("Male");

        radFemale.setText("Female");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblName.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtConfirmPass))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblGender)
                            .addComponent(lblAge)
                            .addComponent(lblName))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radMale)
                                        .addGap(92, 92, 92)
                                        .addComponent(radFemale))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(radMale)
                    .addComponent(radFemale))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnBack))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new adminMainPage().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String name, address, email, age, gender, password;
        String holdGender = "";

        ButtonGroup gen = new ButtonGroup();
        gen.add(radMale);
        gen.add(radFemale);

        if (txtName.getText().equals("") ||
            txtAddress.getText().equals("") ||
            txtEmail.getText().equals("") ||
            txtAge.getText().equals("") ||
            txtPass.getText().equals("") ||
            (gen.getSelection() == null)) {

            JOptionPane.showMessageDialog(null, "Please enter all required information.");
        } else {
            if (radMale.isSelected()) {
                holdGender = radMale.getText();
            } else if (radFemale.isSelected()) {
                holdGender = radFemale.getText();
            }
            if (txtPass.getText().equals(txtConfirmPass.getText())) {
                name = txtName.getText();
                address = txtAddress.getText();
                email = txtEmail.getText();
                age = txtAge.getText();
                password = txtPass.getText();
                gender = holdGender;

                createUserClass obj1 = new createUserClass(name, "Admin", address, email, age,gender, password);
                String id = obj1.lastID();
                obj1.generateNextId(id);

                boolean userCreated = false;

                try {
                    userCreated = obj1.receiveTextAd(obj1);

                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Password and confirm password do not match. Please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnCreateActionPerformed

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
            java.util.logging.Logger.getLogger(createAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtConfirmPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
