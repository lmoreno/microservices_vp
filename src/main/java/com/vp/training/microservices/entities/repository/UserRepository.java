package com.vp.training.microservices.entities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vp.training.microservices.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	User findOneByUsername(String username);
}
