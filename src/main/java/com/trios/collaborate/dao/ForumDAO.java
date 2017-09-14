package com.trios.collaborate.dao;

import java.util.List;



import com.trios.collaborate.model.Forum;



public interface ForumDAO {
	public boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getForums();
	public boolean approveForum(Forum forum);
	public boolean editForum(int forumId);
	public boolean deleteForum(int forumId);
	
}
