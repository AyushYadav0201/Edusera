/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.schedule;

import edusera.business.professor.CourseOffering;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ayush
 */
public class Semester {
    
    private List<CourseOffering> offerings;
    private String title;
    private boolean current;
    private Date startsAt;
    private Date endsAt;
    private CalenderYear calender;

    public Semester(String title, Date startsAt, Date endsAt) {
        this.startsAt = startsAt;
        this.title = title;
        this.endsAt = endsAt;
        this.current = true;
        this.offerings = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CalenderYear getCalender() {
        return calender;
    }

    public void setCalender(CalenderYear calender) {
        this.calender = calender;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
    
    public String toString() {
        return title;
    }
    
}
