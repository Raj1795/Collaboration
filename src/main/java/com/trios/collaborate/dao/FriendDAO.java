package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.Friend;
import com.trios.collaborate.model.User;

public interface FriendDAO {
	
	
	public void friendRequest(Friend friend);
	public List<User> getFriends(String userId);
	public List<Friend>pendingRequest(String toId);
	public void updateRequest(Friend friend);
	
	
}
