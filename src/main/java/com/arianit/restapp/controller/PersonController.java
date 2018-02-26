package com.arianit.restapp.controller;

import com.arianit.restapp.domain.Person;
import com.arianit.restapp.service.PersonService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*
        GET: Endpoint will perform query to return as response people data as JSON
     */
    @RequestMapping( value = "/", method = RequestMethod.GET)
    public Iterable<Person> list() {
        return personService.list();
    }

    /*
        GET: Endpoint will take as path parameter an id,
        personService will find Person by given id in path
        will return as response that Person data as JSON
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Person read(@PathVariable(value="id") long id) {
        return personService.readById(id);
    }

}
