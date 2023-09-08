/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminindiassignment;
import java.io.*;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

public class createUserClass {
    private int userCounter = 1;
    private Set<String> registeredUserIDs;
    private String name;
    private String password;
    private String role;
    private String address;
    private String email;
    private String age;
    private String gender;
    private String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";
    
    /*
    private boolean isNameRegistered(String Name){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[]parts = line.split(",");
                if(parts.length > 3 && parts[1].equals(Name)){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    */
    
    public boolean receiveTextPM(String name,String age, String gender, String address, String email, String password){
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;
        
        boolean uniqueIDGenerated = false;
        if(isNameRegistered(name)){
            JOptionPane.showMessageDialog(null,"Name is taken. Please choose a different name.", "Registration Failed", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
         while (!uniqueIDGenerated) {
            ID = String.format("USER%03d", userCounter);
            if (!isIDRegistered(ID)) { // Check if the generated ID is unique
                try {
                    FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + "pm" + "," + password + "\n");

                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                uniqueIDGenerated = true;
            } else {
                userCounter++;
            }
        }
        return true;
    }

    // Check if a username is already registered in the file
    private boolean isNameRegistered(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length > 1 && userData[1].equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if a generated user ID is already registered in the file
    private boolean isIDRegistered(String generatedID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length > 0 && userData[0].equals(generatedID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    
    
    
        /*
        int userCount = 1;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                userCount++;
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        }
        
        try{
            FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("U00" + userCount+ "," + name + ","+ age + "," + gender + ","+  address + ","+  email +  "," +  "pm" + "," + password + "\n");

            bw.close();
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    
    public void receiveTextSM(String name,String age, String gender, String address, String email, String password){
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;   
        
        int userCount = 1;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                userCount++;
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        }
        
        try{
            FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("U00" + userCount+ "," + name + ","+ age + "," + gender + ","+  address + ","+  email +  "," +  "pm" + "," +  password + "\n");

            bw.close();
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
