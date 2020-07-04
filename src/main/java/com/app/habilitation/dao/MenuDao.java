package com.app.habilitation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.MenuEntity;

@Repository
public interface MenuDao extends JpaRepository<MenuEntity, Integer> {

	MenuEntity findByNom(String name);

}
