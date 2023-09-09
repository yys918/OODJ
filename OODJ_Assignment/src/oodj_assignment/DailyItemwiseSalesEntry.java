
package oodj_assignment;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//TOtal daily & update stock
/**
 *
 * @author yyun
 */
public class DailyItemwiseSalesEntry implements Serializable{
    private String itemID, itemName;
    private int quantitySold;
    private String salesDate;
    private ArrayList<DailyItemwiseSalesEntry> dailyItemWiseSalesEntry = new ArrayList<DailyItemwiseSalesEntry>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    private final String filename = "C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat";
    private static final long serialVersionUID = 4049679065376427895L;//To maintain compatibility
    
    public DailyItemwiseSalesEntry() {
    }
    
    public DailyItemwiseSalesEntry(String itemID,String itemName, int quantitySold, String salesDate) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantitySold = quantitySold;
        this.salesDate = salesDate;
    }
       
    @Override
    public String toString(){
        return itemID + "" + itemName + " "+ quantitySold + " " + salesDate;
    }
    
    public boolean checkFileExists(){
        File file = new File(filename);
        if (file.exists()) {
            if (file.length() > 0) {
                return true;
            } else {
                // Handle the case when the file is empty
                JOptionPane.showMessageDialog(null, "File is empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            // Handle the case when the file doesn't exist
            JOptionPane.showMessageDialog(null, "File does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean checkDuplicateDate(String date){
        dailyItemWiseSalesEntry = this.ViewDailyItemwiseSalesEntry();
        for (DailyItemwiseSalesEntry entry : dailyItemWiseSalesEntry) {
            if (entry.getSalesDate().equals(date)) {
                return true; // Duplicate found
            }
        }
        return false;
    }
    
    public boolean checkDuplicateItemID(String id){
        dailyItemWiseSalesEntry = this.ViewDailyItemwiseSalesEntry(); 
        for (DailyItemwiseSalesEntry entry : dailyItemWiseSalesEntry) {
            if (entry.getItemID().equals(id)) {
                JOptionPane.showMessageDialog(null, "Item ID exists.\nPlease use 'edit' function.", "Item ID exists", JOptionPane.INFORMATION_MESSAGE);
                return true; // Duplicate found
            }
        }
        return false;
    }
    
    public boolean checkStock(String id, int quantity) throws IOException{
        ArrayList<String> items = new ArrayList<>();
        Item i1 = new Item();
        int stock = i1.checkStock(id);
        System.out.println("Stock here is " + stock);
        switch(stock){
            case -1 -> {
                JOptionPane.showMessageDialog(null, "Item not found\nPlease check again.", "Item error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            case -2 -> {
                JOptionPane.showMessageDialog(null, "Item stock not found.\nPlease check again.","Item Stock error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            default -> {
                if(stock<=0){
                    JOptionPane.showMessageDialog(null, "Item stock invalid.\nPlease check again.","Item Stock Invalid",JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    return true;
                }
            }
        }  
    }
    
    public ArrayList<DailyItemwiseSalesEntry> ViewDailyItemwiseSalesEntry() {//throws StreamCorruptedException
        dailyItemWiseSalesEntry.clear();
        if(this.checkFileExists()){
            try {
                
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                try{ 
//                    int result = ois.readInt();//error here
                    System.out.println("I am here");
//                    System.out.println(String.valueOf(result));
                    // Read a DailySalesEntry obtry {
//                        for(int i =0; i <=result; i++){
    //                        ois.skipBytes(1);
    //                        DailyItemwiseSalesEntry entry = ;
                    Object obj = ois.readObject();
                    if(obj instanceof DailyItemwiseSalesEntry dailyItemwiseSalesEntry)
                            dailyItemWiseSalesEntry.add(dailyItemwiseSalesEntry);
                            System.out.println(Arrays.toString(dailyItemWiseSalesEntry.toArray()));

//                        }
                    }catch (ClassNotFoundException ex) {
                        Logger.getLogger(DailyItemwiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (StreamCorruptedException sce) {
                        // Handle StreamCorruptedException here
                        sce.printStackTrace(); // Print the exception details for debugging
                    } catch(EOFException eof){
                       //reach the end of file , no more object to read 
                      System.out.println("END OF FILE"); 
                      System.out.println(Arrays.toString(dailyItemWiseSalesEntry.toArray()));
                      return dailyItemWiseSalesEntry;
                    }
                    ois.close();
                    fis.close();
                }catch(EOFException eof){
                    System.out.println("END OF FILE11");
                    System.out.println(Arrays.toString(dailyItemWiseSalesEntry.toArray()));
                    return dailyItemWiseSalesEntry;
                } catch (FileNotFoundException e) {//'FileNotFoundException' is a subclass of 'IO Exception'
                    e.printStackTrace();
                    return dailyItemWiseSalesEntry;
                }catch (IOException e){
                    e.printStackTrace();
                    return dailyItemWiseSalesEntry;
                }
            }
        return dailyItemWiseSalesEntry;
    }     
    
    public String getCurrentDate(){
        LocalDate now = LocalDate.now();
        return String.valueOf(now); 
    }
    
    public ArrayList<String> getExistingDates(){
        ArrayList<String> dates = new ArrayList<>();
        
        dailyItemWiseSalesEntry = this.ViewDailyItemwiseSalesEntry();
        
        for(DailyItemwiseSalesEntry entry:dailyItemWiseSalesEntry){
            dates.add(entry.getSalesDate());
        }
        return dates;
    }

   public String AddDailyItemwiseSalesEntry(String id, String name, int quantity) throws IOException{
        if(this.checkDuplicateItemID(id)){
            JOptionPane.showMessageDialog(null, "Item has already added.\nPlease use 'edit' function", "Item ID exists", JOptionPane.ERROR_MESSAGE);
            return String.valueOf(status.UNSUCCESSFUL);            
        }else{
            try{
                FileOutputStream fos = new FileOutputStream(filename,true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                salesDate = this.getCurrentDate();
                DailyItemwiseSalesEntry d2 = new DailyItemwiseSalesEntry(id,name,quantity,salesDate);
                // Write a delimiter (newline) before writing the object
//                oos.write("\t".getBytes());
                oos.writeObject(d2);
                oos.close();
                fos.close();
                return String.valueOf(status.SUCCESSFUL);
            } catch (FileNotFoundException e){
                e.printStackTrace();
                return String.valueOf(status.UNSUCCESSFUL);
            } catch (java.io.StreamCorruptedException sce) {
                // Handle StreamCorruptedException here
                sce.printStackTrace(); // Print the exception details for debugging
            }
        }
        return "";
    }
    
    public String EditDailyItemwiseSalesEntry(String id, int quantity) throws IOException{
        // Read existing objects from the file into an ArrayList
        ArrayList<DailyItemwiseSalesEntry> entries = new ArrayList<>();
        try(
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)
            ){    
            while (fis.available() > 0) {
                // Read an object from the file
                DailyItemwiseSalesEntry entry = (DailyItemwiseSalesEntry) ois.readObject();
                entries.add(entry);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Find and edit the object based on a unique identifier (e.g., item ID or date)
        String targetItemId = id;
        for (DailyItemwiseSalesEntry entry : entries) {
            if (entry.getItemID().equals(targetItemId)) {
                // Modify the attributes of the found object
                entry.setQuantitySold(quantity); // Update the quantity sold, for example
                break; // Exit the loop once the object is found and edited
            }
        }

        // Write the updated objects back to the file
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (DailyItemwiseSalesEntry entry : entries) {
                oos.writeObject(entry);
            }
            return String.valueOf(status.SUCCESSFUL);
        } catch (IOException e) {
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }
    
    public String DeleteDailyItemwiseSalesEntry(String id) throws IOException{
        // Read existing objects from the file into an ArrayList
        ArrayList<DailyItemwiseSalesEntry> entries = new ArrayList<>();
        try(
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)
            ){    
            while (fis.available() > 0) {
                // Read an object from the file
                DailyItemwiseSalesEntry entry = (DailyItemwiseSalesEntry) ois.readObject();
                entries.add(entry);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Find and edit the object based on a unique identifier (e.g., item ID or date)
        String targetItemId = id;
        Iterator<DailyItemwiseSalesEntry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            DailyItemwiseSalesEntry entry = iterator.next();
            if (entry.getItemID().equals(targetItemId)) {
                // Remove the object from the ArrayList
                iterator.remove();
            }
        }

        // Write the updated objects back to the file
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (DailyItemwiseSalesEntry entry : entries) {
                oos.writeObject(entry);
            }
            return String.valueOf(status.SUCCESSFUL);
        } catch (IOException e) {
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }
    
    
}

//for (DailySalesEntry entry : dailySalesEntries) {
//    String itemID = entry.getItemID();
//    // Use the itemID as needed
//    System.out.println("Item ID: " + itemID);
//}
