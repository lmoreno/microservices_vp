package com.vp.training.microservices.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
