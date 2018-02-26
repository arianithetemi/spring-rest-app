package com.arianit.restapp.controller;

import com.arianit.restapp.domain.Person;
import com.arianit.restapp.service.PersonService;
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
        Endpoint to return as response people JSON data
     */
    @RequestMapping( value = "/", method = RequestMethod.GET)
    public Iterable<Person> list() {
        return personService.list();
    }

}
