/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DailyItemwiseSalesEntry implements Serializable{
    private String itemID;
    private int quantitySold;
    private Date salesDate;
    private ArrayList<String> dailyItemWiseSalesEntry = new ArrayList<String>();
    
    public DailyItemwiseSalesEntry(String itemID, int quantitySold, Date salesDate) {
        this.itemID = itemID;
        this.quantitySold = quantitySold;
        this.salesDate = salesDate;
    }
    
    public void WriteToFile( ArrayList<String> values){
        try{
            FileOutputStream fos = new FileOutputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i =0; i < values.size(); i++){
                bws.write(values.get(i).toString()+ "\n");
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
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            String[] tokens = new String[st.countTokens()];
            int i = 0;
            while (st.hasMoreTokens()) {
                tokens[i] = st.nextToken();
                i++;
            }
            dailyItemWiseSalesEntry.add(Arrays.toString(tokens));
        }        
        //Arrays.toString(dailyItemWiseSalesEntry.toArray())
        return dailyItemWiseSalesEntry;
    }

    
    public String AddDailyItemwiseSalesEntry(String id, String name, double price, int quantity, String supplierID) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
        
    }
    
    public String EditDailyItemwiseSalesEntry(String id, String name, double price, int quantity, String supplierID) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select which Item Sales Entry to be edit: ");
            String selected = sc.next();
            String line = "";
            StringTokenizer st = new StringTokenizer(line,"\n");
            while(st.hasMoreTokens()){
                String value[] = new String[st.countTokens()];//set them to array
                dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteDailyItemwiseSalesEntry(String id) throws IOException{
        try{
            FileWriter fw = new FileWriter("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.txt");
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
                dailyItemWiseSalesEntry.add(String.valueOf(st.nextToken()));
            }        
                return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
}
