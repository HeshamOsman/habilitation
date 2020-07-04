package com.app.habilitation.service;

import java.util.List;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.app.habilitation.entity.Notification;
import com.app.habilitation.entity.UserEntity;

public interface NotificationService {
	
	
	
	void createNotification(UserEntity toUser,boolean isAdmin,String newPlace,String newCareerPath);
	
	
	SseEmitter registerListener(String username);
	void getUnSentnotificationByUser(String username);

}
