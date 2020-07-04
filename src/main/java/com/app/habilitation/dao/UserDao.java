package com.app.habilitation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

	UserEntity findByLogin(String login);

	List<UserEntity> findByEmploiCode(String code);

	List<UserEntity> findByEmploiCodeAndEntiteId(String adminCode, Integer idEntity);
	
	List<UserEntity> findByEntiteId(Integer idEntity);

	UserEntity findByEmail(String email);
	
	
}
