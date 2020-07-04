package com.app.habilitation.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.app.habilitation.dao.NotifactionDao;
import com.app.habilitation.entity.Notification;
import com.app.habilitation.entity.UserEntity;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotifactionDao notifactionDao;
	
	private Map<String,SseEmitter> listeners = new HashMap<>();
	
	private String adminMessage =  "Félicitation cher %s  vous venez de changer votre entité, votre nouvelle entité maintenant est : %s ";

	private String managerMessage =  "Félicitation cher %s  vous venez de changer d'emploi, votre nouveau emploi est : %s";
	
	
	@Override
	public void createNotification(UserEntity toUser,boolean isAdmin,String newPlace,String newCareerPath)  {
		Notification notification = new Notification();
		notification.setUser(toUser);
	    
		notification.setMessage(isAdmin?String.format(adminMessage, toUser.getNom(),newPlace):
			String.format(managerMessage, toUser.getNom(),newCareerPath));
		notification.setIsSent("F");
		if(listeners.containsKey( toUser.getLogin())){
			try {
				listeners.get(toUser.getLogin()).send(notification);
				notification.setIsSent("T");
			} catch (IOException e) {
				notification.setIsSent("F");
				listeners.remove(toUser.getLogin());
			}
		}
		notifactionDao.save(notification);
		
	}
	
	

	@Override
	public SseEmitter registerListener(String username) {
	    SseEmitter emitter = new SseEmitter();

	    this.listeners.put("username",emitter);

	    emitter.onCompletion(() -> this.listeners.remove(username));
	    emitter.onTimeout(() -> this.listeners.remove(username));
	    
	    getUnSentnotificationByUser(username);
	    return emitter;
	}



	@Override
	@Async
	public void getUnSentnotificationByUser(String username) {
		
		
		List<Notification> ns =  notifactionDao.getNotificationByUsername(username);
		
		
		for(Notification n:ns) {
			
			if(listeners.containsKey(username)){
				try {
					listeners.get(username).send(n);
					n.setIsSent("T");
				} catch (IOException e) {
					n.setIsSent("F");
					listeners.remove(username);
				}
			}
			
		}
	}
	
	

}
