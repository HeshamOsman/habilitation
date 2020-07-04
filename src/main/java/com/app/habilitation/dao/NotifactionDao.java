package com.app.habilitation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.habilitation.entity.Notification;

@Repository
public interface NotifactionDao extends JpaRepository<Notification, Integer> {
	
	@Query("select n from Notification n where n.user.login = :login ")
	List<Notification> getNotificationByUsername(@Param("login`") String username);

}
