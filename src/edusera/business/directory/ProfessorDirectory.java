/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.directory;

import edusera.business.professor.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class ProfessorDirectory {
    
    private List<Professor> users;
    
    public ProfessorDirectory(){
        this.users = new ArrayList<Professor>();
    }

    public List<Professor> getUsers() {
        return users;
    }
    
      public Professor addProfessor(String nuId, String name, String email){
        Professor prof = new Professor(nuId, name, email);
        users.add(prof);
        return prof;
    }
      
    public Professor getProfByName(String name){
        for(Professor prof: users)
            if(prof.getName().equals(name))
                return prof;
        return null;
    }

    public void deletePerson(Professor selectedProfessor) {
        users.remove(selectedProfessor);
    }
    
    
}
