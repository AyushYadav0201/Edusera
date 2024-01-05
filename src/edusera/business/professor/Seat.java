/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.professor;

/**
 *
 * @author ayush
 */
public class Seat {
    private String courseName;
    private int credit;
    private boolean rated;
    private boolean occupied;
    private double rating;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public Seat(String courseName, int credit) {
        this.courseName = courseName;
        this.credit = credit;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
   

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) throws Exception {
        if(rating > 5)
            throw new Exception("Rating must be out of 5 points");
        this.rating = rating;
        this.rated = true;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
}
