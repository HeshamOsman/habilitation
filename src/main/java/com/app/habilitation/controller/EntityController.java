package com.app.habilitation.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.UserUpdateEntite;
import com.app.habilitation.controller.dtos.UserUpdateGrade;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.service.EmailService;
import com.app.habilitation.service.EntityService;
import com.app.habilitation.service.NotificationService;
import com.app.habilitation.service.UserService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/entity")
public class EntityController {

	private EntityService entityService;
	private UserService userService;
	private UserDao userDao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private NotificationService notificationService;
	
	public EntityController (EntityService theEntityService, UserService theUserService,UserDao theUserDao) {
		entityService = theEntityService;
		userService=theUserService;
		userDao=theUserDao;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getall")
	public List<EntiteEntity> getAll() {
		
		return entityService.findAll();
	}
	
	@GetMapping("/getEntite")
	public List<EntiteEntity> getEntite(Authentication auth){
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		return entityService.findAll();
	}
	
	@PostMapping("/saveEntite")
	public EntiteEntity saveEntite(@RequestBody EntiteEntity theEntite, Authentication authentication) {
		Integer idUser = currentUserID(authentication);
		theEntite.setCreepar(idUser);
		theEntite.setCreele(new Date(System.currentTimeMillis()));
		entityService.save(theEntite);
		
		return theEntite;
	}
	
	@PutMapping("/updateEntite")
	public EntiteEntity updateEntite(@RequestBody EntiteEntity theEntite , Authentication authentication) {
		Integer idUser = currentUserID(authentication);
		theEntite.setModifierpar(idUser);
		entityService.save(theEntite);
		
		return theEntite;
		
	}

	private Integer currentUserID(Authentication authentication) {
		UserDetails user =(UserDetails)authentication.getPrincipal();
		Integer idUser=userDao.findByLogin(user.getUsername()).getId();
		return idUser;
	}
	
	@DeleteMapping("/deleteEntite/{entiteId}")
	public String deleteEntite(@PathVariable int entiteId) {
		
		EntiteEntity theEntite = entityService.findbyId(entiteId);
		
		if(theEntite == null) {
			throw new RuntimeException("entite id not found" + entiteId);
		}
		
		entityService.deleteById(entiteId);
		
		return " delete entite id :" +entiteId;
	}
	
	@GetMapping("/entiteUpdate/{entiteId}")
	public EntiteEntity getEntiteById(@PathVariable int entiteId) {
		
		EntiteEntity theEntite = entityService.findbyId(entiteId);
		
		if(theEntite == null) {
			throw new RuntimeException ("entite id not found" + entiteId);
		}
		
		return theEntite;
	}
	
	
	@PostMapping("/upgrade-entite")
	public ResponseEntity<?> updateEntite(@RequestBody UserUpdateEntite user, Authentication authentication) {
		String s = user.login;
		authentication.getName();
	 this.emailService.notifyAllWorkersEntite(user.login, user.entite, authentication.getName());
	  
		return ResponseEntity.ok(null);
	}
	
}
