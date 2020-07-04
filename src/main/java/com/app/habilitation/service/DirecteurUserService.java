package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.app.habilitation.controller.dtos.DirecteurUserDto;
import com.app.habilitation.controller.dtos.UserDirecteurDto;

@Repository
public interface DirecteurUserService {

	public List<DirecteurUserDto> getAdmins(UserDetails user);
	
	public List<UserDirecteurDto> getUsers(UserDetails user);
}
