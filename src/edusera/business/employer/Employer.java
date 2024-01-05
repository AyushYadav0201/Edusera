/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.employer;
import edusera.business.profiles.Person;
import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author anjal
 */
public class Employer extends Person{
    
   private String id;
    private String name;
    private String specialty;
    private double rating;

    public Employer(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.rating = 0.0; // Initialize the rating to 0
    }

    // Getters and setters for the attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString(){
         return super.getName();
    }
}

    

