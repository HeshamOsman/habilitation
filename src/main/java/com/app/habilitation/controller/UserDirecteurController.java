package com.app.habilitation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.DirecteurUserDto;
import com.app.habilitation.controller.dtos.UserDirecteurDto;
import com.app.habilitation.service.DirecteurUserService;

@RequestMapping("/directeur")
@CrossOrigin(origins = "*")
@RestController
public class UserDirecteurController {

	@Autowired
	private DirecteurUserService directeurUserService;
	
	public UserDirecteurController(DirecteurUserService theDirecteurUserService) {
		directeurUserService=theDirecteurUserService;
	}
	 
	@GetMapping("/getAdmins")
	public List<DirecteurUserDto> getAdmins(Authentication auth){
		UserDetails user= (UserDetails)auth.getPrincipal();
		
		return directeurUserService.getAdmins(user);
	}
	
	@GetMapping("/getUsers")
	public List<UserDirecteurDto> getUsers(Authentication auth) {
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		return directeurUserService.getUsers(user);
	}
}
