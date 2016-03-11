package org.prk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.prk.dao.UserDao;
import org.prk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ParentServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	
	@Transactional
	@Override
	public void addUser(User user) {
		
		userDao.addUser(user);
		
	}

	@Transactional
	@Override
	public boolean validateUser(User user) {
		
		return userDao.validateUser(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

}
