package com.app.habilitation.entity;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="ORDO_DEP_P_EMPLOI")
@SequenceGenerator(name="emploi_gen",sequenceName="emploi_seq",allocationSize = 1)
public class EmploiEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "emploi_gen")
	@Column(name="ID")

	private Integer id;
	
	@NotNull
	@Column(name="CODE")
	private String code;
	
	@NotNull
	@Column(name="NOM")
	private String nom;
	
	@Column(name="DATEEFFET")
	private Date dateeffet;
	
	@Column(name="DATEFIN")
	private Date datefin;
	
	@NotNull
	@Column(name="STATUT")
	private String statut; 
	
	/*@OneToMany(mappedBy = "emploi", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<UserEntity> users; */

	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="ORDO_DEP_HAB_EMPLOI_MENU", joinColumns = @JoinColumn(name="emploi"), inverseJoinColumns = @JoinColumn(name="menu"))
	private List<MenuEntity> menu;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "emploi")
	private List<EntiteEntity> entite;
	
	
	
	
	public List<EntiteEntity> getEntite() {
		return entite;
	}

	public void setEntite(List<EntiteEntity> entite) {
		this.entite = entite;
	}

	public List<MenuEntity> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuEntity> menu) {
		this.menu = menu;
	}

	public Integer getId() {
		return id;
	}

	/* public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	} */

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

	 public Date getDateeffet() {
		return dateeffet;
	}

	public void setDateeffet(Date dateeffet) {
		this.dateeffet = dateeffet;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	


	public EmploiEntity() {
	}

	
	public EmploiEntity(String code, String nom, Date dateeffet, Date datefin, String statut, List<MenuEntity> menu,
			List<EntiteEntity> entite) {
		this.code = code;
		this.nom = nom;
		this.dateeffet = dateeffet;
		this.datefin = datefin;
		this.statut = statut;
		this.menu = menu;
		this.entite = entite;
	}

	@Override
	public String toString() {
		return "";
	}

	
	
	
	
	
	
}
