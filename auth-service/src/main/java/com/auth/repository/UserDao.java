package com.auth.dao;

import java.util.List;

import com.auth.model.Users;

public interface UserDao {

	int saveUser(Users user);

	List<Users> getAllUser();
	
	public Users findUserByEmail(String username);
}
