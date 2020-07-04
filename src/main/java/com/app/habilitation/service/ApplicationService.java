package com.app.habilitation.service;

import java.util.List;

import com.app.habilitation.entity.ApplicationEntity;

public interface ApplicationService {

	public List<ApplicationEntity> findAll();
	
	public void save(ApplicationEntity app);
	
	public void deleteById(int theId);
	
	public ApplicationEntity findById(int theId);

	public void affecterTo(String code, String menu);
}
