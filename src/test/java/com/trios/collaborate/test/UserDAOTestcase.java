package com.trios.collaborate.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.trios.collaborate.dao.UserDAO;

import com.trios.collaborate.model.User;


public class UserDAOTestcase {
	
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.trios.collaborate");
		annotationConfigAppContext.refresh();
		userDAO=(UserDAO)annotationConfigAppContext.getBean("userDAO");
	}
	
	@Test
	public void createUserTest(){
		User user =new User();
		user.setFirstName("Ranjith");
		user.setLastName("Raju");
		user.setEmail("naveen.6594@gmail.com");
		user.setIsOnline("Online");
		user.setPassword("trios");
		user.setRole("Admin");
		
		user.setUserId("ranjith@gmail.com");
		assertTrue("Problem in Creating User",userDAO.createUser(user));
	}
	
	
	@Ignore
	@Test
	public void getUserTest(){
		assertNotNull("problem in getting user",userDAO.getUser("ranjith@gmail.com"));
	}
	
}
