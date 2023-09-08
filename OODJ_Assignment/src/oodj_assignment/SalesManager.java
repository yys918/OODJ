package oodj_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    private ArrayList<String> purchaseRequisition = new ArrayList<String>();
    private ArrayList<String> purchaseOrder = new ArrayList<String>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    
    
    public SalesManager(){

    }
       //Arrays.toString(dailyItemWiseSalesEntry.toArray())
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
     

    
    public ArrayList ViewPurchaseRequisition() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print the line for debugging
            String []values = line.split(" ");
            purchaseRequisition.add(Arrays.toString(values));
        }
        return purchaseRequisition;
    }
    
    public String AddPurchaseRequisition() throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                purchaseRequisition.add(String.valueOf(st.nextToken()));
            }        
              return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String EditPurchaseRequisition() throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select which Item Sales Entry to be edit: ");
            String selected = sc.next();
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                purchaseRequisition.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeletePurchaseRequisition() throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("Please enter the item ID to be deleted: ");
                String selected = sc.next();
                if (selected.startsWith("I")!= true ){
                    System.out.println("Item ID shall start with I follow with 6 digits.");
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
                purchaseRequisition.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }    
    
    public ArrayList ViewRequisition() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseRequisition.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print the line for debugging
            String []values = line.split(" ");
            purchaseRequisition.add(Arrays.toString(values));
        }
        return purchaseRequisition;
    }
    
    public ArrayList ViewListOfPurchaseOrders() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\purchaseOrder.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print the line for debugging
            String []values = line.split(" ");
            purchaseOrder.add(Arrays.toString(values));
        }
        return purchaseOrder;
    }

    
}
