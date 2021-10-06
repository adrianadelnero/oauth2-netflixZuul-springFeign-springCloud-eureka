package com.auth.dao;

import com.auth.model.Roles;
import com.auth.model.Users;

public interface RoleDao {

	int saveRole(Roles roles,Users user);
}
