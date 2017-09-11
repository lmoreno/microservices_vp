package com.vp.training.microservices.services;

import java.util.List;

import com.vp.training.microservices.entities.Person;

public interface PersonService {

	
	public Person addPerson(Person person);

	public Person getPersonById(String personId);
	
	public List<Person> getPersonsByAge(Integer age);
	
	public List<Person> getAllPersons();

	public void deletePerson(String personId);

	public void updatePerson(Person person);

}
