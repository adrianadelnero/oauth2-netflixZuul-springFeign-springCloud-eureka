package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.dao.UserDao;
import com.auth.model.Users;

@Service
public class CustomUserDetails implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userEntity = userDao.findUserByEmail(username);
		if (userEntity == null) {
			throw new RuntimeException("Usuário não encontrado " + username);
		}
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, userEntity.getRoleses());
		return user;
	}

}
