package com.trios.collaborate.test;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void createBlogTest() {
		Blog blog=new Blog();
		blog.setBlogId(10);
		blog.setBlogName("VertiGo");
		blog.setBlogContent("New Era of AeroDynamic");
		
		blog.setLikes(0);
		assertTrue("Problem in creating Blog",blogDAO.createBlog(blog));
	}

	
	
	
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		assertTrue("Problem in deleting",blogDAO.deleteBlog(10));
	}
	@Ignore
	@Test
	public void getBlogTest(){
		assertNotNull("problem in getting blog",blogDAO.getBlog(10));
	}
	
}
