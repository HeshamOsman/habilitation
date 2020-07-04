package com.app.habilitation.service;

public interface EmailService {

	
	public void sendSimpleMessage(String to, String subject, String text);

	public void notifyAllWorkers(String login, Integer emploi, String name);
	
	public void notifyAllWorkersEntite(String login, Integer entite, String name);

	void sendSimpleMessage(String[] to, String subject, String text); 
	
	public void ChangeEntiteUser(String login, Integer entite, String adminEntite);

	public void sendPassword(String email);
}
