package com.app.habilitation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.TypeEntiteEntity;
import com.app.habilitation.service.TypeEntiteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/typeEntite")
public class TypeEntieController {

	@Autowired
	private TypeEntiteService typeEntiteService;
	
	public TypeEntieController(TypeEntiteService theTypeEntiteService) {
		typeEntiteService=theTypeEntiteService;
	}
	
	@PostMapping("/addTypeEntite")
	public TypeEntiteEntity saveTypeEntite(@RequestBody TypeEntiteEntity theTypeEntite) {
		 typeEntiteService.save(theTypeEntite);
		 return theTypeEntite;
	}
	
	@PutMapping("/updateTypeEntite")
	public TypeEntiteEntity updateTypeEntite(@RequestBody TypeEntiteEntity theTypeEntite) {
		 typeEntiteService.save(theTypeEntite);
		 return theTypeEntite;
	}
	
	@DeleteMapping("/deleteTypeEntite/{typeEntiteId}")
	public String deleteTypeEntite(@PathVariable int typeEntiteId) {
		
		TypeEntiteEntity theEntite = typeEntiteService.findbyId(typeEntiteId);
		
		if(theEntite == null) {
			throw new RuntimeException("entite id not found" + typeEntiteId);
		}
		
		typeEntiteService.deleteById(typeEntiteId);
		
		return " delete entite id :" +typeEntiteId;
	}
	
	@GetMapping("/getAllTypeEntite")
	public List<TypeEntiteEntity> getAllTypeEntite(){
		
		return typeEntiteService.findAll();
	}
	
	
	@GetMapping("/updateTypeEntite/{typeEntiteId}")
	public TypeEntiteEntity findById(@PathVariable int typeEntiteId) {
		
		TypeEntiteEntity theTypeEntite = typeEntiteService.findbyId(typeEntiteId);
		
		if (theTypeEntite == null) {
			throw new RuntimeException("type entite id not found" + typeEntiteId);
		}
		
		return theTypeEntite;
	}
}
