/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.degree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayush
 */
public class DegreeRegistry {
    private List<Degree> degrees;

    public DegreeRegistry() {
        this.degrees = new ArrayList<>();
    }
    
    public Degree addDegree(int creditLeftForGraduation, String title){
        Degree degree = new Degree(creditLeftForGraduation, title);
        degrees.add(degree);
        return degree;
    }

    public List<Degree> getDegrees() {
        return this.degrees;
    }
    
}
