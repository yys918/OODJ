package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Item Entry (Add/Save/Delete/Edit) 
 * Supplier Entry (Add/Save/Delete/Edit)
 * Daily Item-wise Sales Entry (Add/Save/Delete/Edit) 
 * Create a Purchase Requisition (Add/Save/Delete/Edit) 
 * Display Requisition (View) 
 * List of Purchaser Orders(View)
 */
public class SalesManager {
    private ArrayList<String> dailyItemWiseSalesEntry = new ArrayList<String>();
    private ArrayList<String> purchaseRequisition = new ArrayList<String>();
    
    public SalesManager(){

    }
    
    public ArrayList ViewDailyItemwiseSalesEntry() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                System.out.print(st.nextToken());
                dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }
        }
        return dailyItemWiseSalesEntry;
    }
    
    public ArrayList AddDailyItemwiseSalesEntry(){
        return dailyItemWiseSalesEntry;
    }
    
    public ArrayList EditDailyItemwiseSalesEntry(){
        return dailyItemWiseSalesEntry;
    }
    
    public ArrayList ViewPurchaseRequisition() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                System.out.print(st.nextToken());
                dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }
        }
        return purchaseRequisition;
    }
    
    public ArrayList AddPurchaseRequisition(){
        return purchaseRequisition;
    }
    
    public ArrayList EditPurchaseRequisition(){
        return purchaseRequisition;
    }
    
    public ArrayList ViewRequisition(){
        return purchaseRequisition;
    }
    
    public ArrayList ViewListOfPurchaseOrders(){
        return purchaseRequisition;//return list or arraylist
    }

    
}
