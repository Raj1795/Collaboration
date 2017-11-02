package com.trios.collaborate.dao;




import com.trios.collaborate.model.User;

public interface UserDAO
{
	public boolean createUser(User user);
	public User getUser(String userId);
	
	
	public boolean isupdateEmailValid(String email,String userId);
	
	public boolean isUsernameValid(String userId);
	public boolean isEmailValid(String email);
	public User login(User user);
	public void update (User user);
}
