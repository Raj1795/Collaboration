package com.trios.collaborate.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.trios.collaborate.dao.FriendDAO;
import com.trios.collaborate.model.Blog;
import com.trios.collaborate.model.Friend;

public class FriendDAOTestCase {
	
static FriendDAO friendDAO;
             
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.trios.collaborate");
		annotationConfigAppContext.refresh();
		friendDAO=(FriendDAO)annotationConfigAppContext.getBean("friendDAO");
	}
	
	
	

}
