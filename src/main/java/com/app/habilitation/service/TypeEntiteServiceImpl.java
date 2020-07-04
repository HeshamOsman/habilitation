package com.app.habilitation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.habilitation.dao.TypeEntiteDao;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.TypeEntiteEntity;

@Service
public class TypeEntiteServiceImpl implements TypeEntiteService {

	@Autowired
	private TypeEntiteDao typeEntiteDao;
	
	public TypeEntiteServiceImpl(TypeEntiteDao theTypeEntiteDao) {
		typeEntiteDao=theTypeEntiteDao;
	}
	
	@Override
	public void save(TypeEntiteEntity theTypeEntite) {
		
		typeEntiteDao.save(theTypeEntite);

	}

	@Override
	public TypeEntiteEntity findbyId(int typeEntiteId) {
		Optional<TypeEntiteEntity> result = typeEntiteDao.findById(typeEntiteId);
		
		TypeEntiteEntity theTypeEntite=null;
		
		if(result.isPresent()) {
			theTypeEntite =result.get();
		}
		
		else {
			throw new RuntimeException("Impossible de trouver le type d'entié avec l'id :"+ typeEntiteId);
		}
		
		return theTypeEntite;
	}

	@Override
	public void deleteById(int typeEntiteId) {
		
		typeEntiteDao.deleteById(typeEntiteId);
		
	}

	@Override
	public List<TypeEntiteEntity> findAll() {
		
		return typeEntiteDao.findAll();
		
	}
	
	

}
