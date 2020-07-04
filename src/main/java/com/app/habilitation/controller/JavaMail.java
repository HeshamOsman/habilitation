package com.app.habilitation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.service.EmailService;

@RestController
@CrossOrigin(origins = "*")

public class JavaMail {

	@Autowired
	public EmailService emailService;
	
	@GetMapping("/email")
	public String getEmail() {
		emailService.sendSimpleMessage("xosax57642@rm2rf.com", "test", "helloooooooooooo");
		return "helloo";
	}
}
