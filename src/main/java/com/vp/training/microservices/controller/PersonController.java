package com.vp.training.microservices.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.entities.Person;
import com.vp.training.microservices.services.CarService;
import com.vp.training.microservices.services.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@Autowired
	CarService carService;

	@GetMapping
	public List<Person> getPeople(@RequestParam(required = false) Integer age) {
		if(age == null)
			return personService.getAllPersons();
		else
			return personService.getPersonsByAge(age);
	}
	
	@GetMapping("/{personId}")
	public Person getPersonById(@PathVariable String personId) {
		return personService.getPersonById(personId);
	}
	
	@GetMapping("/{personId}/cars")
	public List<Car> getCarsByPersonId(@PathVariable String personId) {
		return carService.getCarsByPersonId(personId);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@PutMapping("/{personId}")
	public Person updatePerson(@PathVariable String personId, @RequestBody Person person) {
		person.setId(personId);
		personService.updatePerson(person);
		return person;
	}

	@DeleteMapping("/{personId}")
	public void deletePerson(@PathVariable String personId) {
		personService.deletePerson(personId);
	}
}
