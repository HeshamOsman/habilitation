package com.app.habilitation.controller.dtos;

import com.app.habilitation.entity.UserEntity;

public class AdminDto {
	
	private String nom;
	
	private String prenom;
	
	private String email;

	public String getNom() {
		return nom;
	}
	
	public AdminDto(UserEntity user) {
		nom = user.getNom();
		prenom = user.getPrenom();
		email = user.getEmail();
	}
	
	public AdminDto() {
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
