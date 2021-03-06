package com.vp.training.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.training.microservices.entities.Car;
import com.vp.training.microservices.entities.repository.CarRepository;
import com.vp.training.microservices.entities.repository.PersonRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepo;
	
	@Autowired
	PersonRepository personRepo;
	
	@Override
	public Car addCar(Car car) {
		return carRepo.save(car);
	}

	@Override
	public Car getCarById(String carId) {
		return carRepo.findOne(carId);
	}

	@Override
	public void deleteCar(String id) {
		carRepo.delete(id);
	}

	@Override
	public void updateCar(Car car) {
		carRepo.save(car);
	}

	@Override
	public List<Car> getCarsByPersonId(String personId) {
		return personRepo.findOne(personId).getCars();
	}
}
