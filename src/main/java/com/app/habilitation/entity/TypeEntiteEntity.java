package com.app.habilitation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDO_DEP_P_TYPE_ENTITE")
@SequenceGenerator(name="type_entity_gen",sequenceName="type_entite_seq",allocationSize = 1)
public class TypeEntiteEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "type_entity_gen")
	@Column(name="ID")
	private Integer id;
	
	
	@Column(name="CODE")
	private String code;
	
	
	@Column(name="NOM")
	private String nom;


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


	public TypeEntiteEntity(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}


	public TypeEntiteEntity() {
	}


	@Override
	public String toString() {
		return "TypeEntiteEntity [id=" + id + ", code=" + code + ", nom=" + nom + "]";
	}
	
	
	
}
