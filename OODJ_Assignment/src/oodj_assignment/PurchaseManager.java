/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * List of Items (View)
 * List of Suppliers (View)
 * Display Requisition (View)
 * Generate Purchase Order (Add/Save/Delete/Edit)
 * List of Purchaser Orders (View)
 */
public class PurchaseManager {
    
    private String name,id,email,address,age,gender,password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String filePath = "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\order.txt";
   
    
    //Constructor
    public PurchaseManager(){}
    public PurchaseManager(String name,String quantity,String amount,String orderdate){} //add order constructor
    
    //Function
    public boolean isValidName(String name) {
        // Check if the name is not empty and does not consist of only whitespace characters
        return !name.trim().isEmpty();
    }
    
    public boolean isValidSupplierID(String supplierID) {//check supplier id
        // Define a regex pattern for the supplier ID format S#### (S followed by 4 digits)
        String supplierIDPattern = "^S\\d{4}$";

        // Check if the input matches the regex pattern
        return supplierID.matches(supplierIDPattern);
    }
    
    public boolean isValidSMID(String SMID) {//check sales manager id
        // Define a regex pattern for the supplier ID format SM##### (SM followed by 4 digits)
        String SMIDPattern = "^SM\\d{4}$";

        // Check if the input matches the regex pattern
        return SMID.matches(SMIDPattern);
    }

    public boolean isValidDateFormat(String dateStr) {//check date format
        // Define a regex pattern for the date format dd/mm/yyyy
        String dateFormatPattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        // Check if the input matches the regex pattern
        return dateStr.matches(dateFormatPattern);
    }
    public void Save(JTable table, String filePath) {//rewrite the latest data to file
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    row.append(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        row.append(",");
                    }
                }
                writer.write(row.toString());
                writer.newLine();
            }

            writer.close();
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public String AddOrder(String name,String quantity,String amount,String orderdate,String SupllierID){
        try {
            // Read all lines from the file into an ArrayList
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            // Extract the last line from the ArrayList (latest data)
            String latestLine = lines.get(lines.size() - 1);

            // Use a regular expression to extract the ID from the last line
            Pattern pattern = Pattern.compile("^([A-Z]+)(\\d+),");
            Matcher matcher = pattern.matcher(latestLine);

            if (matcher.find()) {
                // Extract the numeric part of the ID
                String numericPart = matcher.group(2);

                // Convert the numeric part to an integer, increment it, and format it with leading zeros
                int newNumericValue = Integer.parseInt(numericPart) + 1;
                String newNumericPart = String.format("%04d", newNumericValue); // 4 digits for the numeric part

                // Combine the string prefix and the new numeric part to create the new ID
                String newID = matcher.group(1) + newNumericPart;

                // Create the new order data line
                String newOrderData = newID + "," + name + "," + quantity + "," + amount + "," + orderdate + "," + SupllierID;

                // Append the new data to the ArrayList
                lines.add(newOrderData);

                // Write all lines (including the new ID) back to the file
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
                bw.close();

                return newID;
            }
        } 
        catch (IOException e) {
            System.out.println(e);
        }
        return null;  
    }
    
    
    public boolean DeleteOrder(DefaultTableModel tableModel, String orderId, String filePath) {
        try {
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();

            boolean found = false;

            for (int i = 0; i < lines.size(); i++) {
                String orderLine = lines.get(i);
                String[] orderData = orderLine.split(",");
                if (orderData.length >= 1 && orderData[0].equals(orderId)) {
                    lines.remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
                bw.close();

                // Find the row in the table based on orderId and remove it
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String tableOrderId = String.valueOf(tableModel.getValueAt(i, 0));
                    if (tableOrderId.equals(orderId)) {
                        tableModel.removeRow(i);
                        break;
                    }
                }

                return true; // Order successfully deleted
            } else {
                JOptionPane.showMessageDialog(null, "Order with ID " + orderId + " not found.");
            }
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed to delete data from the file: " + e.getMessage());
        }
        return false; // Order not found or deletion failed
    }   
    
    
}
