package com.app.habilitation.service;

import java.util.List;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.habilitation.dao.MenuDao;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.MenuEntity;
import com.app.habilitation.entity.UserEntity;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private UserDao userDao;
	
	public MenuServiceImpl(MenuDao theMenuDao) {
		menuDao=theMenuDao;
	}
	
	
	
	
	@Override
	public List<MenuEntity> getMenu(UserDetails currentUser) {
		UserEntity user = userDao.findByLogin(currentUser.getUsername());
		List<MenuEntity> menu = user.getEmploi().getMenu();
		
		return menu;
	}




	@Override
	public List<MenuEntity> findAll(UserDetails currentUser) {
		
		UserEntity user = userDao.findByLogin(currentUser.getUsername());
		return menuDao.findAll();
		
	}




	@Override
	public List<MenuEntity> menuEntite() {
		
		//List<MenuEntity> menu = menuDao.findAll()
		return null;
	}

}
