package com.app.habilitation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.habilitation.dao.EmploiDao;
import com.app.habilitation.dao.EntityDao;
import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.EntiteEntity;
import com.app.habilitation.entity.UserEntity;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	public UserDao userDao;
	@Autowired
	public EmploiDao emploiDao;

	@Autowired
	public EntityDao entiteDao;
	@Autowired
	private NotificationService notificationService;

	public EmailServiceImpl(UserDao theUserDao, EmploiDao theEmploiDao, EntityDao theEntiteDao) {
		userDao = theUserDao;
		emploiDao = theEmploiDao;
		entiteDao = theEntiteDao;
	}

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void sendSimpleMessage(String[] to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void notifyAllWorkers(String login, Integer emploi, String drtLogin) {

		EmploiEntity newEmploi = emploiDao.findById(emploi).get();
		UserEntity worker = userDao.findByLogin(login);
		UserEntity drt = userDao.findByLogin(drtLogin);
		worker.setEmploi(newEmploi);
		if (worker.getEntite().getId() == drt.getEntite().getId()) {
			userDao.save(worker);
			String[] allColeaguesEmails = userDao.findByEntiteId(worker.getEntite().getId()).stream()
					.map(UserEntity::getEmail).collect(Collectors.toList()).toArray(new String[0]);
			sendSimpleMessage(allColeaguesEmails, "Changement de Post",
					"On est heureux de vous annoncez cher " + worker.getNom() + " " + worker.getPrenom()
							+ " que vous avez bien changé d'emploi, et que votre nouveau emploi en ce moment est :"
							+ newEmploi.getNom());
			notificationService.createNotification(worker, false, null, newEmploi.getNom());
		} else {
			throw new RuntimeException("le user ne se trouve pas dans la meme entité que la votre");
		}

	}

	@Override
	public void ChangeEntiteUser(String login, Integer entite, String adminEntite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendPassword(String email) {
		UserEntity user = userDao.findByEmail(email);
		this.sendSimpleMessage(email, "Password", "Votre mot de passe est :" + user.getMdp());

	}

	@Override
	public void notifyAllWorkersEntite(String login, Integer entite, String adminLogin) {

		EntiteEntity newEntite = entiteDao.findById(entite).get();
		UserEntity worker = userDao.findByLogin(login);
		UserEntity admin = userDao.findByLogin(adminLogin);

		if (worker.getEntite().getId() == admin.getEntite().getId()) {
			worker.setEntite(newEntite);
			userDao.save(worker);
			String[] allColeaguesEmails = userDao.findByEntiteId(worker.getEntite().getId()).stream()
					.map(UserEntity::getEmail).collect(Collectors.toList()).toArray(new String[0]);
			sendSimpleMessage(allColeaguesEmails, "Changement d'entite",
					"On est heureux de vous annoncez cher " + worker.getNom() + " " + worker.getPrenom()
							+ " que vous avez bien changé d'entite, et que votre nouvelle entite en ce moment est :"
							+ newEntite.getNom());
			notificationService.createNotification(worker, true, newEntite.getNom(), null);
		}

		else {
			throw new RuntimeException("le user ne se trouve pas dans la meme entité que la votre");
		}
	}

}
