package org.prk.dao;

import java.util.List;

import org.prk.domain.User;

public interface UserDao {

	
	void addUser(User user);
	boolean validateUser(User user);
	List<User> findAllUser();
	User getUserByUserName(String userName);
}
