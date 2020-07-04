package com.app.habilitation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.EntiteEntity;

@Repository
public interface EntityDao extends JpaRepository<EntiteEntity, Integer> {

}
