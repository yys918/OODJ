/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author yyun
 */
public class Supplier {
    private String ID;
    private String name;
    private String address;
    private ArrayList<String> supplier = new ArrayList<String>();
    
    public ArrayList ViewSupplierEntry() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                System.out.print(st.nextToken());
                supplier.add(String.valueOf(st.nextToken()));
            }
        }
        return supplier;
    }
    
    public ArrayList AddSupplierEntry(){
        return supplier;
    }
    
    public ArrayList EditSupplierEntry(){
        return supplier;
    }
    
    public ArrayList DeleteSupplierEntry(){
        return supplier;
    }
}
