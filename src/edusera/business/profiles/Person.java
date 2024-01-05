/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera.business.profiles;

/**
 *
 * @author ayush
 */
public class Person {
    private String name;
    private String email;
    public String nuId;

    public String getNuId() {
        return nuId;
    }

    public void setNuId(String nuId) {
        this.nuId = nuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(String nuId, String name, String email) {
        this.nuId = nuId;
        this.name = name;
        this.email = email;
    }

    public Person() {
    }
    
}
