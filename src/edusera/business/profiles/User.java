/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.profiles;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ayush
 */
public class User {
    private String nuId;
    private String username;
    private String password;
    private boolean Active;
    private List<String> usedPasswords;
    private Person person;
    private Role role;
    private String salt = BCrypt.gensalt();

    public User(String nuId,String username, String password, Person person, Role role, boolean Active) throws Exception {
        this.usedPasswords = new ArrayList<>();
        this.nuId = nuId;
        this.username = username;
        this.setPassword(password);
        this.person = person;
        this.Active = Active;
        this.role = role;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
    
    public List<String> getUsedPasswords() {
        return usedPasswords;
    }

    public void setUsedPasswords(List<String> usedPasswords) {
        this.usedPasswords = usedPasswords;
    }
    
    public String getNuId() {
        return nuId;
    }

    public void setNuId(String nuId) {
        this.nuId = nuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(!isValidPassword(password))
            throw new Exception("Invalid Password!");
      
        String hashedPassword = BCrypt.hashpw(password, salt); // Hash the password with the generated salt
        this.password = hashedPassword;
        usedPasswords.add(hashedPassword);    
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }
    
     public boolean isValidPassword(String password){
        String pattern = "^[a-zA-Z0-9]+.*$";  // Allows letters and digits at the beginning

        if(password.equals(""))
            return false;
        
        if(password.length() < 4)
            return false;
        
        if(!password.matches(pattern))
            return false;
        
        for(String hashedPass: this.usedPasswords)
            if(BCrypt.checkpw(password, hashedPass))
                return false;
        return true;
    }
     
      public String toString(){
        return this.nuId;
    }
}
