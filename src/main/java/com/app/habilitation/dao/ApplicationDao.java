package com.app.habilitation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.ApplicationEntity;

@Repository
public interface ApplicationDao extends JpaRepository<ApplicationEntity, Integer> {

	ApplicationEntity findByCode(String code);

}
