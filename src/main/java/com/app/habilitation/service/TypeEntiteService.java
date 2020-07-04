package com.app.habilitation.service;

import java.util.List;

import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.TypeEntiteEntity;

public interface TypeEntiteService {

	public void save(TypeEntiteEntity theTypeEntite);

	public TypeEntiteEntity findbyId(int typeEntiteId);

	public void deleteById(int typeEntiteId);
	
	public List<TypeEntiteEntity> findAll();
	
	
}
