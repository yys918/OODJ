/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

/**
 *
 * @author Asus
 */
public class PMCheck {
    public PMCheck(){}
    
    public boolean isValidName(String name) {
        // Check if the name is not empty and does not consist of only whitespace characters
        return !name.trim().isEmpty();
    }
    
    public boolean isValidItemID(String itemID) {
        // Define a regex pattern for the supplier ID format S#### (S followed by 4 digits)
        String itemIDPattern = "^I\\d{4}$";
        
        // Check if the input matches the regex pattern
        return itemID.matches(itemIDPattern);
    }
    
    public boolean isValidSupplierID(String supplierID) {//check supplier id
        // Define a regex pattern for the supplier ID format S#### (S followed by 4 digits)
        String supplierIDPattern = "^S\\d{4}$";

        // Check if the input matches the regex pattern
        return supplierID.matches(supplierIDPattern);
    }
    
    public boolean isValidSMID(String SMID) {//check sales manager id
        // Define a regex pattern for the supplier ID format SM##### (SM followed by 4 digits)
        String SMIDPattern = "^SM\\d{4}$";

        // Check if the input matches the regex pattern
        return SMID.matches(SMIDPattern);
    }

    public boolean isValidDateFormat(String dateStr) {//check date format
        // Define a regex pattern for the date format dd/mm/yyyy
        String dateFormatPattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        // Check if the input matches the regex pattern
        return dateStr.matches(dateFormatPattern);
    }
    
}
