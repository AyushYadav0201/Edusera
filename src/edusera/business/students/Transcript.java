/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.students;

import edusera.business.professor.CourseOffering;
import edusera.business.schedule.Semester;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Transcript {
     private List<CourseLoad> loads;
    
    public Transcript(){
        this.loads = new ArrayList<>();
    }
    
    public CourseLoad createCourseLoad(Semester current){
        CourseLoad newLoad = new CourseLoad(current);
        loads.add(newLoad);
        return newLoad;
    }

    public SeatAssignment getSeatAssignment(CourseOffering offering, Semester current) {
        CourseLoad courseLoadToBeGraded = this.getCourseLoadBySemester(current);
        return courseLoadToBeGraded == null ? null: courseLoadToBeGraded.getSeatAssignmentForOffering(offering);
    }

    private CourseLoad getCourseLoadBySemester(Semester current){
        for( CourseLoad load: loads)
            if(load.isCourseLoadOfCurrentSemester(current))
                return load;
        return null;
    }
    
    public void enrollFor(CourseOffering offering, Semester current) {
        CourseLoad courseLoad = this.getCourseLoadBySemester(current);
        courseLoad = courseLoad == null ? this.createCourseLoad(current): courseLoad;
        courseLoad.enrollFor(offering);
    }
    
    public String toString(){
        String ret ="\n";
        for(CourseLoad load: loads){
            ret += load + "\n";
        }
        return ret; 
    }

    public boolean isEnrolledForThisSem(CourseOffering offer, Semester current) {
        SeatAssignment assignment = this.getSeatAssignment(offer, current);
        return assignment == null ? false : offer.checkIfSeatExists(assignment.getSeat());
    }

    List<CourseOffering> getCourseOfferingBySemester(Semester current) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double calculateMyGradeBySem(Semester current) {
       CourseLoad courseload = this.getCourseLoadBySemester(current);
       return courseload.calculateMyGradeBySem(current);
    }

    public Iterable<CourseLoad> getLoads() {
        return this.loads;
    }
    
    
    public int getCompletedCredits() {
        int sum = 0;
        for(CourseLoad load : loads){
            sum += load.getCompletedCredits();
        }
        return sum;
    }

    public List<String> getCoursesEnrolled() {
        List<String> returnList = new ArrayList<>();
        for(CourseLoad load :loads)
            for(String courseName: load.getCoursesEnrolled()) //returns again lists of string so double for loop
                returnList.add(courseName);
        return returnList;
    }
}
