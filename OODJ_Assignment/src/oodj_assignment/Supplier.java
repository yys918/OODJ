/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author yyun
 */
public class Supplier {
    private String id;
    private String name;
    private String contactNumber;
    private String address;
    private ArrayList<String> supplier = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    private String filename = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt";
    
    //Show item id supplied
    public String WriteToFile(ArrayList<String> values){
        try{
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i =0; i < values.size(); i++){
                bw.write(values.get(i)+ "\n");
            }
            bw.close();
            fw.close();
            return String.valueOf(status.SUCCESSFUL);
        }    
        catch (IOException e){
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public ArrayList<String> ViewSupplierEntry() throws FileNotFoundException, IOException {
        ArrayList<String> supplier = new ArrayList<>(); // Initialize the ArrayList

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|"); // Use "|" as the delimiter

                if (tokens.length >= 4) {
                    String id = tokens[0].trim();
                    String name = tokens[1].trim();
                    String contactNumber = tokens[2].trim();
                    String address = tokens[3].trim();

                    // Create a formatted string with the fields
                    String formattedSupplier = "[" + id + ", " + name + ", " + contactNumber + ", " + address + "]";

                    // Add the formatted supplier data to the ArrayList
                    supplier.add(formattedSupplier);
                }
            }
            fr.close();
        } 

        return supplier;
    }

    
    public boolean CheckDuplicate(String id) throws IOException{
        supplier = this.ViewSupplierEntry();
        for (String stuff : supplier) {
            if (stuff.equals(id)) {
                return true; // Duplicate found
            }
        }
        return false;
    }
    
    public String generateNewId() {
        //Update latest data
        try {
            supplier = ViewSupplierEntry();
        }
        catch (IOException e){
            System.out.println(e);
        }
        // Find the maximum ID from the existing items and increment it
        int maxId = 0;
        for (String SupplierEntry : supplier) {
            String cleanEntry = SupplierEntry.replace("[", "").replace("]", "");
            String[] tokens = cleanEntry.split(", ");
            
            if (tokens.length >= 1) {
                String itemId = tokens[0].trim();
                try {
                    int currentId = Integer.parseInt(itemId.substring(1));
                    System.out.println("Current ID: " + currentId);
                    if (currentId > maxId) {
                        maxId = currentId;
                        System.out.println("New Max ID: " + maxId);
                    }
                } catch (NumberFormatException e) {
                    // Handle parsing errors if the ID format is invalid
                    // You may want to log an error or take appropriate action
                    System.err.println("Error parsing ID: " + itemId);
                }
            }
        }
        // Increment the maximum ID and format it with "S" prefix
        String newId = "S" + String.format("%04d", maxId + 1);
        System.out.println("Generated ID: " + newId);
        return newId;   
    }

    // Helper function to join array elements with a separator
    private String joinWithSeparator(String[] array, String separator) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {// in this case then the last element won't have seperator+
                result.append(separator);
            }
        }
        return result.toString();
    }
        
    public String AddSupplierEntry(String id, String name, String contactNumber, String address) throws IOException{
        try{
            FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw = new BufferedWriter(fw);
            String values[] = {id,name,contactNumber, address};
            bw.newLine();
            String result = this.joinWithSeparator(values, "| ");
            for (int i =0; i <values.length;i++){
                bw.write(result);
                bw.write("| ");
            }
            bw.close();
            fw.close();        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
       
    public String EditSupplierEntry(String id, String name, String contactNumber, String address) throws IOException{
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            // Read the file into memory and find the lines to edit
            ArrayList<String> lines = new ArrayList<>();
            ArrayList<Integer> linesToEdit = new ArrayList<>();
            String line;
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                if (line.startsWith(id)) {
                    linesToEdit.add(lineIndex);
                }
                lineIndex++;
            }
            br.close();

            // Modify the lines in the ArrayList
            for (Integer editLineIndex : linesToEdit) {
                String []editedLine = {id,name,contactNumber, address};
                lines.set(editLineIndex, this.joinWithSeparator(editedLine, "| "));
            }
            
            this.WriteToFile(lines);
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteSupplierEntry(String id) throws IOException{
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            ArrayList<String> lines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
            fr.close();

            ArrayList<String> modifiedLines = new ArrayList<>();
            for (String fileLine : lines) {
                if (!fileLine.contains(id)) {
                    modifiedLines.add(fileLine);
                }               
            }
            this.WriteToFile(modifiedLines);
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
}
