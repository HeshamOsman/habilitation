package com.app.habilitation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.habilitation.controller.dtos.AdminDto;
import com.app.habilitation.dao.EmploiDao;
import com.app.habilitation.dao.EntityDao;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	private static final String ADMIN_CODE = "ad";
	private UserDao userDao;
	private EmploiDao emploiDao;
	private EntityDao entityDao;

	
	@Autowired	
	public UserServiceImpl (UserDao theuserDao,EmploiDao emploiDaoo, EntityDao theEntityDao , UserDao userdao) {
		this.emploiDao =emploiDaoo;
		userDao = theuserDao;
		entityDao=theEntityDao;
		this.userDao = userdao;
	}
	
	
	

	@Override
	public void save(UserEntity theUser) {
		/*int empId = theUser.getEmploi().getId();
		EmploiEntity ee = emploiDao.getOne(empId);
        theUser.setEmploi(ee);
        theUser.setEntite(entityDao.getOne(theUser.getEntite().getId())); */
		
		emploiDao.findById(theUser.getEmploi().getId()).ifPresent(emploi -> theUser.setEmploi(emploi));
		if(theUser.getEntite() != null){entityDao.findById(theUser.getEntite().getId()).ifPresent(entite -> theUser.setEntite(entite));}
		
		userDao.save(theUser);

	}
	
	
	@Override
	public void add(UserEntity theUser, Authentication authentication) {
		/*int empId = theUser.getEmploi().getId();
		EmploiEntity ee = emploiDao.getOne(empId);
        theUser.setEmploi(ee);
        theUser.setEntite(entityDao.getOne(theUser.getEntite().getId())); */
		
		emploiDao.findById(theUser.getEmploi().getId()).ifPresent(emploi -> theUser.setEmploi(emploi));
		if(theUser.getEntite() != null){entityDao.findById(theUser.getEntite().getId()).ifPresent(entite -> theUser.setEntite(entite));}
		UserEntity author = this.userDao.findByLogin(authentication.getName());
		theUser.setCreerpar(author.getId());
		theUser.setCreele(new Date());
		theUser.setEntite(author.getEntite());
		userDao.save(theUser);

	}




	@Override
	public List<AdminDto> getAdmins(UserDetails user) {
	   Integer idEntity =  userDao.findByLogin(user.getUsername()).getEntite().getId();
	   
		return userDao.findByEmploiCodeAndEntiteId(ADMIN_CODE, idEntity).stream().map(admin -> new AdminDto(admin)).collect(Collectors.toList());
	}




	@Override
	public List<UserEntity> findAll(Authentication auth) {
		UserEntity user = userDao.findByLogin(auth.getName());
		
		return userDao.findAll().stream().filter(e -> e.getEntite().getId() == user.getEntite().getId()).collect(Collectors.toList());
	}




	@Override
	public UserEntity findById(int userId) {
		
		Optional<UserEntity> result = userDao.findById(userId);
				
		UserEntity theUser=null;
		
		if(result.isPresent()) {
			theUser=result.get();
		}
		
		else {
			throw new RuntimeException("Impossible de trouver le user avec l'id :"+ userId);
		}
		
		return theUser;
	}




	@Override
	public void deleteById(int userId) {
		
		userDao.deleteById(userId);
		
	}



	
}
