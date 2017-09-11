package com.vp.training.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vp.training.microservices.entities.Person;
import com.vp.training.microservices.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/id/{personId}", method = RequestMethod.GET)
	public Person getPersonById(@PathVariable String personId) {
		return personService.getPersonById(personId);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@RequestMapping(value = "/age", method = RequestMethod.GET)
	public List<Person> getPersonsByAge(@RequestParam Integer age) {
		return personService.getPersonsByAge(age);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Person addPerson(Person person) {
		return personService.addPerson(person);
	}

	@RequestMapping(value = "/delete}", method = RequestMethod.GET)
	public void deletePerson(@RequestParam String personId) {
		personService.deletePerson(personId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
	}
}
