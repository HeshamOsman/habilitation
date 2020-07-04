package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.habilitation.controller.dtos.EmploiEntiteDto;
import com.app.habilitation.entity.EmploiEntity;


public interface EmploiService {

	
	public List<EmploiEntity> findAll();
	
	public void save(EmploiEntity emp);

	public EmploiEntity findById(int emploiId);
	
	public void deleteById(int theId);
	
	public List<EmploiEntity> getEmploiEntite(UserDetails user);
}
