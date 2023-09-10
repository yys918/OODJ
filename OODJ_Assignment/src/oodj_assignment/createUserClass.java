/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.*;
import java.util.Scanner;
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
    private String filePath = "C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\user.txt";
    
    
    public static String lastID(){
         try {
            File file = new File("C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\user.txt");
            String id;
            try (Scanner scanner = new Scanner(file)) {
                id = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] details = line.split("/");
                    id = details[0]; // Update lastItemId with the latest item ID
                }
            }
            return id;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return ""; // Return a default value in case of an exception
        }
    }
    
    

    public static String generateNextId(String lastID) {
        // Parse the lastUserId to get the numeric part
        try {
            int numPart = Integer.parseInt(lastID.substring(2)) + 1;
            String numericStr = String.format("%03d", numPart);
            

            // Combine the prefix and numeric part to form the next ID
            ID =numericStr;
            return ID;
        } catch (NumberFormatException e) {
            // Handle parsing error if lastUserId doesn't have a valid numeric part
            return "Invalid";

        }
    }
    
    public boolean receiveTextAd(String name, String age, String gender, String address, String email, String password) throws IOException {
    this.name = name;
    this.password = password;
    this.address = address;
    this.email = email;
    this.age = age;
    this.gender = gender;
    ID = "U" + ID;
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
                if (ageValue < 18 || ageValue > 120) { // Adjust age validation range as needed
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age between 18 and 120.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number as age.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Additional nested conditions or actions can be placed here
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\user.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(ID + "/" + name + "/" + age + "/" + gender + "/" + address + "/" + email + "/" + "admin" + "/" + password + "\n");

                bw.close();
                fw.close();

            } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
                return false; // Return false if an error occurs during file writing
            }

            JOptionPane.showMessageDialog(null, "User created successfully, please press back button to the main page");
            return true;
        }
    }
}
    
    
    public boolean receiveTextPM(String name, String age, String gender, String address, String email, String password) throws IOException {
    this.name = name;
    this.password = password;
    this.address = address;
    this.email = email;
    this.age = age;
    this.gender = gender;
    ID = "PM" + ID;
    
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
                if (ageValue < 18 || ageValue > 120) { // Adjust age validation range as needed
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age between 18 and 120.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number as age.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Additional nested conditions or actions can be placed here
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\user.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(ID + "/" + name + "/" + age + "/" + gender + "/" + address + "/" + email + "/" + "pm" + "/" + password + "\n");

                bw.close();
                fw.close();

            } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
                return false; // Return false if an error occurs during file writing
            }

            JOptionPane.showMessageDialog(null, "User created successfully, please press back button to the main page");
            return true;
        }
    }
}
   
    
    public boolean receiveTextSM(String name, String age, String gender, String address, String email, String password) throws IOException {
    this.name = name;
    this.password = password;
    this.address = address;
    this.email = email;
    this.age = age;
    this.gender = gender;
    ID = "SM" + ID;
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
                if (ageValue < 18 || ageValue > 120) { // Adjust age validation range as needed
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age between 18 and 120.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number as age.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Additional nested conditions or actions can be placed here
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Asus\\OneDrive - Asia Pacific University\\Documents\\Degree Year 2\\Sem 1\\Object Oriented Development With Java (OODJ)\\Assingment\\Assignment\\user.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(ID + "/" + name + "/" + age + "/" + gender + "/" + address + "/" + email + "/" + "sm" + "/" + password + "\n");

                bw.close();
                fw.close();

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false; // Return false if an error occurs during file writing
            }

            JOptionPane.showMessageDialog(null, "User created successfully, please press back button to the main page");
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
                String[] parts = line.split("/");
                if(parts[1].equals(usernameToCheck)){
                    return true;
                }
            }
        }catch(IOException e){
             System.out.println("Error: " + e.getMessage());
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
