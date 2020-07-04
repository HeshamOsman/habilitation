package com.app.habilitation.controller.dtos;

import com.app.habilitation.entity.UserEntity;

public class EmploiEntiteDto {

	
	private Integer idEntite;
	private Integer idEmploi;
	
	
	public Integer getIdEntite() {
		return idEntite;
	}
	public void setIdEntite(Integer idEntite) {
		this.idEntite = idEntite;
	}
	public Integer getIdEmploi() {
		return idEmploi;
	}
	public void setIdEmploi(Integer idEmploi) {
		this.idEmploi = idEmploi;
	}
	
	
	public EmploiEntiteDto(Integer entiteId, Integer emploiId) {
		idEntite=entiteId;
		idEmploi=emploiId;
	}
	
	
	
	@Override
	public String toString() {
		return "EmploiEntiteDto [idEntite=" + idEntite + ", idEmploi=" + idEmploi + "]";
	}
	
	
}
