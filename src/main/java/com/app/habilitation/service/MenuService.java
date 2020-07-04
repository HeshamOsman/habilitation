package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.habilitation.entity.MenuEntity;

public interface MenuService {

	List<MenuEntity> getMenu(UserDetails user);
	
	public List<MenuEntity> findAll(UserDetails user);
	
	public List<MenuEntity> menuEntite();

}
