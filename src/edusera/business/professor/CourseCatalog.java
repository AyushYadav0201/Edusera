/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.professor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class CourseCatalog {
    private List<Course> courses;
    
    public CourseCatalog(){
        this.courses = new ArrayList<>();
    }
    
    public Course createCourse(String title, String description, int credit, double price){
        Course newCourse = new Course(title,description,credit, price);
        courses.add(newCourse);
        return newCourse;
    }

    public List<Course> getCourses() {
        return courses;
    }
    
    public Course getCourseByName(String name ){
        for(Course course: courses)
            if(course.getTitle().equals(name))
                return course;
        return null;
    }  
}