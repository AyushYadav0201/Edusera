/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.professor;

import edusera.business.schedule.Semester;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Course {
    
    private String title;
    private String description;
    private List<CourseOffering> offerings;
    private int credit;
    private double price;
    
    public Course(String title, String description, int credit, double price) {
        this.title = title;
        this.description = description;
        this.credit = credit;
        this.price = price;
        this.offerings = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseOffering> getOfferings() {
        return offerings;
    }

    public CourseOffering createOffering(String crn, int numOfSeats, Semester current, String language, String region){
        CourseOffering newOffering = new CourseOffering(this.title, crn,numOfSeats, current, language, region, this.credit);
        offerings.add(newOffering);
        return newOffering;
    }
    
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString(){
        return title;
    }
}
