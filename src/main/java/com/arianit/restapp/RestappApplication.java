package com.arianit.restapp;

import com.arianit.restapp.domain.Person;
import com.arianit.restapp.service.PersonService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

    /*
    * This is a command line runner which will automatically read JSON file, and write to DB
    */
    @Bean
    CommandLineRunner runner(PersonService personService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            // typeReference references the list of Person Objects
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>(){};
            // inputStream will get as resource the JSON file
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/people.json");
            try {
                /* Mapping the values from JSON file to Person List typeReference
                 * Using save() method we will save JSON data
                 * if successfully saved a message will prit out in console
                 */
                List<Person> people = mapper.readValue(inputStream, typeReference);
                personService.saveAll(people);
                System.out.println("People data successfully saved!");
            } catch (IOException e) {
                // If there was an error mapping and saving JSON data, error will print out in console
                System.out.println("Unable to save people data: " + e.getMessage());
            }
        };
    }
}
