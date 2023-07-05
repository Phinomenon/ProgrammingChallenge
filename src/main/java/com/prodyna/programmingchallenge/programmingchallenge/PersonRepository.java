package com.prodyna.programmingchallenge.programmingchallenge;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * PersonRepository is a JPA Repository which provides code for the sql commands needed
 * this interface will be created and used by the PersonService class
 */

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
    
