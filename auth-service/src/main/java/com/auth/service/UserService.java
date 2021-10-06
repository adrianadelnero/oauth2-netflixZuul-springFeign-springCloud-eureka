package com.auth.service;

import java.util.List;

import com.auth.model.Users;

public interface UserService {

	int save(Users user);
	
	List<Users> list();

}
