/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.students;

import edusera.business.professor.CourseOffering;
import edusera.business.degree.Degree;
import edusera.business.profiles.Person;
import edusera.business.schedule.Semester;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Student extends Person {
  
    private Transcript transcript;
    private boolean submitted;

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }
    private Degree degree;
    private boolean graduated;

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
        
    public String getNuId() {
        return nuId;
    }

    public Student(String nuId, String name, String email) {
        super(nuId, name, email);
  
        this.transcript = new Transcript();
    }
    
    public CourseLoad createCourseLoad(Semester current){
        return this.transcript.createCourseLoad(current);
    }

    public void rateOffering(CourseOffering offering, double rating, Semester current) throws Exception {
        SeatAssignment ratingBySeatAssignment = this.getSeatAssignment(offering, current);
        ratingBySeatAssignment.getSeat().setRating(rating);
    }

    public SeatAssignment getSeatAssignment(CourseOffering offering, Semester current) {
        return this.transcript.getSeatAssignment(offering, current);
    }

    public void enrollFor(CourseOffering offering, Semester current) {
        this.transcript.enrollFor(offering, current);
    }

    public void printTranscript() {
        System.out.println(this.transcript);
    }
    
    public boolean isEnrolledForThisSem(CourseOffering offer, Semester current){
        return this.transcript.isEnrolledForThisSem(offer, current);
    }
    
    public String toString(){
        return super.getName();
    }

    public void setNuId(String nuId) {
        this.nuId = nuId;
    }

    public double calculateMyGradeBySem(Semester current) {
        return this.transcript.calculateMyGradeBySem(current);
    }

    public Transcript getTranscript() {
        return this.transcript;
    }

    public int getCompletedCredits() {
        return this.transcript.getCompletedCredits();
    }

    public List<String> getCoursesEnrolled() {
        return this.transcript.getCoursesEnrolled();
    }

}
