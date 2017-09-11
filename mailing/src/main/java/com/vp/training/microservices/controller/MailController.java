package com.vp.training.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.training.microservices.entities.Mail;
import com.vp.training.microservices.services.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	MailService mailService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void sendMail(@RequestBody Mail mail){
		mailService.sendMail(mail);
	}
}
