
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Item {
    private String code;
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
                System.out.print(st.nextToken());
                items.add(String.valueOf(st.nextToken()));
            }
        }
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
