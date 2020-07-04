package com.app.habilitation.controller;

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

import com.app.habilitation.controller.dtos.EmailDTo;
import com.app.habilitation.controller.dtos.UserUpdateGrade;
import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.UserEntity;
import com.app.habilitation.service.EmailService;
import com.app.habilitation.service.EmploiService;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*")
@RequestMapping("/emploi")
public class EmploiController {

	private EmploiService emploiService;
	private EmailService emailService;
	@Autowired
	public EmploiController(EmploiService theemploiService, EmailService theEmailService) {
		emploiService=theemploiService;
		emailService=theEmailService;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getall")
	public List<EmploiEntity> getAll() {
		
		return emploiService.findAll();
		
	}
	
	
	@PostMapping("/recuperer")
	public void recuperer(@RequestBody EmailDTo email) {
		this.emailService.sendPassword(email.getEmail());
		
		
	}
	
	
	
	@PostMapping("/upgrade-grade")
	public ResponseEntity<?> updateGrade(@RequestBody UserUpdateGrade user, Authentication authentication) {
	 this.emailService.notifyAllWorkers(user.login, user.emploi, authentication.getName());
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/addEmploi")
	public EmploiEntity addEmploi(@RequestBody EmploiEntity emp) {
		
		emploiService.save(emp);
		return emp;
	}
	
	@GetMapping("/findById/{emploiId}")
	public EmploiEntity findById(@PathVariable int emploiId) {
		
		EmploiEntity theEmploiEntite = emploiService.findById(emploiId);
		
		if(theEmploiEntite == null) {
			throw new RuntimeException("emploi not found "+ emploiId);
		}
		
		return theEmploiEntite;
	}
	
	@PutMapping("/updateEmploi")
	public EmploiEntity updateEmploi(@RequestBody EmploiEntity emp) {
		
		emploiService.save(emp);
		return emp;
	}
	
	@DeleteMapping("/deleteEmploi/{emploiId}")
	public String emploiDelete(@PathVariable int emploiId) {
		EmploiEntity result = emploiService.findById(emploiId);
		if(result == null) {
			throw new RuntimeException ("emploi not found" + emploiId);
		}
		
		emploiService.deleteById(emploiId);
		
		return "emploi avec l'id :" +emploiId+" supprimé";
	}
	
	@GetMapping("/getEmploi")
	public List<EmploiEntity> getEmploi(Authentication auth){
		
		UserDetails user =(UserDetails) auth.getPrincipal();
		return emploiService.getEmploiEntite(user);
	}
}
