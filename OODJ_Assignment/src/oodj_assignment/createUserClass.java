/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.*;
import java.util.Scanner;


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
    
    public void receiveTextPM(String name,String age, String gender, String address, String email, String password) throws FileNotFoundException, IOException{
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;

        try {
            FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + "pm" + "," + password + "\n");

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
    
    public void receiveTextSM(String name,String age, String gender, String address, String email, String password) throws FileNotFoundException, IOException{
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;

        try {
            FileWriter fw = new FileWriter("D:\\APU SCHOOL LIFEE\\Degree Year 2\\OODJ\\textFile\\user.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ID + "," + name + "," + age + "," + gender + "," + address + "," + email + "," + "sm" + "," + password + "\n");

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
