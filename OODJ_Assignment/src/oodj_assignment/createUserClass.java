/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class createUserClass {
    
    private static String ID;
    private String name;
    private String password;
    private String role;
    private String address;
    private String email;
    private String age;
    private String gender;
    private String filePath = "D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt";
    
    
    public static String lastID(){
         try {
            File file = new File("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt");
            String id;
            try (Scanner scanner = new Scanner(file)) {
                id = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] details = line.split(",");
                    id = details[0]; // Update lastItemId with the latest item ID
                }
            }
            System.out.println(id);
            return id;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return ""; // Return a default value in case of an exception
        }
    }
    
    

    public static String PMgenerateNextId(String lastID) {
        // Parse the lastUserId to get the numeric part
        try {
            int numPart = Integer.parseInt(lastID.substring(2)) + 1;
            String numericStr = String.format("%03d", numPart);
            String idPrefix = "PM";

            // Combine the prefix and numeric part to form the next ID
            ID = idPrefix + numericStr;
            System.out.println(ID);
            return ID;
        } catch (NumberFormatException e) {
            // Handle parsing error if lastUserId doesn't have a valid numeric part
            return "Invalid";

        }
    }
    
    public boolean receiveTextPM(String name, String age, String gender, String address, String email, String password) throws IOException {
    this.name = name;
    this.password = password;
    this.address = address;
    this.email = email;
    this.age = age;
    this.gender = gender;

    // Validate the email format
    if (!isValidEmail(email)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
        return false;
    } else {
        // Check if the name is already registered
        if (isNameRegistered(name)) {
            JOptionPane.showMessageDialog(null, "Name is taken. Please choose a different name.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            // Validate age
            try {
                int ageValue = Integer.parseInt(age);
                if (ageValue < 0 || ageValue > 120) { // Adjust age validation range as needed
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age between 0 and 120.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age as a number.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Additional nested conditions or actions can be placed here
            try {
                FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + "pm" + "," + password + "\n");

                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
                return false; // Return false if an error occurs during file writing
            }

            JOptionPane.showMessageDialog(null, "User created successfully.");
            return true;
        }
    }
}
   
    public static String SMgenerateNextId(String lastID) {
        
        // Parse the lastUserId to get the numeric part
        try {
            int numPart = Integer.parseInt(lastID.substring(2)) + 1;
            String numericStr = String.format("%03d", numPart);

            String idPrefix = "SM";

            ID = idPrefix + numericStr;
            System.out.println(ID);
            return ID;
        } catch (NumberFormatException e) {
            // Handle parsing error if lastUserId doesn't have a valid numeric part
            return "Invalid";

        }
    }
   
    
    public boolean receiveTextSM(String name, String age, String gender, String address, String email, String password) throws IOException {
    this.name = name;
    this.password = password;
    this.address = address;
    this.email = email;
    this.age = age;
    this.gender = gender;

    // Validate the email format
    if (!isValidEmail(email)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
        return false;
    } else {
        // Check if the name is already registered
        if (isNameRegistered(name)) {
            JOptionPane.showMessageDialog(null, "Name is taken. Please choose a different name.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            // Validate age
            try {
                int ageValue = Integer.parseInt(age);
                if (ageValue < 0 || ageValue > 120) { // Adjust age validation range as needed
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age between 0 and 120.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age as a number.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Additional nested conditions or actions can be placed here
            try {
                FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + "sm" + "," + password + "\n");

                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
                return false; // Return false if an error occurs during file writing
            }

            JOptionPane.showMessageDialog(null, "User created successfully.");
            return true;
        }
    }
}
    
    private boolean isValidEmail(String email) {
       // Define a regex pattern for a simple email validation
       String emailPattern = "^.+@.+\\.com$";

       // Use the pattern to match the email
       return email.matches(emailPattern);
   }
    
     private boolean isNameRegistered(String usernameToCheck){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                System.out.println(parts[1]);
                if(parts[1].equals(usernameToCheck)){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
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
