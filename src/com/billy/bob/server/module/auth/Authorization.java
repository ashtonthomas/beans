package com.billy.bob.server.module.auth;

import com.billy.bob.client.exception.UserAlreadyExistsException;
import com.billy.bob.client.model.UserDto;
import com.billy.bob.server.domain.User;
import com.billy.bob.server.domain.dao.UserDao;


public class Authorization {
    private UserDao userDao;

	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	public UserDto authenticate(String email, String password) {
		System.out.println("Authenticating a User: " + email);
		User user = userDao.getUserByEmail(email);
		if(!(user==null) && BCrypt.checkpw(password, user.getPasswordHash())){	
			System.out.println("User exists");
			UserDto userDto = new UserDto();
			userDto.setEmail(user.getEmail());
			return userDto;
		}else{
			return null;
		}
		
	}
	
	public UserDto register(String email, String password) throws UserAlreadyExistsException {
		User user = this.userDao.getUserByEmail(email);
		
		if(user!=null){
			throw new UserAlreadyExistsException("A user with this email address already exists.");
		}else{
			// create user
			user = new User();
			user.setEmail(email);
			user.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));
			this.userDao.insertUser(user);
			UserDto userDto = new UserDto(user.getEmail());
			return userDto;
		}
	}
}
