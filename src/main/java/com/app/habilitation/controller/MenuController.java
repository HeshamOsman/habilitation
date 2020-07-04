package com.app.habilitation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.MenuEntity;
import com.app.habilitation.service.EntityService;
import com.app.habilitation.service.MenuService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private EntityService entiteService;
	
	public MenuController(MenuService theMenuService) {
		menuService=theMenuService;
	}
	
	@GetMapping("/getMenu")
	public List<MenuEntity> menu(Authentication auth) {
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		return menuService.getMenu(user);
		
		
	}
	
	@GetMapping("/findAll")
	public List<MenuEntity> findAll(Authentication auth){
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		return menuService.findAll(user);
	}
	
	@GetMapping("/getMenuEntite")
	public List<EntiteEntity> getMenuEntite(){
		return entiteService.findAll();
	}
}
