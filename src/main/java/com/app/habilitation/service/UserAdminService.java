package com.app.habilitation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.app.habilitation.controller.dtos.DesactivationUserDto;
import com.app.habilitation.controller.dtos.UserAdminDto;
import com.app.habilitation.entity.UserEntity;

@Repository
public interface UserAdminService {

	public List<UserAdminDto> getUsers (UserDetails user);
	
	public void changeStatut(DesactivationUserDto user);
}
