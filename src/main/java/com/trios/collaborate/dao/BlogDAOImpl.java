package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.trios.collaborate.model.Blog;



@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	
	
	
		@Autowired
		SessionFactory sessionFactory;
		public BlogDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public boolean createBlog(Blog blog) {
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
			return false;
		}

		public Blog getBlog(int blogId) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Blog> getBlogs() {
			
			return null;
		}
	@Transactional

		public boolean approveBlog(Blog blog) {
			try
			{
				blog.setStatus("A");
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
				return true;
			}
			catch(Exception e){
				System.out.println("Exception Arised:"+e);
			}
			return false;
		}

		public boolean editBlog(int blogId) {
			try
			{
				Session s=sessionFactory.openSession();
				   
				 Transaction tx=s.getTransaction();
						tx.begin();
					Blog blog=(Blog)s.get(Blog.class,blogId);
						
						blog.setBlogName(blog.getBlogName());
								
						blog.setBlogContent(blog.getBlogContent());
						s.update(blog);
						
						tx.commit();
						s.close();
				
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
			return false;
			
		}
 
		public boolean deleteBlog(int blogId) {
			try
			{
				sessionFactory.getCurrentSession().delete(blogId);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
			}
			return false;
		}
	
}
