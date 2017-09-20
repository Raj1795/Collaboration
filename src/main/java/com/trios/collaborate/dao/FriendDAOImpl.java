package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.Blog;
import com.trios.collaborate.model.Friend;

@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean createFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public Friend getFriend(int friendId) {
		Session session = sessionFactory.openSession();
		Friend friend = (Friend) session.get(Friend.class,friendId);
		session.close();
		return friend;
		
	}

	public List<Friend> getFriends() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Blog where status='A'");
		List<Friend> listFriend = query.list();
		session.close();
		return listFriend;
	}

	@Transactional
	public boolean approveFriend(Friend friend) {
		try {
			friend.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}		return false;
	}

	public boolean editFriend(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteFriend(int friendId) {
		try {
			Session session = sessionFactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);
			session.delete(friend);
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

}
