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
	
	@Ignore
	@Test
	public void createFriendTest() {
		Friend friend=new Friend();
		friend.setFriendId(7);
		friend.setUserId("ranjith@gmail.com");
		friend.setStatus("NA");
		assertTrue("Problem in creating Friend",friendDAO.createFriend(friend));
	}
	@Ignore
	@Test
	public void approveFriendTest() {
		Friend friend=new Friend();
		friend.setFriendId(7);
		friend.setUserId("ranjith@gmail.com");
		friend.setStatus("NA");
		assertTrue("Problem in Approving Friend",friendDAO.approveFriend(friend));
	}
	
	@Ignore
	@Test
	public void getFriendsTest()
	{
         List<Friend> listFriend=friendDAO.getFriends();
         assertTrue("No Approved Blogs",listFriend.size()>0);
	}
	
	
	@Test
	public void deleteFriendTest()
	{
		assertTrue("Problem in deleting",friendDAO.deleteFriend(7));
	}
	@Ignore
	@Test
	public void getFriendTest(){
		assertNotNull("problem in getting blog",friendDAO.getFriend(7));
	}

}
