package com.prodyna.programmingchallenge.programmingchallenge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Class to model a person as depicted in a database
 * A person consists of an integer ID
 * as well as a string for the name
 * 
 * id acts as primary key for database
 * name cannot be null
 */

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    //constructors
    public Person() {

    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

   //getters and setters
    public int getID() {
        return id;
    }
   public String getName() {
        return name;
   }
   public void setID(int newID) {
        this.id = newID;
   }
   public void setName(String newName) {
        this.name = newName;
   }
    
}
