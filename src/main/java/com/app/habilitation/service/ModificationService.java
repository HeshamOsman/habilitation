package com.app.habilitation.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.habilitation.controller.dtos.PasswordChangerDTO;

public interface ModificationService {

	void changePassword(UserDetails user, PasswordChangerDTO pwdDTO);

}
