package com.trios.collaborate.dao;



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


	public User login(User user) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where userId=? and password=?");
		query.setString(0,user.getUserId());
		query.setString(1,user.getPassword());
		user=(User)query.uniqueResult();
		return user;
	}


	public void update(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		
	}


	public boolean isupdateEmailValid(String email, String userId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and userId!=?");
		query.setString(0,email);
		query.setString(1,userId);
		User user=(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		return false;
	}

}
