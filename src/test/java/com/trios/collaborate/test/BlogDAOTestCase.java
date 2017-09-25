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
		blog.setUserId("ranjith@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		assertTrue("Problem in creating Blog",blogDAO.createBlog(blog));
	}

	@Ignore
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
	
	@Ignore
	@Test
	public void getBlogsTest()
	{
         List<Blog> listBlog=blogDAO.getBlogs();
         assertTrue("No Approved Blogs",listBlog.size()>0);
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
