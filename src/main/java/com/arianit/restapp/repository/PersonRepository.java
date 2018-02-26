package com.arianit.restapp.repository;

import com.arianit.restapp.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>{

    // Custom query to get people data ordered by name by ascending
    List<Person> findAllByOrderByNameAsc();

}