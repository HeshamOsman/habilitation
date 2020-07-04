package com.app.habilitation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.controller.dtos.AffectationAppMenuDto;
import com.app.habilitation.entity.ApplicationEntity;
import com.app.habilitation.service.ApplicationService;

@SpringBootApplication
@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*")
public class ApplicationController {

	private ApplicationService applicationService;
	
	@Autowired
	public ApplicationController(ApplicationService theApplicationService) {
		applicationService=theApplicationService;
	}
	
	@GetMapping("/getApp")
	public List<ApplicationEntity> getApp(){
		
		return applicationService.findAll();
	}
	
	
	@PostMapping("/addApp")
	public ApplicationEntity addApp(@RequestBody ApplicationEntity app) {
		
		applicationService.save(app);
		return app;
	}
	
	@GetMapping("/getApp/{appId}")
	public ApplicationEntity findById(@PathVariable int appId) {
		
		ApplicationEntity app = applicationService.findById(appId);
		
		if(app == null) {
			throw new RuntimeException("Application id not found" + appId);
		}
		
		return app;
	}
	
	@DeleteMapping("/deleteApp/{appId}")
	public String deleteApp(@PathVariable int appId) {
		
		ApplicationEntity result = applicationService.findById(appId);
		
		if(result == null) {
			throw new RuntimeException("Application id not found" + appId);
		}
		
		applicationService.deleteById(appId);
		
		return "L'application avec l'id :" + appId + " a été supprimé avec succès";
	}
	
	@PutMapping("/updateApp")
	public ApplicationEntity updateApp(@RequestBody ApplicationEntity app) {
		 applicationService.save(app);
		 return app;
	}
	
	@PutMapping("/affecter")
	public AffectationAppMenuDto affectation(@RequestBody AffectationAppMenuDto aff) {
		
		applicationService.affecterTo(aff.getCode(), aff.getMenu());
		return aff;
	}
	
}
