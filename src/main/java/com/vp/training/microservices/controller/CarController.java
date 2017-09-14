package com.vp.training.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping
	public List<Car> getCars() {
		return carService.getAllCars();
	}

	@GetMapping("/{carId}")
	public Car getCarById(@PathVariable String carId) {
		return carService.getCarById(carId);
	}

	@PostMapping
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}

	@DeleteMapping("/{carId}")
	public void deleteCar(@PathVariable String carId) {
		carService.deleteCar(carId);
	}

	@PutMapping("/{carId}")
	public void updateCar(@PathVariable String carId, @RequestBody Car car) {
		carService.updateCar(car);
	}
}
