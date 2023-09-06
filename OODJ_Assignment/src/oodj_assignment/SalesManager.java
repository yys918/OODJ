package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Scanner;

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
    private ArrayList<String> purchaseOrder = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    
    
    public SalesManager(){

    }
    

    
    public void WriteToFile(String filename, ArrayList<String> values){
        try{
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i =0; i < values.size(); i++){
                bw.write(values.get(i).toString()+ "\n");
            }
            //can ommit cuz automatically close in try,catch function
            bw.close();
            fw.close();
        }    
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList ViewDailyItemwiseSalesEntry() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            System.out.println(line);//line to array
            StringTokenizer st = new StringTokenizer(line,"");
            while(st.hasMoreTokens()){
                String value[] = {"hi"};//set them to array
                dailyItemWiseSalesEntry.add(Arrays.asList(value));
                //dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }
        }
        //Arrays.toString(dailyItemWiseSalesEntry.toArray())
        return dailyItemWiseSalesEntry;
    }

    
    public String AddDailyItemwiseSalesEntry(String id, String name, double price, int quantity){
        Scanner sc = new Scanner(System.in);
        String line = "";
        StringTokenizer st = new StringTokenizer(line,"\n");
        while(st.hasMoreTokens()){
            String value[] = new String[4];//set them to array
            dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
        }
        
        dailyItemWiseSalesEntry.add(status);
        return status;
    }
    
    public ArrayList EditDailyItemwiseSalesEntry(){
        System.out.println("Please select which Item Sales Entry to be edit: ");
        Scanner sc = new Scanner(System.in);
        return dailyItemWiseSalesEntry;
    }
    
    public ArrayList DeleteDailyItemwiseSalesEntry(){
        System.out.println("Please select which Item Sales Entry to be delete: ");
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Please select which purchase requisition to be edit: ");
        Scanner sc = new Scanner(System.in);
        return purchaseRequisition;
    }
    
    public ArrayList DeletePurchaseRequisition(){
        System.out.println("Please select which purchase requisition to be delete: ");
        Scanner sc = new Scanner(System.in);
        return purchaseRequisition;
    }    
    
    public ArrayList ViewRequisition(){
        return purchaseRequisition;
    }
    
    public ArrayList ViewListOfPurchaseOrders(){
        return purchaseOrder;//return list or arraylist
    }

    
}
