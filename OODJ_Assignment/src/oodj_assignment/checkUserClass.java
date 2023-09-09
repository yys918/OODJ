/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class checkUserClass {
    private String ID;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String email;
    private String role;
    private String pass;
    private int row;
    
    public checkUserClass(){
        
    }
    
    public checkUserClass(String ID, String name, String age, String gender, String address, String email,String role,String pass,int row){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.role = role;
        this.pass = pass;
        this.row = row;
    }
    
    public void loadUsersFromFile(String filename, DefaultTableModel model, int passwordColumnIndex) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line1;

        while ((line1 = br.readLine()) != null) {
            String[] data = line1.split(",");

            pass = data[passwordColumnIndex];
            System.out.println(pass);
            
            // Replace the password with asterisks
            //data[passwordColumnIndex] = "***";           
            model.addRow(data);
        }
        br.close();
    } catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
    }
}
    
    
    public void changeUserInformation() {
    String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";

    ArrayList<String> data = new ArrayList<>();

    // Read the data from the text file and store it in the ArrayList
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            data.add(line);
        }
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Make modifications to the selected row
    String modifiedRow = ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + role + "," + pass;

    // Update the data in the ArrayList
    data.set(row, modifiedRow);

    // Write the updated data back to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (String rowData : data) {
            writer.write(rowData);
            writer.newLine(); // Add a newline character after each row
        }

        JOptionPane.showMessageDialog(null, "Information change successfully");
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    /*
    public void changeUserInformation(){
        //System.out.println(ID + name + age + address+ email + pass);
        String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt"; 
        
        ArrayList<String> data = new ArrayList<>();
        
        // Read the data from the text file and store it in the ArrayList
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
 
            while ((line = reader.readLine()) != null) {
                data.add(line);               
            }
        } catch (IOException e) {
             System.out.println("Error: " + e.getMessage());
        }
        
        // Make modifications to the selected row
        String modifiedRow = ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + role + "," + pass; 
        //System.out.println("ID");
        // Update the data in the ArrayList
        data.set(row, modifiedRow);
        for (String element : data) {
                 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write all the updated data back to the file
            for (String rowData : data) {
                writer.write(rowData);
                writer.newLine(); // Add a newline character after each row
            }
            
            System.out.println("Data updated successfully.");
        } catch (IOException e) {
             System.out.println("Error: " + e.getMessage());
        }

        }   
    }
    */
    
    
    public void deleteUser(int row) {
    if (row < 0) {
        JOptionPane.showMessageDialog(null, "Error: Invalid row index.");
        return;
    }

    if (row == 0) {
        JOptionPane.showMessageDialog(null, "Error: This is an admin user and cannot be deleted.");
        return;
    }

    ArrayList<String> data = new ArrayList<>();
    String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";

    // Read the data from the text file and store it in the ArrayList
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
        return;
    }

    // Check if the row index is within the bounds of the ArrayList
    if (row >= 0 && row < data.size()) {
        // Remove the selected row from the ArrayList
        data.remove(row);

        // Write the updated data back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String rowData : data) {
                bw.write(rowData);
                bw.newLine(); // Add a newline character after each row
            }
            System.out.println("User deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "User delete successfully, please refresh and see the latest users");
        
        
    } else {
        JOptionPane.showMessageDialog(null, "Error: Please select a valid row to delete.");
    }
}
    
    /*
    public void deleteUser(int row) {
    if (row < 0) {
        JOptionPane.showMessageDialog(null, "Error: Invalid row index.");
        return;
    }

    if (row == 0) {
        //System.out.println("Error: This is an admin user and cannot be deleted.");
        JOptionPane.showMessageDialog(null,"Error: This is an admin user and cannot be deleted.");
        return;
    }

    ArrayList<String> data = new ArrayList<>();
    String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";

    // Read the data from the text file and store it in the ArrayList
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
        return;
    }

    // Check if the row index is within the bounds of the ArrayList
    if (row >= 0 && row < data.size()) {
        // The rest of your code for deleting the user
        // ...
    } else {
        System.out.println("Error: Please select a valid row to delete.");
    }
}
    */


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPass() {
        return pass;
    }
    
    public int getRow() {
        return row;
    }
       
}
    

