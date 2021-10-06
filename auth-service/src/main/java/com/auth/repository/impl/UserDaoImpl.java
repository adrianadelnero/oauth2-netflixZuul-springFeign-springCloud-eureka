package com.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.dao.UserDao;
import com.auth.model.Users;


@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	EntityManagerFactory entityManger;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public int saveUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try (Session openSession = entityManger.unwrap(SessionFactory.class).openSession()) {
			System.out.println(openSession.isConnected());
			openSession.save(user);
			openSession.beginTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user.getUserid();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUser() {
		List<Users> userList = new ArrayList<Users>();
		try (Session openSession = entityManger.unwrap(SessionFactory.class).openSession()) {
			userList = openSession.createCriteria(Users.class).list();
			openSession.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Users findUserByEmail(String username) {
		Users user = null;
		try (Session openSession = entityManger.unwrap(SessionFactory.class).openSession()) {
			user = (Users) openSession.createCriteria(Users.class).add(Restrictions.eq("email", username)).uniqueResult();
			openSession.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
