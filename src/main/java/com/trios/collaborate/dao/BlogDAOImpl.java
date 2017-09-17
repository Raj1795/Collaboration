package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trios.collaborate.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
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

	public List<Blog> getBlogs() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Blog where status='A'");
		List<Blog> listBlog = query.list();
		session.close();
		return listBlog;
	}

	@Transactional

	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public boolean editBlog(int blogId) {
		try {
			Session session = sessionFactory.openSession();

			Transaction tx = session.getTransaction();
			tx.begin();
			Blog blog = (Blog) session.get(Blog.class, blogId);

			blog.setBlogName(blog.getBlogName());

			blog.setBlogContent(blog.getBlogContent());
			session.update(blog);

			tx.commit();
			session.close();

			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;

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

}
