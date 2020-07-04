package com.app.habilitation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.habilitation.controller.dtos.EmploiEntiteDto;
import com.app.habilitation.entity.EmploiEntity;

public interface EmploiDao extends JpaRepository<EmploiEntity, Integer> {

	
}
