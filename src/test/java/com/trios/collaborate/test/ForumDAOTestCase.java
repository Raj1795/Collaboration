package com.trios.collaborate.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.trios.collaborate.dao.ForumDAO;
import com.trios.collaborate.model.Forum;


public class ForumDAOTestCase {

	static ForumDAO forumDAO;
             
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.trios.collaborate");
		annotationConfigAppContext.refresh();
		forumDAO=(ForumDAO)annotationConfigAppContext.getBean("forumDAO");
	}
	@Test
	public void createForumTest() {
		Forum forum=new Forum();
		forum.setForumId(10);
		forum.setForumName("VertiGo");
		forum.setForumContent("New Era of AeroDynamic");
		forum.setUserId("ranjith@gmail.com");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		assertTrue("Problem in creating Forum",forumDAO.createForum(forum));
	}
}
