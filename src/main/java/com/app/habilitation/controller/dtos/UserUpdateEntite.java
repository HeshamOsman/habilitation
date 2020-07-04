package com.app.habilitation.controller.dtos;

public class UserUpdateEntite {

	public String login;
	public Integer entite;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getEntite() {
		return entite;
	}
	public void setEntite(Integer entite) {
		this.entite = entite;
	}
	
	
	public UserUpdateEntite() {
	}
	
	public UserUpdateEntite(String login, Integer entite) {
		this.login=login;
		this.entite=entite;
	}
	
	
	@Override
	public String toString() {
		return "UserUpdateEntite[login=" + login + ", entite=" + entite + "]";
	}
}
