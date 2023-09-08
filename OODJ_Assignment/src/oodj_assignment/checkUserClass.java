/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminindiassignment;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        e.printStackTrace();
    }
}
    
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
            e.printStackTrace();
        }
        
        //System.out.println(pass);
        //String selectedRow = data.get(row);

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
            System.out.println(e);
        }

        }   
    }
    
    public void deleteUser(){
       ArrayList<String> data = new ArrayList<>();
        String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";

        // Read the data from the text file and store it in the ArrayList
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Make modifications to the selected row
        String modifiedRow = "";

        // Update the data in the ArrayList
        data.set(row, modifiedRow);

        // Write the updated data back to the file without empty lines
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String rowData : data) {
                if (!rowData.isEmpty()) {
                    writer.write(rowData);
                    writer.newLine(); // Add a newline character after each row
                }
            }
            System.out.println("Data updated successfully.");
        } catch (IOException e) {
            System.out.println(e);
        } 
    }

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
       
}
    

