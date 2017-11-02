package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.Blog;
import com.trios.collaborate.model.BlogComment;

@Repository("blogDAO")

@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean createBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public Blog getBlog(int blogId) {
		Session session = sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	public List<Blog> getBlogs(int approved) {
		Session session = sessionFactory.getCurrentSession();
		String queryStr="";
		if(approved==1){
			queryStr="from Blog where approved=" +approved;}
		else{
			queryStr="from Blog where rejectionReason is null and approved=" +approved;}
		Query query = session.createQuery(queryStr);
		
		return query.list();
	}

	

	

	public boolean deleteBlog(int blogId) {
		try {
			Session session = sessionFactory.openSession();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			session.delete(blog);
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}


	public void updateBlog(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
	}


	public void addBlogComment(BlogComment blogComment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(blogComment);
	}


	public List<BlogComment> getBlogComments(int Id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BlogComment where blog.blogId="+Id);
		return query.list();
	}


	public List<Blog> getNotification(String userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog where postedBy.userId=? and viewed=? and(approved=1 or rejectionReason!=null)" );
		query.setString(0,userId);
		query.setBoolean(1,false);
		return query.list();
	}

}
