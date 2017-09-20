package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.Friend;

public interface FriendDAO {
	public boolean createFriend(Friend friend);
	public Friend getFriend(int friendId);
	public List<Friend> getFriends();
	public boolean approveFriend(Friend friend);
	public boolean editFriend(int friendId);
	public boolean deleteFriend(int friendId);
}
