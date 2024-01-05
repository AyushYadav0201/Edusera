/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.professor;

import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import edusera.business.students.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ayush
 */
public class CourseOffering {
    private String crn;
    private List<Seat> seats;
    private String title;
    private int emptySeatCount;
    private String region;
    private String language;
    private Semester semester;

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }


    public String getLanguage() {
        return language;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }  

    public CourseOffering(String title, String crn, int numOfSeats, Semester current, String language, String region, int credit){
        this.crn = crn;
        this.emptySeatCount = numOfSeats;
        this.semester = current;
        this.language = language;
        this.region = region;
        this.title = title;
        this.seats = new ArrayList<>();
        for(int i = 0;i < numOfSeats; i++) // creates numOfSeats of empty seats for a new course offering
            seats.add(new Seat(title,credit));
    }
    
    public Seat getEmptySeat(){
        for(Seat seat: seats)
            if(!seat.isOccupied())
                return seat;
        return null;
    }
    
    public void decrementEmptySeatCount(){
        this.emptySeatCount--;
    }

    public int totalEmptySeats() {
        return this.emptySeatCount;
    }

    public void gradeStudent(Student student, double grade, Semester current) {
        SeatAssignment studentSeat = student.getSeatAssignment(this,current);
        studentSeat.setGrade(grade);
    }

    public boolean isSeatAssignmentForThisOffering(SeatAssignment assignment) {
        for(Seat seat: seats)
            if(assignment.isThisSeatOurs(seat))
                return true;
        return false; 
    }    
 
    public double getRating(){
        double rating = 0;
        int count = 0;
        for(Seat seat: seats)
            if(seat.isOccupied() && seat.isRated()){
                rating += seat.getRating();
                count++;
            }
        return count == 0? -1 : rating/count;
    }
    
    public String toString(){
        return this.crn;
    }

    public boolean checkIfSeatExists(Seat thatSeat) {
        for(Seat thisSeat: seats)
            if(thisSeat.equals(thatSeat))
                return true;
        return false;
    }
    
    
    
}
