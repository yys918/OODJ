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
import java.util.Scanner;
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
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    
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
    
    public String AddSupplierEntry(String id, String name, String address) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                supplier.add(String.valueOf(st.nextToken()));
            }        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String EditSupplierEntry(String id, String name, double price, int stock, String supplierID) throws IOException{
            try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select which supplier Entry to be edit: ");
            String selected = sc.next();
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                supplier.add(String.valueOf(st.nextToken()));
            }        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteSupplierEntry(String id) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            while (true){
                String selected = id;
                if (selected.startsWith("S")!= true ){
                    System.out.println("Item ID shall start with S and follow with 6 digits.");
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
                supplier.add(String.valueOf(st.nextToken()));
            }        
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
}
