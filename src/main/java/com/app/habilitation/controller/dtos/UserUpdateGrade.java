package com.app.habilitation.controller.dtos;

public class UserUpdateGrade {

	
	public String login;
	public Integer emploi;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getEmploi() {
		return emploi;
	}
	public void setEmploi(Integer emploi) {
		this.emploi = emploi;
	}
	public UserUpdateGrade(String login, Integer emploi) {
		this.login = login;
		this.emploi = emploi;
	}
	public UserUpdateGrade() {
	}
	@Override
	public String toString() {
		return "UserUpdateGrade [login=" + login + ", emploi=" + emploi + "]";
	}
	
	
}
