package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.habilitation.controller.dtos.EmploiEntiteDto;
import com.app.habilitation.entity.EntiteEntity;

public interface EntityService  {

	public List<EntiteEntity> findAll();
	
	public void save(EntiteEntity theEntite);

	public EntiteEntity findbyId(int entiteId);
	
	public void deleteById (int entiteId);
	
	public EntiteEntity findById(int theId);
	
	//public List<EmploiEntiteDto> getEntite (UserDetails user);
}
