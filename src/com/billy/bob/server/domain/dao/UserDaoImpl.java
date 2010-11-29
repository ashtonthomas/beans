package com.billy.bob.server.domain.dao;

import com.billy.bob.server.domain.User;
import com.billy.bob.server.domain.mapper.UserMapper;


public class UserDaoImpl implements UserDao {
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper){
		this.userMapper = userMapper;
	}
	public User getUserById(int id) {
		return this.userMapper.getUserById(id);
	}
	
	public User getUserByEmail(String email){
		return this.userMapper.getUserByEmail(email);
	}
	
	public User getUserByPasswordHash(String id) {
		return this.userMapper.getUserByPasswordHash(id);
	}

	public void saveUser(User user) {
		if(this.userMapper.getUserById(user.getId())!=null){
			//update the user

		}else{
			// user is new, insert

		}
		
	}

	public void insertUser(User user) {
		this.userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}

	public void deleteUser(User user) {
		this.userMapper.deleteUser(user.getId());
	}
	
	public void deleteUser(int id){
		this.userMapper.deleteUser(id);
	}
	
	public int numUsers(){
		return this.userMapper.getNumUsers();
	}

}
