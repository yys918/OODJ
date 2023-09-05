
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Item {
    
    public Item() throws FileNotFoundException{
    FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
    BufferedReader br = new BufferedReader(fr);
    }
    
    
}
