
package oodj_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Item {
    private String id;
    private String name;
    private double price;
    private String supplierID;
    private ArrayList<String> items = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    
    //one function for open and close file
    
    public Item() {
    }
    
    public String WriteToFile(ArrayList<String> values){
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i =0; i < values.size(); i++){
                bw.write(values.get(i).toString()+ "\n");
            }
            //can ommit cuz automatically close in try,catch function
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
    
    public String AddItemEntry(String id, String name, double price, int stock, String supplierID) throws IOException{
            try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                items.add(String.valueOf(st.nextToken()));
            }        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String EditItemEntry(String id, String name, double price, int stock, String supplierID) throws IOException{
            try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select which Item Sales Entry to be edit: ");
            String selected = sc.next();
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                items.add(String.valueOf(st.nextToken()));
            }        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteItemEntry(String id) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("Please enter the item ID to be deleted: ");
                String selected = sc.next();
                if (selected.startsWith("I")!= true ){
                    System.out.println("Item ID shall start with I follow with 6 digits.");
                    continue;
                }
                else{
                    break;
                }
            }
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                items.add(String.valueOf(st.nextToken()));
            }        
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
