package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.habilitation.controller.dtos.AdminDto;
import com.app.habilitation.entity.UserEntity;

public interface UserService {

	public void save (UserEntity theUser);

	public List<AdminDto> getAdmins(UserDetails user);
	
	public List<UserEntity> findAll(Authentication auth);
	
	public UserEntity findById(int theid);
	
	public void deleteById(int userId);

	void add(UserEntity theUser, Authentication authentication);
	
	
	
}
