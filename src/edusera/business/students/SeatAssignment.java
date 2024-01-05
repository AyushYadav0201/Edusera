/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.students;

import edusera.business.professor.Seat;

/**
 *
 * @author ayush
 */
public class SeatAssignment {
    private Seat seat;
    private double grade;
    boolean graded = false;

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public SeatAssignment(Seat seat) {
        this.seat = seat;
    }

    public boolean isThisSeatOurs(Seat seat) {
        return this.seat == seat;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
        this.graded = true;
    }
    
    public String toString(){
        return this.grade + "";
    }
    
    public int getCompletedCredits(){
        if(this.isGraded())
            return seat.getCredit();
        
        return 0;
    }

    public String getCoursesEnrolled() {
        if(this.isGraded())
            return seat.getCourseName() +";"+ seat.getCredit();
        
        return null;
    }
    
    
}
