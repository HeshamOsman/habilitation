package com.app.habilitation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.DesactivationUserDto;
import com.app.habilitation.controller.dtos.UserAdminDto;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.UserEntity;
import com.app.habilitation.service.UserAdminService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/admin")
public class UserAdminController {

	@Autowired
	private UserAdminService userAdminService;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getUsers")
	public List<UserAdminDto> getUsers(Authentication auth){
		
		UserDetails user = (UserDetails)auth.getPrincipal();
		return userAdminService.getUsers(user);
	}
	
	@PutMapping("/desactivationUser") 
	public ResponseEntity<?> desactivationUser(@RequestBody DesactivationUserDto tUser, Authentication authentication) {
		UserDetails user = (UserDetails)authentication.getPrincipal();
		UserEntity targetUser = userDao.findByLogin(tUser.getLogin());
		
		boolean exists = userAdminService.getUsers(user).stream().map(u -> u.getEmail()).collect(Collectors.toList()).contains(targetUser.getEmail());
		if(exists) {
			userAdminService.changeStatut(tUser);
			
			return ResponseEntity.ok(tUser);
		}
		
		return ResponseEntity.ok("not found");
	}
}
