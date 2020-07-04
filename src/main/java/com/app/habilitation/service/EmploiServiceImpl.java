package com.app.habilitation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.habilitation.controller.dtos.EmploiEntiteDto;
import com.app.habilitation.dao.EmploiDao;
import com.app.habilitation.dao.EntityDao;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EmploiEntity;

@Service
public class EmploiServiceImpl implements EmploiService {

	private EmploiDao emploiDao;
	private UserDao userDao;
	private EntityDao entiteDao;
	
	@Autowired
	public EmploiServiceImpl(EmploiDao theEmploiDao, UserDao theUserDao, EntityDao theEntiteDao) {
		emploiDao=theEmploiDao;
		userDao=theUserDao;
		entiteDao=theEntiteDao;
	}
	
	
	@Override
	@Transactional
	public List<EmploiEntity> findAll() {
		
		return (List<EmploiEntity>) emploiDao.findAll();
	}


	@Override
	public void save(EmploiEntity emp) {
		
		emploiDao.save(emp);
		
	}


	@Override
	public EmploiEntity findById(int emploiId) {

		Optional<EmploiEntity> result =emploiDao.findById(emploiId);
		
		EmploiEntity theEmploiEntity =null;
		
		if(result.isPresent()) {
			theEmploiEntity=result.get();
		}
		
		else {
			throw new RuntimeException("emploi not found " + emploiId);
		}
		return theEmploiEntity;
	}


	@Override
	public void deleteById(int theId) {
		
		emploiDao.deleteById(theId);
		
	}


	@Override
	public List<EmploiEntity> getEmploiEntite(UserDetails user) {
		
		Integer idEntite = userDao.findByLogin(user.getUsername()).getEntite().getId();
		return entiteDao.findById(idEntite).get().getEmploi();
	}

}
