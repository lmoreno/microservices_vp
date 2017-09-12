package com.vp.training.microservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.entities.repository.CarRepository;

@SpringBootApplication
public class CarsServer {

    public static void main(String[] args) {
        SpringApplication.run(CarsServer.class, args);
    }

	@Bean
	public CommandLineRunner demo(CarRepository carRepo) {
		return (args) -> {
			Car newCar = new Car("ASD123", "Black", 2009);
			List<Car> cars = new ArrayList<>();
			cars.add(newCar);
			carRepo.save(cars);
			
		};
	}
}
