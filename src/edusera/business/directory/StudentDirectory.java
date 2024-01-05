/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.directory;

import edusera.business.students.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class StudentDirectory {
    private List<Student> users;
    
    public StudentDirectory(){
        this.users = new ArrayList<Student>();
    }

    public List<Student> getUsers() {
        return users;
    }
    
    public Student addStudent(String nuId, String name, String email){
        Student student = new Student(nuId, name, email);
        users.add(student);
        return student;
    }
    
     public Student getStudentByName(String name){
        for(Student newStudent: users){
            if(newStudent.getName().equals(name))
                return newStudent;
        }
        return null;
    }
     
    public Student getStudentByNuId(String nuId){
        for(Student newStudent: users){
            if(newStudent.getName().equals(nuId))
                return newStudent;
        }
        return null;
    }

    public void deletePerson(Student selectedStudent) {
        users.remove(selectedStudent);
    }

    
}
