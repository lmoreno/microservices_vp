package com.vp.training.microservices.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	private String id;
	private String name;
	private String mail;
	private Integer age;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Car> cars;
}
