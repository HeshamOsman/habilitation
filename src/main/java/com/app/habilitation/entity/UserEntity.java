package com.app.habilitation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDO_DEP_UTILISATEUR")
@SequenceGenerator(name="user_gen",sequenceName="user_seq",allocationSize = 1)
public class UserEntity implements Serializable {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "user_gen")
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="ROLE") 
	
	
	private EmploiEntity emploi;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="ENTITE_id") 
	
	private EntiteEntity entite;
	
	
	@Column(name="USERNAME")
	private String login;
	
	
	@Column(name="PASSWORD")
	private String mdp;
	
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="CREEPAR")
	private Integer creerpar;
	
	@Column(name="ANNULEPAR")
	private Integer annulepar;
	
	@Column(name="STATUT")
	private String statut;
	
	@Column(name="DATEEFFET")
	private Date dateeffet;
	
	
	@Column(name="DATEFIN")
	private Date datefin;
	
	@Column(name="CREELE")
	private Date creele;
	
	@Column(name="MOTIFDEDESACTIVATION")
	private String motifdedesactivation;
	
	

	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="CONFIRMATIONMOTDEPASSE")
	private String confirmation_mot_de_passe;
	
	
	
	
	public String getConfirmation_mot_de_passe() {
		return confirmation_mot_de_passe;
	}

	public void setConfirmation_mot_de_passe(String confirmation_mot_de_passe) {
		this.confirmation_mot_de_passe = confirmation_mot_de_passe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmploiEntity getEmploi() {
		return emploi;
	}

	public void setEmploi(EmploiEntity emploi) {
		this.emploi = emploi;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public Integer getCreerpar() {
		return creerpar;
	}

	public void setCreerpar(Integer creerpar) {
		this.creerpar = creerpar;
	}

	public Integer getAnnulepar() {
		return annulepar;
	}

	public void setAnnulepar(Integer annulepar) {
		this.annulepar = annulepar;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public Date getCreele() {
		return creele;
	}

	public void setCreele(Date creele) {
		this.creele = creele;
	}

	public String getMotifdedesactivation() {
		return motifdedesactivation;
	}

	public void setMotifdedesactivation(String motifdedesactivation) {
		this.motifdedesactivation = motifdedesactivation;
	}

	
	

	

	public EntiteEntity getEntite() {
		return entite;
	}

	public void setEntite(EntiteEntity entite) {
		this.entite = entite;
	}

	

	

	

	

	

	
	public UserEntity(EmploiEntity emploi, EntiteEntity entite, String login, String mdp, String nom, String prenom,
			Integer creerpar, Integer annulepar, String statut, Date dateeffet, Date datefin, Date creele,
			String motifdedesactivation, String email, String confirmation_mot_de_passe) {
		this.emploi = emploi;
		this.entite = entite;
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.creerpar = creerpar;
		this.annulepar = annulepar;
		this.statut = statut;
		this.dateeffet = dateeffet;
		this.datefin = datefin;
		this.creele = creele;
		this.motifdedesactivation = motifdedesactivation;
		this.email = email;
		this.confirmation_mot_de_passe = confirmation_mot_de_passe;
	}

	public UserEntity() {
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", emploi=" + emploi + ", entite=" + entite + ", login=" + login + ", mdp="
				+ mdp + ", nom=" + nom + ", prenom=" + prenom + ", creerpar=" + creerpar + ", annulepar=" + annulepar
				+ ", statut=" + statut + ", dateeffet=" + dateeffet + ", datefin=" + datefin + ", creele=" + creele
				+ ", motifdedesactivation=" + motifdedesactivation + ", email=" + email + ", confirmation_mot_de_passe="
				+ confirmation_mot_de_passe + "]";
	}

	

	

	

	
	
	
}
