package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.trios.collaborate.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean createUser(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
		
	}

	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Blog where status='A'");
		List<User> listUser = query.list();
		session.close();
		return listUser;
		
	}

	@Transactional
	public boolean approveUser(User user) {
		try {
			user.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public boolean editUser(int userId) {
		
		return false;
	}

	public boolean deleteUser(int userId) {
		try {
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

}
