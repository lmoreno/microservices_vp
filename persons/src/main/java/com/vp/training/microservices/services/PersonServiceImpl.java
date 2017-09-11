package com.vp.training.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.training.microservices.entities.Person;
import com.vp.training.microservices.entities.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepo;
	
	@Override
	public Person addPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Person getPersonById(String personId) {
		Person person = personRepo.findOne(personId);
		return person;
	}

	@Override
	public List<Person> getPersonsByAge(Integer age) {
		return personRepo.findByAge(age);
	}

	@Override
	public List<Person> getAllPersons() {
		return (List<Person>) personRepo.findAll();
	}

	@Override
	public void deletePerson(String personId) {
		personRepo.delete(personId);
	}

	@Override
	public void updatePerson(Person person) {
		personRepo.save(person);
	}
}
