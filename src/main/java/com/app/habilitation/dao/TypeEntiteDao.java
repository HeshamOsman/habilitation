package com.app.habilitation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.TypeEntiteEntity;

@Repository
public interface TypeEntiteDao extends JpaRepository<TypeEntiteEntity, Integer> {

}
