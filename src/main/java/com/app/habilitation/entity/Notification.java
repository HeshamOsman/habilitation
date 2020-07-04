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

@Entity
@Table(name="NOTIFICATION")
@SequenceGenerator(name="notif_gen",sequenceName="notif_seq",allocationSize = 1)
public class Notification {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "notif_gen")
	@Column(name="IDENTIFIANT")
	private Integer id;
	
	@Column(name="MESSAGE")
	private String message;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserEntity user;
	
	@Column(name="ISSENT")
	private String isSent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getIsSent() {
		return isSent;
	}

	public void setIsSent(String isSent) {
		this.isSent = isSent;
	}

	public Notification(String message, UserEntity user, String isSent) {
		this.message = message;
		this.user = user;
		this.isSent = isSent;
	}

	public Notification() {
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + ", isSent=" + isSent + "]";
	}
	
	
	

}
