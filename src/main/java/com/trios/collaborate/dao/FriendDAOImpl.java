package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.Friend;
import com.trios.collaborate.model.User;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	

	

	
	public List<User> getFriends(String userId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from user_trios where userId in"
				+"(select userId from user_trios where userId!=?minus"
				+"(select fromId from friend where toId=?"
				+"union select toId from friend where fromId=?)"
				+")");
		query.setString(0, userId);
		query.setString(1, userId);
		query.setString(2, userId);
		query.addEntity(User.class);
		List<User> suggestedUser = query.list();
		
		return  suggestedUser;
	}







	public void friendRequest(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.save(friend);
	}







	public List<Friend> pendingRequest(String toId) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0,toId);
		return query.list();
	}







	public void updateRequest(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		 if(friend.getStatus()=='A'){
			 session.update(friend);
		 }else{
			 session.delete(friend);
		 }
	}

	

	

}
