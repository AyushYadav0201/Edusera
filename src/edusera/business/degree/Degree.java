   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.degree;

import edusera.business.professor.Course;
import edusera.business.students.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Degree {
    private List<Course> core;
    private List<Course> elective;
    private int creditForGraduation ;
    private String title;
    
    public Degree(int creditLeftForGraduation, String title){ 
    //when we expect in parameteres in constructor its mandatory
        this.core = new ArrayList<>();
        this.elective = new ArrayList<>();
        this.creditForGraduation = creditLeftForGraduation;
        this.title = title;
    }

    public int getCreditForGraduation() {
        return creditForGraduation;
    }

    public void setCreditForGraduation(int creditForGraduation) {
        this.creditForGraduation = creditForGraduation;
    }

    public String getTitle() {
        return title;
    }

    public void setCore(List<Course> core) {
        this.core = core;
    }

    public void setElective(List<Course> elective) {
        this.elective = elective;
    }

    public List<Course> getCore() {
        return core;
    }

    public List<Course> getElective() {
        return elective;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void addAsCoreCourse(Course course){
        core.add(course);
    }
    
     public void addAsElectiveCourse(Course course){
        elective.add(course);
    }
     
    public boolean canStudentGraduate(Student student){
        
        int credits = 0;
        //Check for credits;
        if(student.getCompletedCredits() >= this.creditForGraduation){
            
            System.out.println(student.getCompletedCredits() + " --- " + creditForGraduation);
        
            //Check for core courses
            List<String> studentCourseNames = student.getCoursesEnrolled();
            List<CourseNameCredit> sanitizedStudentCourses = this.sanitizeCourseNames(studentCourseNames);
            
            int count = 0;
            for(Course course: core)
                for(CourseNameCredit courseCredit: sanitizedStudentCourses)
                    if(courseCredit.name.equals(course.getTitle())){
                        courseCredit.eligible = true;
                        count++;      
                    }else
                        courseCredit.eligible = false;
            
            if(count != core.size())
                return false;
            
            
            //Check for electives
            for(CourseNameCredit courseCredit : sanitizedStudentCourses ) {
                // If this name is present in electiveslist then get its credit count and add it to a temp variable
                for (Course course : elective) {
                    if (courseCredit.name.equals(course.getTitle())) {
                        courseCredit.eligible = true;
                        break;
                    }else
                        courseCredit.eligible = false;

                }
            }
            
            for(CourseNameCredit courseCredit : sanitizedStudentCourses )
                if(courseCredit.eligible)
                    credits += courseCredit.credit;
            

            return credits >= creditForGraduation;
            
        } else
            return false;
    }
    
    public String toString(){
        return this.title;
    }
    
    private List<CourseNameCredit> sanitizeCourseNames(List<String> courseNames){
        List<CourseNameCredit> returnList = new ArrayList<>();
        for(String impureString : courseNames){
            String[] split = impureString.split(";");
            returnList.add(new CourseNameCredit(split[0], Integer.parseInt(split[1])));
        }
        return returnList;
    }
    
    public class CourseNameCredit{
        public String name;
        public int credit;
        public boolean eligible = true;
        public CourseNameCredit(String name, int credit){
            this.name = name;
            this.credit= credit;
        }
    }

}
