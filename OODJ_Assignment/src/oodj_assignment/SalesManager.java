package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Item Entry (Add/Save/Delete/Edit) 
 * Supplier Entry (Add/Save/Delete/Edit)
 * Daily Item-wise Sales Entry (Add/Save/Delete/Edit) 
 * Create a Purchase Requisition (Add/Save/Delete/Edit) 
 * Display Requisition (View) 
 * List of Purchaser Orders(View)
 */
public class SalesManager {
    
    private ArrayList<String> purchaseRequisition = new ArrayList<String>();
    private ArrayList<String> purchaseOrder = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    private String prFileName = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\requisition.txt";
    
    public SalesManager(){}
    
        
    public boolean isValidName(String name) {
        // Check if the name is not empty and does not consist of only whitespace characters
        return !name.trim().isEmpty();
    }
    
    public boolean isValidItemID(String supplierID) {//check item id
        // Define a regex pattern for the supplier ID format I#### (I followed by 4 digits)
        String supplierIDPattern = "^I\\d{4}$";

        // Check if the input matches the regex pattern
        return supplierID.matches(supplierIDPattern);
    }
    
    public boolean isValidSupplierID(String supplierID) {//check supplier id
        // Define a regex pattern for the supplier ID format S#### (S followed by 4 digits)
        String supplierIDPattern = "^S\\d{4}$";

        // Check if the input matches the regex pattern
        return supplierID.matches(supplierIDPattern);
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

    
    public void ViewPurchaseRequisition(String filename, DefaultTableModel model) {
        try{
            FileReader fr = new FileReader(prFileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //Split with ","
                String []data = line.split(","); 
                model.addRow(data);
            }
            
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    
    public String AddPurchaseRequisition(String name, String quantity, String amount, String orderdate,String userID, String SupplierID) {
        try {
            File file = new File("requisition.txt");

            // Check if the file is empty or does not exist
            if (!file.exists() || file.length() == 0) {
                // The file is empty or does not exist, so set a default value for the new order ID
                String newID = "R0001"; // You can adjust the default value as needed

                // Create the new order data line
                String newOrderData = newID + "," + name + "," + quantity + "," + amount + "," + orderdate + "," + SupplierID;

                // Write the new data to the file
                BufferedWriter bw = new BufferedWriter(new FileWriter("requisition.txt"));
                bw.write(newOrderData);
                bw.newLine();
                bw.close();

                return newID;
            }

            // The file is not empty, proceed with reading and updating the ID
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("requisition.txt"));
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
                String newOrderData = newID + "," + name + "," + quantity + "," + amount + "," + orderdate + "," + SupplierID;


                // Append the new data to the ArrayList
                lines.add(newOrderData);

                // Write all lines (including the new ID) back to the file
                BufferedWriter bw = new BufferedWriter(new FileWriter("requisition.txt"));
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
                bw.close();

                return newID;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    
    public String EditPurchaseRequisition() throws IOException{
        try{
            FileWriter fw = new FileWriter(prFileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select which Item Sales Entry to be edit: ");
            String selected = sc.next();
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                purchaseRequisition.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public boolean DeleteRequisition(DefaultTableModel tableModel, String orderId, String filePath) {
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
                JOptionPane.showMessageDialog(null, "Requisition with ID " + orderId + " not found.");
            }
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed to delete data from the file: " + e.getMessage());
        }
        return false; // Order not found or deletion failed
    }   
    
    public ArrayList ViewRequisition() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(prFileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print the line for debugging
            String []values = line.split(" ");
            purchaseRequisition.add(Arrays.toString(values));
        }
        return purchaseRequisition;
    }
    
    public ArrayList ViewListOfPurchaseOrders() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\order.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print the line for debugging
            String []values = line.split(" ");
            purchaseOrder.add(Arrays.toString(values));
        }
        return purchaseOrder;
    }

    
}
