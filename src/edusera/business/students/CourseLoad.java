/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.students;

import edusera.business.professor.CourseOffering;
import edusera.business.professor.Seat;
import edusera.business.schedule.Semester;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class CourseLoad {
   private List<SeatAssignment> assignments;
   private Semester semester;
   
   public CourseLoad(Semester semester){
       this.assignments = new ArrayList<>();
       this.semester = semester;
   }

    public SeatAssignment enrollFor(CourseOffering offering) {
        Seat seat = offering.getEmptySeat();
        seat.setOccupied(true);
        SeatAssignment assigned = new SeatAssignment(seat);
        assignments.add(assigned);
        offering.decrementEmptySeatCount();
        return assigned;
    }
    
    public boolean isCourseLoadOfCurrentSemester(Semester current){
        return semester == current;
    }

    public SeatAssignment getSeatAssignmentForOffering(CourseOffering offering) {
        for(SeatAssignment assignment: assignments)
            if(offering.isSeatAssignmentForThisOffering(assignment))
                return assignment;
        return null;
        
    }
    
    public String toString(){
        String ret ="Semester "+ this.semester.getTitle()+"\n";
        for(SeatAssignment seatAssignment: assignments){
            ret += seatAssignment + "\n";
        }
        return ret;
    }   

    public double calculateMyGradeBySem(Semester current) {
        
        double grade = 0;
        int count = 0;
        for(SeatAssignment assignment : assignments){
            if(assignment.isGraded()){
              grade += assignment.getGrade();
              count++;
            }
        }
        return grade/count ;
    }

    public Iterable<SeatAssignment> getSeatAssignments() {
        return this.assignments;
    }

    public Semester getSemester() {
        return this.semester;
    }
    
    public int getCompletedCredits(){
        int sum = 0 ;
        for(SeatAssignment seatAssignment : assignments){
           sum += seatAssignment.getCompletedCredits();
        }
        return sum;
    }

    public List<String> getCoursesEnrolled() {
        List<String> returnList = new ArrayList<>(); //add in string
        for(SeatAssignment seatAssignment : assignments) //returns single string
            returnList.add(seatAssignment.getCoursesEnrolled()); 
        return returnList;
    }
}
