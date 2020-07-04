package com.app.habilitation.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.habilitation.dao.UserDao;
import com.app.habilitation.entity.EmploiEntity;
import com.app.habilitation.entity.UserEntity;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userdao.findByLogin(username);
		EmploiEntity emploi = user.getEmploi();
		String role = null;
		if(!Objects.isNull(emploi)) {
			role = emploi.getCode().trim();
		}
	   return User.builder()
			   .username(user.getLogin())
			   .password("{noop}"+ user.getMdp())
			   .roles(role).build();
	}

}
