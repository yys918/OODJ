package oodj_assignment;

import java.io.*;
import java.util.ArrayList;

/**
 * Item Entry (Add/Save/Delete/Edit) 
 * Supplier Entry (Add/Save/Delete/Edit)
 * Daily Item-wise Sales Entry (Add/Save/Delete/Edit) 
 * Create a Purchase Requisition (Add/Save/Delete/Edit) 
 * Display Requisition (View) 
 * List of Purchaser Orders(View)
 */
public class SalesManager {
    private String position;
    private String itemCode,itemName;
    private String supplierID,supplierName;
    
    public SalesManager(String position){
        this.position = position;
    
    }
    
    public ArrayList ViewItemEntry() throws FileNotFoundException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\item.txt");
        BufferedReader br = new BufferedReader(fr);
        
        
    }
    
    public ArrayList AddItemEntry(){
        String itemCode;
        String itemName;
        String supplierID;
    }
    
    public ArrayList EditItemEntry(){
        //Delete & Edit
    }
    
    public ArrayList ViewSupplierEntry(){
        
    }
    
    public ArrayList AddSupplierEntry(){
        
    }
    
    public ArrayList EditSupplierEntry(){
        //Delete & Edit
    }
    
    public ArrayList ViewDailyItemwiseSalesEntry(){
    }
    
    public ArrayList AddDailyItemwiseSalesEntry(){
    }
    
    public ArrayList EditDailyItemwiseSalesEntry(){
    }
    
    public ArrayList ViewPurchaseRequisition(){
    }
    
    public ArrayList AddPurchaseRequisition(){
    }
    
    public ArrayList EditPurchaseRequisition(){
    }
    
    public ArrayList ViewRequisition(){
    }
    
    public ArrayList ViewListOfPurchaseOrders(){
    }

    
}
