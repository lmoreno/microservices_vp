package com.vp.training.microservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.entities.Person;
import com.vp.training.microservices.entities.User;
import com.vp.training.microservices.entities.repository.CarRepository;
import com.vp.training.microservices.entities.repository.PersonRepository;
import com.vp.training.microservices.entities.repository.UserRepository;

@SpringBootApplication
@EnableResourceServer
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepo, CarRepository carRepo, UserRepository userRepo) {
		return (args) -> {
			
			List<Car> cars = new ArrayList<>();
			cars.add(new Car("ASD123", "Black", 2009));
			cars.add(new Car("BMX456", "White", 1899));
			carRepo.save(cars);
			carRepo.save(new Car("HJK987", "Red", 2025));
			
			personRepo.save(new Person("1", "Pepe Perez", "pepe@unexistant.com", 10, cars));
			personRepo.save(new Person("2", "Juan Perigoyas", "juan@unexistant.com", 10, new ArrayList<>()));
			personRepo.save(new Person("3", "Max Caiman", "max@elcaiman.com", 20, new ArrayList<>()));
			personRepo.save(new Person("4", "Edgar Garcia", "edguitar000@gmail.com", 31, new ArrayList<>()));
			
			userRepo.save(new User("1", "peter@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri", true));
			userRepo.save(new User("2", "john@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri", true));
			userRepo.save(new User("3", "katie@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri", true));
		};
	}
}
