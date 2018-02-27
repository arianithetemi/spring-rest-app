package com.arianit.restapp.controller;

import com.arianit.restapp.domain.Person;
import com.arianit.restapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
        Endpoint will return as response people data as JSON
     */
    @RequestMapping( value = "/", method = RequestMethod.GET)
    public Iterable<Person> list() {
        return personService.list();
    }

    /*
        Endpoint will get json structure with values in body
        will generate a datetime in specific format and
        will set the timestamp of the person obj
        will save and return as json structure the inserted Person data
     */
    @RequestMapping( value = "/", method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date and time
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSZ");

        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();

        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String createdDate = df.format(today);

        person.setTimestamp(createdDate);

        return personService.create(person);
    }

    /*

     */
    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public Person findByIdAndUpdate(@PathVariable(value="id") long id, @RequestBody Person updatedPerson) {
        return personService.findByIdAndUpdate(id, updatedPerson);
    }

    /*
        Endpoint will take as path parameter an id,
        personService will find Person by given id in path
        will return as response that Person data as JSON
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Person read(@PathVariable(value="id") long id) {
        return personService.readById(id);
    }

    /*
        Endpoint that will return as JSON list of People
        sorted naturally by their names
     */
    @RequestMapping(value = "/sort/name", method = RequestMethod.GET)
    public Iterable<Person> getPeopleOrderedByNameAsc() {
        return personService.findAllOrderedByNameAsc();
    }
}
