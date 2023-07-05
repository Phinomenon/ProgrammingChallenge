package com.prodyna.programmingchallenge.programmingchallenge;

import java.util.NoSuchElementException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * main class that also acts as the REST controller
 * calling the middleware PersonService
 */
@SpringBootApplication
@RestController
@RequestMapping("/personservice")
public class ProgrammingchallengeApplication {

	//the service that does SQL operations
	@Autowired
	PersonService pService;

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingchallengeApplication.class, args);
	}


	/* GET method aka READ
	 * retrieves list of persons from the database
	 * returns a list with all the persons in the database and OK
	 */
	@GetMapping("")
	//public ResponseEntity<Object> getPerson() {
		//return new ResponseEntity<Object>(personDB.values(), HttpStatus.OK); // get class should get data from database
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> persons = pService.listAllPersons();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	/*
	 * GET single person aka READ
	 * tries to look for a single person, OK if found error code if not found
	 * returns the person and either OK or NOT_Found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Person> readPerson(@PathVariable Integer id){
		//try to find person
		try {
			Person p = pService.getPerson(id);
			return new ResponseEntity<Person>(p, HttpStatus.OK);
		} 
		//if person is not there error status
		catch (NoSuchElementException e) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
	}

	/* POST aka create
	 * creates a person in the database with id and string
	 * returns CREATED status
	 */
	@PostMapping("")
	public ResponseEntity<Person> createPerson(@RequestBody Person p){
		pService.createPerson(p);
		return new ResponseEntity<Person>(p, HttpStatus.CREATED);
	}

	/* PUT aka update
	 * updates an existing user at a specified id if such a person exists
	 * returns updated Person and OK or NOT_FOUND
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable Integer id) {
		//try to update an existing person
		try {
			Person updatedPerson = pService.getPerson(id);
			updatedPerson.setID(id);
			updatedPerson.setName(p.getName());
			pService.createPerson(updatedPerson);
			return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
		} 
		//if person does not exist error status
		catch (NoSuchElementException e) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
	}

	/* DELETE 
	 * Deletes a person from the database with id
	 * return a success message and OK or error message and NOT_FOUND
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deletePerson(@PathVariable Integer id){
		try {
			pService.deletePerson(id);
			return new ResponseEntity<>("Person successfully deleted!", HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<String>("No such person", HttpStatus.NOT_FOUND);
		}
		
	}



}
