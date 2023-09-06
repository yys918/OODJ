
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Item {
    private String id;
    private String name;
    private double price;
    private String supplierID;
    private ArrayList<String> items = new ArrayList<String>();
    //one function for open and close file
    public Item() throws FileNotFoundException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
    }
    
    public ArrayList ViewItemEntry() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                items.add(String.valueOf(st.nextToken()));
            }
        }
        return items;
    }
    
    public ArrayList AddItemEntry(String id, String name, double price, int stock, String supplierID){
        
     //append to  
     return items;
    }
    
    public ArrayList EditItemEntry(String id, String name, double price, int stock, String supplierID){
        //Edit
        return items;
    }
    
    public ArrayList DeleteItemEntry(String id, String name, double price, int stock, String supplierID){
        //Delete
        
        
        return items;
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
