package com.app.habilitation.controller.dtos;

import java.util.Date;

import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.UserEntity;

public class UserDirecteurDto {

	
	private EmploiEntity emploi;
	private EntiteEntity entite;
	private String username;
	private String nom;
	private String prenom;
	private String statut;
	private Date dateEffet;
	private Date dateFin;
	private Date creeLe;
	private Integer creePar;
	private String email;
	
	
	
	public EmploiEntity getEmploi() {
		return emploi;
	}
	public void setEmploi(EmploiEntity emploi) {
		this.emploi = emploi;
	}
	public EntiteEntity getEntite() {
		return entite;
	}
	public void setEntite(EntiteEntity entite) {
		this.entite = entite;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNom() {
		return nom;
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
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateEffet() {
		return dateEffet;
	}
	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getCreeLe() {
		return creeLe;
	}
	public void setCreeLe(Date creeLe) {
		this.creeLe = creeLe;
	}
	public Integer getCreePar() {
		return creePar;
	}
	public void setCreePar(Integer creePar) {
		this.creePar = creePar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserDirecteurDto(UserEntity users) {
		emploi= users.getEmploi();
		entite=users.getEntite();
		username=users.getLogin();
		nom=users.getNom();
		prenom=users.getPrenom();
		statut=users.getStatut();
		dateEffet=users.getDateeffet();
		dateFin=users.getDatefin();
		creeLe=users.getCreele();
		creePar=users.getCreerpar();
		email=users.getEmail();
	}
	
	
	
	public UserDirecteurDto() {
	}
	
	@Override
	public String toString() {
		return "UserDirecteurDto [emploi=" + emploi + ", entite=" + entite + ", username=" + username + ", nom=" + nom
				+ ", prenom=" + prenom + ", statut=" + statut + ", dateEffet=" + dateEffet + ", dateFin=" + dateFin
				+ ", creeLe=" + creeLe + ", creePar=" + creePar + ", email=" + email + "]";
	}
	
	
}
