package com.app.habilitation.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.habilitation.controller.dtos.EmploiEntiteDto;
import com.app.habilitation.dao.EntityDao;
import com.app.habilitation.dao.TypeEntiteDao;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.TypeEntiteEntity;
import com.app.habilitation.entity.UserEntity;

@Service
public class EntityServiceImpl implements EntityService {

	private EntityDao entityDao;
	private TypeEntiteDao typeEntiteDao;
	private UserDao userDao;
	
	
	
	@Autowired
	public EntityServiceImpl (EntityDao theEntityDao, TypeEntiteDao typeEntiteDao, UserDao theUserDao) {
		entityDao=theEntityDao;
		userDao=theUserDao;
		this.typeEntiteDao = typeEntiteDao;
		
	}
	
	@Override
	@Transactional
	public List<EntiteEntity> findAll() {
		
		return entityDao.findAll();
	}

	@Override
	public void save(EntiteEntity theEntite) {
		if(theEntite.getTypeentite() != null) {
			typeEntiteDao.findById(theEntite.getTypeentite().getId()).ifPresent(type -> theEntite.setTypeentite(type));
		entityDao.save(theEntite);
		}
		
	}

	@Override
	public EntiteEntity findbyId(int entiteId) {
		
		Optional<EntiteEntity> result = entityDao.findById(entiteId);
		
		EntiteEntity theEntite=null;
		
		if(result.isPresent()) {
			theEntite =result.get();
		}
		
		else {
			throw new RuntimeException("Impossible de trouver l'entité avec l'id :"+ entiteId);
		}
		
		return theEntite;
	}

	@Override
	public void deleteById(int entiteId) {
		
		entityDao.deleteById(entiteId);
		
	}

	@Override
	public EntiteEntity findById(int theId) {
		
		Optional<EntiteEntity> result = entityDao.findById(theId);
		
		EntiteEntity theEntite = null;
		
		if(result.isPresent()) {
			theEntite=result.get();
		}
		
		else {
			throw new RuntimeException("Impossible de trouvé l emplouyé avec l id :" + theId);
		}
		return theEntite;
	}

	/*@Override
	public List<EmploiEntiteDto> getEntite(UserDetails user) {
		
		Integer idEntite = userDao.findByLogin(user.getUsername()).getEntite().getId();
		return userDao.findByEntiteId(idEntite).stream().map(entite -> new EmploiEntiteDto(entite)).collect(Collectors.toList());
		return null;
	}

*/

	

}
