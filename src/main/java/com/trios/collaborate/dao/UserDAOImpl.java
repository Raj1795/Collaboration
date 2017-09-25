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
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean createUser(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public User getUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
		
	}

	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from user where status='A'");
		List<User> listUser = query.list();
		session.close();
		return listUser;
		
	}

	
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

	public boolean editUser(String userId) {
		
		return false;
	}

	public boolean deleteUser(String userId) {
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

	public boolean isUsernameValid(String userId) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,userId);
		if(user==null)
			return true;
			else
		return false;
	}

	public boolean isEmailValid(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0,email);
		User user=(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		return false;
	}

}
