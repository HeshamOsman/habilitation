package com.app.habilitation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.AdminDto;
import com.app.habilitation.entity.UserEntity;
import com.app.habilitation.service.UserService;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
//@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController (UserService theuserService) {
		userService=theuserService;
	}
	
	
	@GetMapping("/getUsers")
	public List<UserEntity> getUsers(Authentication authentication){
		return userService.findAll(authentication);
		
	}
	
	@PostMapping("/addUser")
	public UserEntity addUser (@RequestBody UserEntity theUser, Authentication authentication) {
		
		userService.add(theUser, authentication);
		
		return theUser;
	}
	
	@GetMapping("/admins")
	public List<AdminDto> admins(Authentication authentication) {
		 UserDetails user = (UserDetails)authentication.getPrincipal();

		return userService.getAdmins(user);
	}
	
	@GetMapping("updateUser/{userId}")
	public UserEntity findById(@PathVariable int userId) {
		
		UserEntity theUser = userService.findById(userId);
		
		if(theUser == null) {
			throw new RuntimeException ("user id not found" + userId);
		}
		
		return theUser;
	}
	
	@PostMapping("/modif")
	public UserEntity updateUser (@RequestBody UserEntity theUser) {
		
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		UserEntity result = userService.findById(userId);
		
		if(result == null) {
			throw new RuntimeException ("user id not found" + userId);
		}
		 userService.deleteById(userId);
		 
		 return "user avec l'id :" +userId + "supprimé";
	}
}
