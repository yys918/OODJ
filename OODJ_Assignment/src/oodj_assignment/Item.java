
package oodj_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Item {
    private String id;
    private String name;
    private double price;
    private String supplierID;
    private ArrayList<String> items = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
       
    public Item() {
    }
    
    public String WriteToFile(ArrayList<String> values){
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i =0; i < values.size(); i++){
                bw.write(values.get(i).toString()+ "\n");
            }
            
            bw.close();
            fw.close();
            return String.valueOf(status.SUCCESSFUL);
        }    
        catch (IOException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public ArrayList ViewItemEntry() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            String[] tokens = new String[st.countTokens()];
            int i = 0;
            while (st.hasMoreTokens()) {
                tokens[i] = st.nextToken();
                i++;
            }
            items.add(Arrays.toString(tokens));
        }
        return items;
    }
    
    public boolean CheckDuplicate(String id) throws IOException{
        items = this.ViewItemEntry();
        for (String stuff : items) {
            if (items.equals(id)) {
                return true; // Duplicate found
            }
        }
        return false;
    }
    
    // Generate a new item ID
    public String generateNewId() {
        // Find the maximum ID from the existing items and increment it
        int maxId = 0;
        for (String itemStr : items) {
            String replace = itemStr.replace("[", "").replace("]", "");
            String[] tokens = replace.split(", ");
            System.out.println(tokens[0]);
            if (tokens.length >= 1) {
                String itemId = tokens[0].trim();
                try {
                    int currentId = Integer.parseInt(itemId.substring(1));// Extract the numeric part of the ID
                    System.out.println(currentId);
                    if (currentId > maxId) {
                        maxId = currentId;
                        System.out.println(maxId);
                    }
                } catch (NumberFormatException e) {
                    // Handle parsing errors if the ID format is invalid
                    // You may want to log an error or take appropriate action
                }
            }
        }
        // Increment the maximum ID and format it with "I" prefix
        return "I" + String.format("%04d", maxId + 1);
    }

    
    public String AddItemEntry(String id, String name, double price, int stock, String supplierID) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            String values[] = {id,name,String.valueOf(price),String.valueOf(stock),supplierID};
            bw.newLine();
            System.out.println(Arrays.toString(values));
            for (int i =0; i <values.length;i++){
                bw.write(values[i]);
                bw.write(" ");
            }
            bw.close();
            fw.close();
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
  
    public String EditItemEntry(String id, String name, double price, int stock, String supplierID) throws IOException{
        try{
            FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
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
                String []editedLine = {id,name,String.valueOf(price),String.valueOf(stock),supplierID};
                lines.set(editLineIndex, String.join(" ", editedLine));
            }
            
            this.WriteToFile(lines);
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteItemEntry(String id) throws IOException{
        try{
            FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
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
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
    
    
}
