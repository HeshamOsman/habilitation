package com.app.habilitation.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.app.habilitation.service.NotificationService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/notif")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	 public SseEmitter handle(HttpServletResponse response, Authentication auth) {
	    response.setHeader("Cache-Control", "no-store");
        UserDetails user = (UserDetails) auth.getPrincipal();
        String username = user.getUsername();
        
        return notificationService.registerListener(username);
	
	  }
	
	
  
}
