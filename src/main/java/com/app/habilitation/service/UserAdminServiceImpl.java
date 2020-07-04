package com.app.habilitation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.habilitation.controller.dtos.DesactivationUserDto;
import com.app.habilitation.controller.dtos.UserAdminDto;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.UserEntity;

@Service
public class UserAdminServiceImpl implements UserAdminService {

	@Autowired
	private UserDao userDao;
	

	
	public UserAdminServiceImpl(UserDao theUserDao) {
		userDao=theUserDao;
	}
	
	@Override
	public List<UserAdminDto> getUsers(UserDetails user) {
	
		Integer idEntite= userDao.findByLogin(user.getUsername()).getEntite().getId();
		return userDao.findByEntiteId(idEntite).stream().map(users -> new UserAdminDto(users)).collect(Collectors.toList());
	}

	@Override
	public void changeStatut(DesactivationUserDto user) {
		
		UserEntity userTochange = userDao.findByLogin(user.getLogin());
		userTochange.setStatut(user.getStatut());
		userTochange.setMotifdedesactivation(user.getMotifDeDesactivation());
		
		userDao.save(userTochange);
		
		
		
	}

}
