package com.app.habilitation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.habilitation.controller.dtos.PasswordChangerDTO;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.UserEntity;

@Service
public class ModificationServiceImpl implements ModificationService  {

	final UserDao userdao;
	
	public ModificationServiceImpl(UserDao userdao) {
		this.userdao = userdao;
	}
	
	@Override
	public void changePassword(UserDetails user, PasswordChangerDTO pwdDTO) {
		
		UserEntity rawUser = userdao.findByLogin(user.getUsername());
		
		if(rawUser.getMdp().equals(pwdDTO.getCurrentPassword())) {
			rawUser.setMdp(pwdDTO.getPassword());
			userdao.save(rawUser);
		}else {
			throw new RuntimeException("Bad Password!"+ rawUser.getMdp() + "|"+ pwdDTO.getCurrentPassword() );
		}
		
	}

}
