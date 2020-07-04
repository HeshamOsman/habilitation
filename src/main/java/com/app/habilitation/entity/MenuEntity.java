package com.app.habilitation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDO_DEP_HAB_MENU")
@SequenceGenerator(name="menu_gen",sequenceName="menu_seq",allocationSize = 1)
public class MenuEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "app_gen")
	@Column(name="IDENTIFIANT")
	private Integer id;
	
	
	@Column(name="PARENT")
	private Integer parent;
	
	
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="ORDO_DEP_HAB_EMPLOI_MENU", joinColumns = @JoinColumn(name="menu"), inverseJoinColumns = @JoinColumn(name="emploi"))
	@JsonIgnore
	private List<EmploiEntity> emploi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menu") 
	private List<ApplicationEntity> app;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IHM")
	private String ihm;
	
	@Column(name="COMPOSANT")
	private String composant;
	
	
	@Column(name="PARAM")
	private String param;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParent() {
		return parent;
	}


	public void setParent(Integer parent) {
		this.parent = parent;
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


	public String getIhm() {
		return ihm;
	}


	public void setIhm(String ihm) {
		this.ihm = ihm;
	}


	public String getComposant() {
		return composant;
	}


	public void setComposant(String composant) {
		this.composant = composant;
	}


	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	


	public List<ApplicationEntity> getApp() {
		return app;
	}


	public void setApp(List<ApplicationEntity> app) {
		this.app = app;
	}


	public List<EmploiEntity> getEmploi() {
		return emploi;
	}


	public void setEmploi(List<EmploiEntity> emploi) {
		this.emploi = emploi;
	}


	
	
	public MenuEntity(Integer parent, List<EmploiEntity> emploi, String nom, String description, String ihm,
			String composant, String param) {
		this.parent = parent;
		this.emploi = emploi;
		this.nom = nom;
		this.description = description;
		this.ihm = ihm;
		this.composant = composant;
		this.param = param;
	}


	public MenuEntity() {
	}


	
	
	@Override
	public String toString() {
		return "MenuEntity [id=" + id + ", parent=" + parent + ", emploi=" + emploi + ", nom=" + nom + ", description="
				+ description + ", ihm=" + ihm + ", composant=" + composant + ", param=" + param + "]";
	}


	public void addEmploi(EmploiEntity theEmploi) {
		if(emploi == null) {
			emploi= new ArrayList<EmploiEntity>();
		}
		
		emploi.add(theEmploi);
	}
	
}
