/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PMView {
    public PMView(){}
    //file path
    String itemPath = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt";
    String supplierPath = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\supplier.txt";
    String requisitionPath = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\requisition.txt";
    String orderPath = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\order.txt";
    
            
    
    public void ViewItem(String filename, DefaultTableModel model){
        try{
            FileReader fr = new FileReader(itemPath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null){
                //Split
                String []data = line.split(" ");
                model.addRow(data);            
            }

            fr.close();            
        } 
        catch(Exception e){
            System.out.println(e);
        }
    } 
    
    public void ViewSuppliers(String filename, DefaultTableModel model){
        try{
            FileReader fr = new FileReader(supplierPath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null){
                //Split
                String []data = line.split("\\|");
                model.addRow(data);            
            }

            fr.close();            
        } 
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    
    public void ViewRequisition(String filename, DefaultTableModel model){
        try{
            FileReader fr = new FileReader(requisitionPath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null){
                //Split
                String []data = line.split(",");
                model.addRow(data);            
            }

            fr.close();            
        } 
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    
    public void ViewOrder(String filename, DefaultTableModel model){
        try{
            FileReader fr = new FileReader(orderPath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null){
                //Split
                String []data = line.split(","); 
                model.addRow(data);
            }
            fr.close();        
            
        } 
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
