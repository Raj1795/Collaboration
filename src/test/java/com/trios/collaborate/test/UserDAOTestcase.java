package com.trios.collaborate.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.trios.collaborate.dao.UserDAO;
import com.trios.collaborate.model.Blog;
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
	@Ignore
	@Test
	public void createUserTest(){
		User user =new User();
		user.setFirstName("Ranjith");
		user.setLastName("Raju");
		user.setEmail("ranjith@gmail.com");
		user.setIsOnline("Online");
		user.setPassword("trios");
		user.setRole("Admin");
		user.setStatus("NA");
		user.setUserId("ranjith@gmail.com");
		assertTrue("Problem in Creating User",userDAO.createUser(user));
	}
	
	@Test
	public void approveUserTest(){
		User user =new User();
		user.setFirstName("Ranjith");
		user.setLastName("Raju");
		user.setEmail("ranjith@gmail.com");
		user.setIsOnline("Online");
		user.setPassword("trios");
		user.setRole("Admin");
		user.setStatus("NA");
		user.setUserId("naveen@gmail.com");
		assertTrue("Problem in Approving User",userDAO.approveUser(user));
	}
	@Ignore
	@Test
	public void getUsersTest()
	{
         List<User> listUser=userDAO.getUsers();
         assertTrue("No Approved Users",listUser.size()>0);
	}
}
