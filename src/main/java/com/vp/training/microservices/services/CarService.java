package com.vp.training.microservices.services;

import com.vp.training.microservices.entities.Car;

public interface CarService {

	public Car addCar(Car car);

	public Car getCarById(String carId);

	public void deleteCar(String id);

	public void updateCar(Car car);

}
