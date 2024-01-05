/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.directory;

import edusera.business.employer.Employer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anjal
 */
public class EmployerDirectory {
     private List<Employer> employers;
     private  String nuId;
    /**
     *
     */
//    public employerDirectory() {
//        this.employers = new ArrayList<Employer>();
//    }

    public EmployerDirectory() {
        this.employers = new ArrayList<Employer>();}

    

    // Add a new employee to the directory
    public Employer addEmployee(String nuId, String name, String email) {
        Employer emp = new Employer(nuId, name, email);
        employers.add(emp);
        return emp;
       
    }
   
    // Find an employee by their ID
    public Employer findEmployeeById(String id) {
        for (Employer employee : employers) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null; // Employee not found
    }
     public List<Employer> getUsers() {
        return employers;
    }
    

    // Find employers by specialty
//    public List<Employer> findEmployeesBySpecialty(String specialty) {
//        List<Employer> matchingEmployees = new ArrayList<>();
//        for (Employer employee : employers) {
//            if (employee.getSpecialty().equalsIgnoreCase(specialty)) {
//                matchingEmployees.add(employee);
//            }
//        }
//        return matchingEmployees;
//    }

    // Other methods as needed

    public Employer addEmployer(String nuid, String name, String email) {
       
        Employer emp = new Employer(nuId, name, email);
        employers.add(emp);
        return emp;
    }

    
}
