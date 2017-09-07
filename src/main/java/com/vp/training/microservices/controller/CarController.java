package com.vp.training.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Car getCarById(@RequestParam String carId) {
		return carService.getCarById(carId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Car> getCarsByPersonId(@RequestParam String personId) {
		return carService.getCarsByPersonId(personId);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCar(@RequestParam String id) {
		carService.deleteCar(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateCar(@RequestBody Car car) {
		carService.updateCar(car);
	}
}
