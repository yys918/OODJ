
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Item {
    private String itemCode;
    private String itemName;
    private String supplierID;
    private ArrayList<String> items = new ArrayList<String>();
    //one function for open and close file
    public Item() throws FileNotFoundException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
    }
    
    public ArrayList ViewItemEntry() throws FileNotFoundException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
        //while tokenzer has token, add line to arraylist
        System.out.println(items);
        return items;
    }
    
    public ArrayList AddItemEntry(){
     //append to  
     return items;
    }
    
    public ArrayList EditItemEntry(){
        //Edit
        return items;
    }
    
    public ArrayList DltItemEntry(){
        //Delete
        
        return items;
    }
}
