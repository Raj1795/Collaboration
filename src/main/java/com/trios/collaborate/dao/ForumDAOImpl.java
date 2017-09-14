package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.Forum;


@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean createForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}

	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Forum> getForums() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}

	public boolean editForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteForum(int forumId) {
		// TODO Auto-generated method stub
		return false;
	}

}
