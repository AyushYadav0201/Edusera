package edusera.business.degree;


import edusera.business.profiles.Person;
import edusera.business.profiles.Person;
import edusera.business.students.Student;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayush
 */
public class Authority extends Person{
    
    private List<Student> applicant;

    public List<Student> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<Student> applicant) {
        this.applicant = applicant;
    }

    public Authority(String nuId, String name, String email) {
        super(nuId, name, email);
        this.applicant = new ArrayList<>();
    }
    
    public void addStudentToGraduateQueue(Student student){
       applicant.add(student);
    }
   
    
    public void removeApplicant(Student applicant) {
        this.applicant.remove(applicant);
    }
    
}
