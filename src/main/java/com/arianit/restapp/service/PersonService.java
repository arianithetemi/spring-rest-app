package com.arianit.restapp.service;

import com.arianit.restapp.domain.Person;
import com.arianit.restapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Finding and returning all person data using personRepository method
    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    // Finding Person by given id using personRepository findOne method
    public Person readById(long id) {
        return personRepository.findOne(id);
    }

    // Update Person by given id using personRepository update method
    public Person findByIdAndUpdate(long id, Person updatedPerson) {
        Person person = personRepository.findOne(id);
        if( updatedPerson.getName() != null ) {
            person.setName(updatedPerson.getName());
        }
        if( updatedPerson.getCity() != null) {
            person.setCity(updatedPerson.getCity());
        }
        if( updatedPerson.getEmail() != null) {
            person.setEmail(updatedPerson.getEmail());
        }
        if( updatedPerson.getMac() != null) {
            person.setMac(updatedPerson.getMac());
        }
        if( updatedPerson.getCreditcard() != null) {
            person.setCreditcard(updatedPerson.getCreditcard());
        }

        return personRepository.save(person);
    }

    // Finding Person by given id and removing from DB using personRepository delete method
    public void deleteById(long id) {
        personRepository.delete(id);
    }

    // Finding and returning people ordered by name by ascending
    public List<Person> findAllOrderedByNameAsc() {
        return personRepository.findAllByOrderByNameAsc();
    }

    // Getting a list of persons and saving to H2 database using personRepository method
    public void save(List<Person> people) {
        personRepository.save(people);
    }

}