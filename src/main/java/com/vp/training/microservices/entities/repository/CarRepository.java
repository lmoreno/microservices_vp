package com.vp.training.microservices.entities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vp.training.microservices.entities.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String>{
	//public List<String> findyBy
}
