package com.vp.training.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vp.training.microservices.entities.Person;
import com.vp.training.microservices.entities.repository.PersonRepository;

@SpringBootApplication
public class PersonsServer {

    public static void main(String[] args) {
        SpringApplication.run(PersonsServer.class, args);
    }

	@Bean
	public CommandLineRunner demo(PersonRepository personRepo) {
		return (args) -> {
			personRepo.save(new Person("1", "Pepe Perez", "pepe@unexistant.com", 10));
			personRepo.save(new Person("2", "Juan Perigoyas", "juan@unexistant.com", 10));
			personRepo.save(new Person("3", "Max Caiman", "max@elcaiman.com", 20));
			personRepo.save(new Person("4", "Edgar Garcia", "edguitar000@gmail.com", 31));
		};
	}
}
