package com.arianit.restapp.repository;

import com.arianit.restapp.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{

}