package com.prodyna.programmingchallenge.programmingchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * this class performs the actual SQL operations via JBL repository
 * will be called at main class with corresponding data thus 
 * middleware between repository and controller
 */

@Service
public class PersonService {

    //repository of persons representing database
    @Autowired
    private PersonRepository pRepo;

    //GET all aka read all
    public List<Person> listAllPersons() {
        return pRepo.findAll();
    }

    //GET single aka read
    public Person getPerson(Integer id) {
        return pRepo.findById(id).get();
    }

    //POST aka create
    public void createPerson(Person p) {
        pRepo.save(p);
    }

    //PUT aka update
    public Person updatePerson (Person p) {
        //get the person that should get updated
        Person currentPerson = pRepo.findById(p.getID()).get();
        //manipulate attributes, should ID remain the same?
        currentPerson.setID(p.getID());
        currentPerson.setName(p.getName());
        //save and return the Person
        Person updatedPerson = pRepo.save(currentPerson);
        return updatedPerson;
    }

    //DELETE
    public void deletePerson(Integer id) {
        pRepo.deleteById(id);
    }

    
}
