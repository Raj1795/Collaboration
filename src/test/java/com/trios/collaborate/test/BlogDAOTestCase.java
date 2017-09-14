package com.trios.collaborate.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trios.collaborate.dao.BlogDAO;

import com.trios.collaborate.model.Blog;


public class BlogDAOTestCase {
	
	
	
	static BlogDAO blogDAO;
             
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.trios.collaborate");
		annotationConfigAppContext.refresh();
		blogDAO=(BlogDAO)annotationConfigAppContext.getBean("blogDAO");
	}
	@Ignore
	@Test
	public void createBlogTest() {
		Blog blog=new Blog();
		blog.setBlogId(10);
		blog.setBlogName("VertiGo");
		blog.setBlogContent("New Era of AeroDynamic");
		blog.setUserId("ranjith@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in creating Blog",blogDAO.createBlog(blog));
	}

	
	@Test
	public void approveBlogTest() {
		Blog blog=new Blog();
		blog.setBlogId(10);
		blog.setBlogName("VertiGo");
		blog.setBlogContent("New Era of AeroDynamic");
		blog.setUserId("ranjith@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in Approving Blog",blogDAO.approveBlog(blog));
	}
	@Test
	public void editBlogTest()
	{
          Blog blog =new Blog();
          blog.setBlogId(10);
          blog.setBlogName("Wall climber");
          blog.setBlogContent("Advance technology");
	}

}
