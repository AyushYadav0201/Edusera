/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import edusera.Business;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ingale.r
 */
public class Validations {
    
    public static boolean isNumeric(String str) { 
        try {  
          Integer.parseInt(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public static boolean isDouble(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public static boolean isLong(String str) { 
        try {  
          Long.parseLong(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public static boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isStringValid(String str){
        if(str == null || str.equals(""))
            return false;
        return true;
      
    }
    

    public static boolean isPhoneNumberValid(String phoneNumber) {
        String regex = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)\\s?\\d{3}-\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    
    }  
        
  public static boolean isValidPassword(String password) {
    String pattern = "^[a-zA-Z0-9]+.*$";  // Allows letters and digits at the beginning

    if (password.equals("") || password.length() < 8) {
        return false; // Minimum length requirement
    }

    if (!password.matches(pattern)) {
        return false; // Must start with a letter or digit
    }

    // Add more password validation rules here
    if (!containsUppercase(password)) {
        return false; // Requires at least one uppercase letter
    }

    if (!containsLowercase(password)) {
        return false; // Requires at least one lowercase letter
    }

    if (!containsDigit(password)) {
        return false; // Requires at least one digit
    }

    return true;
}

    public static boolean containsUppercase(String password) {
        return !password.equals(password.toLowerCase());
    }

    public static boolean containsLowercase(String password) {
        return !password.equals(password.toUpperCase());
    }

    public static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNuIDValid(String text, Business business) {
        return business.isNuId(text);
    }

    
}
