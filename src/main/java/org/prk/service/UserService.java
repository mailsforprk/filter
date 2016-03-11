package org.prk.service;

import java.util.List;

import org.prk.domain.User;

public interface UserService {

	void addUser(User user);
	boolean validateUser(User user);
	List<User> findAllUser();
	User getUserByUserName(String userName);
}
