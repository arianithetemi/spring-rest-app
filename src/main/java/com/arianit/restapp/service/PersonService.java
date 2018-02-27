package com.arianit.restapp.service;

import com.arianit.restapp.domain.Person;

import java.util.List;

/*
    This interface has CRUD abstracts methods that
    will be implemented in PersonServiceImpl class
 */
public interface PersonService {

    Iterable<Person> list();

    Person create(Person person);

    Person readById(long id);

    Person findByIdAndUpdate(long id, Person updatedPerson);

    void deleteById(long id);

    List<Person> findAllOrderedByNameAsc();

    void saveAll(List<Person> people);

}