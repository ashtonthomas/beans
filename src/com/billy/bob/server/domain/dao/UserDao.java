package com.billy.bob.server.domain.dao;

import com.billy.bob.server.domain.User;


public interface UserDao {
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public User getUserByPasswordHash(String password_hash);
	public void saveUser(User user);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public void deleteUser(int id);
	public int numUsers();
}
