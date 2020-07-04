package com.app.habilitation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.habilitation.controller.dtos.DirecteurUserDto;
import com.app.habilitation.controller.dtos.UserDirecteurDto;
import com.app.habilitation.dao.UserDao;

@Service
public class DirecteurUserServiceImpl implements DirecteurUserService {

	private static final String ADMIN_CODE = "ad";
	
	

	private static final String USER2_CODE = "dev_w";
	@Autowired
	private UserDao userDao;
	
	public DirecteurUserServiceImpl(UserDao theUserDao) {
		userDao=theUserDao;
	}
	
	
	@Override
	public List<DirecteurUserDto> getAdmins(UserDetails user) {
		
		Integer idEntity =  userDao.findByLogin(user.getUsername()).getEntite().getId();
		return userDao.findByEmploiCodeAndEntiteId(ADMIN_CODE, idEntity).stream().map(admin -> new DirecteurUserDto(admin)).collect(Collectors.toList());
	}


	@Override
	public List<UserDirecteurDto> getUsers(UserDetails user) {

		Integer idEntity =  userDao.findByLogin(user.getUsername()).getEntite().getId();
		return userDao.findByEmploiCodeAndEntiteId(USER2_CODE, idEntity).stream().map(users -> new UserDirecteurDto(users)).collect(Collectors.toList());
	}

}
