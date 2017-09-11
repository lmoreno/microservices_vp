package com.vp.training.microservices.entities;

import java.util.List;

import lombok.Data;

@Data
public class Mail {
	private List<String> recipients;
	private String body;
}
