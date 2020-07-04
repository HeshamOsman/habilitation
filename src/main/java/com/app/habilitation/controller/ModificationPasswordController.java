package com.app.habilitation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.PasswordChangerDTO;
import com.app.habilitation.service.ModificationService;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/password")
public class ModificationPasswordController {
	@Autowired
	private ModificationService modificationService;
	@PostMapping("change")
	public ResponseEntity<?> currentUser(Authentication authentication, @RequestBody PasswordChangerDTO  pwdDTO) {
	 UserDetails user = (UserDetails)authentication.getPrincipal();
	 try {
		modificationService.changePassword(user, pwdDTO);
		return ResponseEntity.ok("ok");
	} catch (Exception e) {
		return ResponseEntity.ok(e.getMessage());
	}
	 
		
	}
}
