package com.billy.bob.server.domain.mapper;

import org.mybatis.spring.annotation.Mapper;

import com.billy.bob.server.domain.User;


@Mapper("userMapper")
public interface UserMapper {
	User getUserById(int id);
	User getUserByEmail(String email);
	User getUserByPasswordHash(String password_hash);
	void updateUser(User user);
	void insertUser(User user);
	void deleteUser(int id);
	int getNumUsers();
}
