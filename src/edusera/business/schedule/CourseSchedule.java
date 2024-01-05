/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ayush
 */
public class CourseSchedule {
    private List<Semester> semesters;
    private Semester current;

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public CourseSchedule() {
        this.semesters = new ArrayList<>();
    }
    
    public Semester startSemester(String startsAt, String endsAt) throws Exception{
        return this.startSemester(new Date(startsAt),new Date(endsAt));
    }

    public Semester startSemester(Date startsAt, Date endsAt) throws Exception{
        Semester newSem = new Semester(getSemesterType(startsAt), startsAt, endsAt);
        System.out.println(newSem.getTitle());
        if(containsInSemesters(newSem.getTitle()))
            throw new Exception("Semester Exists!");
            
        semesters.add(newSem);
        return newSem;
    }
    
    public Semester endSemester(Semester current) throws Exception{
        current.setCurrent(false);
        Date newStartDate = addDaysToDate(current.getEndsAt(), 30);
        Date newEndDate = addDaysToDate(newStartDate, 90);
        return this.startSemester(newStartDate, newEndDate);
    }
    
    public Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days); // Add the specified number of days
        Date updatedDate = calendar.getTime();
        return updatedDate;
    }

    
    public String getSemesterType(Date date) { //gives the type of sem (spring, summer. fall)
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR)%100;

        String semesterType = "";

        // Determine the semester type based on the month
        if (month >= Calendar.JANUARY && month < Calendar.MAY) {
            semesterType = "Spring";
        } else if (month >= Calendar.MAY && month < Calendar.AUGUST) {
            semesterType = "Summer";
        } else if (month >= Calendar.AUGUST && month <= Calendar.DECEMBER) {
            semesterType = "Fall";
        } else {
            semesterType = "Unknown"; // Handle edge cases or errors
        }
        // Append the year to the semester type
        return semesterType + " " + year;
    }
    
    public Semester getSemesterByTitle(String title){
        for(Semester sem: semesters)
            if(sem.getTitle().equals(title))
                return sem;
        return null;
    }
    
    public String getPreviousSemTitle(String title) {
        // Split the title into its components (season and year)
        String[] parts = title.split(" ");
        if (parts.length != 2) {
            // Invalid input, return the input title as is
            return title;
        }

        String season = parts[0].toLowerCase();
        int year;
        try {
            year = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            // Invalid input, return the input title as is
            return title;
        }

        if (season.equals("fall")) {
            // If it's the Fall semester, return the Spring of the same year
            return "Spring " + year;
        } else if (season.equals("spring")) {
            // If it's the Spring semester, return the Fall of the previous year
            return "Fall " + (year - 1);
        } else {
            // Invalid season, return the input title as is
            return title;
        }
    }

    private boolean containsInSemesters(String title) {
        for(Semester sem: semesters)
            if(sem.getTitle().equals(title))
                return true;
        return false;
    }
   
}
