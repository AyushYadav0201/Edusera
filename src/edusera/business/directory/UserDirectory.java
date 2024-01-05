/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.directory;

import edusera.business.profiles.Person;
import edusera.business.profiles.Role;
import edusera.business.profiles.User;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ayush
 */
public class UserDirectory {
    private List<User> users;
    
    public UserDirectory(){
        this.users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return users;
    }
    
    public User addUser(String nuId,String username, String password, Person person, Role role, boolean Active) throws Exception{
        User user = new User(nuId, username, password, person, role, Active);
        users.add(user);
        return user;
    }
    
    public User findUser(String username, String password){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
                
    }
    
    //search by NUID
   public User searchUserByNUID(String nuid){
       for(User u: users)
           if(u.getNuId().equals(nuid))
               return u;
       return null;
   }
    
        public User findUserByPerson(Person person){
        for(User user : users){
            if(user.getPerson().equals(person))
                return user;
        }
        return null;
                
    } 
        
   //validate logins
       public User validateLogins(String username, String password){
       for(User u:users){
           if(u.getUsername().equals(username) && BCrypt.checkpw(password,u.getPassword()))
               return u;
       }
       return null;   
   }
       
        public void deleteUser(User selectedUser) {
        this.users.remove(selectedUser);
    }

    public boolean isNuIdValid(String text) {
        for(User user: this.users)
            if(user.getNuId().equals(text))
                return false;
        return true;
    }

}
