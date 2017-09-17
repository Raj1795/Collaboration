package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.User;

public interface UserDAO
{
	public boolean createUser(User user);
	public User getUser(int userId);
	public List<User> getUsers();
	public boolean approveUser(User user);
	public boolean editUser(int userId);
	public boolean deleteUser(int userId);
}
