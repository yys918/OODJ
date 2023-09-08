/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyItemwiseSalesEntry implements Serializable{
    private String itemID;
    private int quantitySold;
    private String salesDate;
    private ArrayList<DailyItemwiseSalesEntry> dailyItemWiseSalesEntry = new ArrayList<DailyItemwiseSalesEntry>();
    private enum status{SUCCESSFUL, UNSUCCESSFUL;}
    
    public DailyItemwiseSalesEntry() {
    }
    
    public DailyItemwiseSalesEntry(String itemID, int quantitySold, String salesDate) {
        this.itemID = itemID;
        this.quantitySold = quantitySold;
        this.salesDate = salesDate;
    }
       
    @Override
    public String toString(){
        return itemID + " "+ quantitySold + " " + salesDate;
    }
    
    public ArrayList<DailyItemwiseSalesEntry> ViewDailyItemwiseSalesEntry() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Read a DailySalesEntry object
            try {
                DailyItemwiseSalesEntry entry = (DailyItemwiseSalesEntry) ois.readObject();
                dailyItemWiseSalesEntry.add(entry);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DailyItemwiseSalesEntry.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {//'FileNotFoundException' is a subclass of 'IO Exception'
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return dailyItemWiseSalesEntry;
    }     

    public String AddDailyItemwiseSalesEntry(String id, int quantity) throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat",true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(currentDate);
            
            DailyItemwiseSalesEntry d2 = new DailyItemwiseSalesEntry(id,quantity,date);
            // Write a delimiter (newline) before writing the object
            oos.write("\n".getBytes());
            oos.writeObject(d2);
            oos.close();
            fos.close();
            return String.valueOf(status.SUCCESSFUL);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return String.valueOf(status.UNSUCCESSFUL);
        }  
    }
    
    public String EditDailyItemwiseSalesEntry(String id, int quantity) throws IOException{
        // Read existing objects from the file into an ArrayList
        ArrayList<DailyItemwiseSalesEntry> entries = new ArrayList<>();
        try(
            FileInputStream fis = new FileInputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat");
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
            FileInputStream fis = new FileInputStream("C:\\Users\\yyun\\OneDrive - Asia Pacific University\\Documents\\Year 2\\Object Oriented Development with Java\\Assignment\\dailySalesEntry.dat");
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

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
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
