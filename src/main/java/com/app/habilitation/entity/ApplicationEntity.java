package com.app.habilitation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDO_DEP_HAB_APPLICATION")
@SequenceGenerator(name="app_gen",sequenceName="app_seq",allocationSize = 1)
public class ApplicationEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "app_gen")
	@Column(name="IDENTIFIANT")
	private Integer id;
	
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STATUT")
	private String statut;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MENU")
	private MenuEntity menu;
	
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public ApplicationEntity(String code, String nom, String description, String statut) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.statut = statut;
	}

	public ApplicationEntity() {
	}

	@Override
	public String toString() {
		return "ApplicationEntity [id=" + id + ", code=" + code + ", nom=" + nom + ", description=" + description
				+ ", statut=" + statut + "]";
	}

	public MenuEntity getMenu() {
		return menu;
	}

	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}

	
	
}
