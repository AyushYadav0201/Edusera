/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.professor;

import edusera.business.profiles.Person;
import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Professor extends Person{
     private String nuId;
    private List<CourseOffering> offerings;
    private double rating;
    
    public Professor(String nuId, String name, String email) {
        super(nuId,name, email);
       
        this.offerings = new ArrayList<>();
    }

    public CourseOffering offer(Course courseToBeOffered, String crn, int numOfSeats, Semester current, String language, String region) {
        CourseOffering offerring = courseToBeOffered.createOffering(crn, numOfSeats, current, language, region);
        offerings.add(offerring);
        return offerring;
    }

    public void gradeStudent(CourseOffering offering, Student ayush, double grade, Semester current) {
        offering.gradeStudent(ayush,grade, current);
    }

    public double calculateMyRatingBySemester(Semester current) {
        double rating = 0;
        int count = 0;
        for(CourseOffering offering: offerings)
            if(offering.getSemester().equals(current) && offering.getRating() != -1){
                rating += offering.getRating();
                count++;
            }
        
        double semesterRating = count == 0 ? 0: rating/count ;
        return semesterRating;
    }

    public String getNuId() {
        return nuId;
    }

    public void setNuId(String nuId) {
        this.nuId = nuId;
    }

    public double getRating() {
        return rating;
    }

    public CourseOffering fetchCourseOfferingsBySearch(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<CourseOffering> getOfferings() {
        return offerings;
    }
    
    public List<CourseOffering> getOfferingsBySemester(Semester current) {
        List<CourseOffering> offers = new ArrayList<>();
        for(CourseOffering off: getOfferings())
            if(off.getSemester().equals(current))
                offers.add(off);
        return offers;
    }
    
    public String toString(){
         return super.getName();
    }
}
