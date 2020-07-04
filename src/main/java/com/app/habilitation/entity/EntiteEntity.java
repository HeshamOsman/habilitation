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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORDO_DEP_P_ENTITE")
@SequenceGenerator(name="entity_gen",sequenceName="entity_seq",allocationSize = 1)
public class EntiteEntity implements Serializable {

	
@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "entity_gen")
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TYPEENTITE")
	private TypeEntiteEntity typeentite;
	
	@Column(name="ENTITEMERE")
	private Integer entitemere;
	
	@Column(name="CODE")
	private String code;
	
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="CREELE")
	private Date creele;
	
	@Column(name="ANNULELE")
	private Date annulele;
	
	@Column(name="CREEPAR")
	private Integer creepar;
	
	@Column(name="ANNULEPAR")
	private Integer annulepar;
	
	@Column(name="MODIFIELE")
	private Date modifiele;
	
	@Column(name="MODIFIERPAR")
	private Integer modifierpar;
	
	@Column(name="STATUT")
	private String statut;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="P_EMPLOI_TYPE_ENTITE", joinColumns = @JoinColumn(name="ID_P_ENTITE", referencedColumnName="ID"), inverseJoinColumns = @JoinColumn(name="ID_P_EMPLOI", referencedColumnName="ID"))
	
	private List<EmploiEntity> emploi;
	
	 /*@OneToMany(mappedBy = "entite", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<UserEntity> users; 
	*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public List<EmploiEntity> getEmploi() {
		return emploi;
	}

	public void setEmploi(List<EmploiEntity> emploi) {
		this.emploi = emploi;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	

	

	
	public Integer getEntitemere() {
		return entitemere;
	}

	public void setEntitemere(Integer entitemere) {
		this.entitemere = entitemere;
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

	public Date getCreele() {
		return creele;
	}

	public void setCreele(Date creele) {
		this.creele = creele;
	}

	public Date getAnnulele() {
		return annulele;
	}

	public void setAnnulele(Date annulele) {
		this.annulele = annulele;
	}

	public Integer getCreepar() {
		return creepar;
	}

	public void setCreepar(Integer creepar) {
		this.creepar = creepar;
	}

	public Integer getAnnulepar() {
		return annulepar;
	}

	public void setAnnulepar(Integer annulepar) {
		this.annulepar = annulepar;
	}

	public Date getModifiele() {
		return modifiele;
	}

	public void setModifiele(Date modifiele) {
		this.modifiele = modifiele;
	}

	public Integer getModifierpar() {
		return modifierpar;
	}

	public void setModifierpar(Integer modifierpar) {
		this.modifierpar = modifierpar;
	}

	

	public TypeEntiteEntity getTypeentite() {
		return typeentite;
	}

	public void setTypeentite(TypeEntiteEntity typeentite) {
		this.typeentite = typeentite;
	}

	
	
	
	
	

	public EntiteEntity(TypeEntiteEntity typeentite, Integer entitemere, String code, String nom, Date creele,
			Date annulele, Integer creepar, Integer annulepar, Date modifiele, Integer modifierpar, String statut,
			List<EmploiEntity> emploi) {
		this.typeentite = typeentite;
		this.entitemere = entitemere;
		this.code = code;
		this.nom = nom;
		this.creele = creele;
		this.annulele = annulele;
		this.creepar = creepar;
		this.annulepar = annulepar;
		this.modifiele = modifiele;
		this.modifierpar = modifierpar;
		this.statut = statut;
		this.emploi = emploi;
	}

	public EntiteEntity() {
	}

	@Override
	public String toString() {
		return "EntiteEntity [id=" + id + ", typeentite=" + typeentite + ", entitemere=" + entitemere + ", code=" + code
				+ ", nom=" + nom + ", creele=" + creele + ", annulele=" + annulele + ", creepar=" + creepar
				+ ", annulepar=" + annulepar + ", modifiele=" + modifiele + ", modifierpar=" + modifierpar + ", statut="
				+ statut + ", emploi=" + emploi + "]";
	}

	
	

	
	


	
}
