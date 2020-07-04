package com.app.habilitation.controller.dtos;

import com.app.habilitation.entity.UserEntity;

public class DesactivationUserDto {

	private String login;
	private String statut;
	private String motifDeDesactivation;

	
	
	public String getMotifDeDesactivation() {
		return motifDeDesactivation;
	}

	public void setMotifDeDesactivation(String motifDeDesactivation) {
		this.motifDeDesactivation = motifDeDesactivation;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public DesactivationUserDto(UserEntity user) {
		login = user.getLogin();
		statut = user.getStatut();
		motifDeDesactivation=user.getMotifdedesactivation();
	}

	public DesactivationUserDto() {
	}

	@Override
	public String toString() {
		return "DesactivationUserDto [login=" + login + ", statut=" + statut + ", motifDeDesactivation="
				+ motifDeDesactivation + "]";
	}

	
}
