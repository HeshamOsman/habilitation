package com.app.habilitation.controller.dtos;

import java.util.Date;

import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.UserEntity;

public class UserAdminDto {

	
	private EmploiEntity emploi;
	private EntiteEntity entite;
	
	
	private String nom;
	private String prenom;
	private String statut;
	private Date dateEffet;
	private Date dateFin;
	private Date creeLe;
	private Integer creePar;
	private String motifDesactivation;
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
	public String getMotifDesactivation() {
		return motifDesactivation;
	}
	public void setMotifDesactivation(String motifDesactivation) {
		this.motifDesactivation = motifDesactivation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserAdminDto(UserEntity user) {
		emploi = user.getEmploi();
		entite = user.getEntite();
		nom = user.getNom();
		prenom = user.getPrenom();
		statut = user.getStatut();
		dateEffet = user.getDateeffet();
		dateFin = user.getDatefin();
		creeLe = user.getCreele();
		creePar = user.getCreerpar();
		motifDesactivation = user.getMotifdedesactivation();
		email= user.getEmail();
	}
	
	
	public UserAdminDto() {
	}
	
	
	@Override
	public String toString() {
		return "UserAdminDto [emploi=" + emploi + ", entite=" + entite + ", nom=" + nom + ", prenom=" + prenom
				+ ", statut=" + statut + ", dateEffet=" + dateEffet + ", dateFin=" + dateFin + ", creeLe=" + creeLe
				+ ", creePar=" + creePar + ", motifDesactivation=" + motifDesactivation + ", email=" + email + "]";
	}
	
	
	
}
