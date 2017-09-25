package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.User;

public interface UserDAO
{
	public boolean createUser(User user);
	public User getUser(String userId);
	public List<User> getUsers();
	public boolean approveUser(User user);
	public boolean editUser(String userId);
	public boolean deleteUser(String userId);
	public boolean isUsernameValid(String userId);
	public boolean isEmailValid(String email);
}
