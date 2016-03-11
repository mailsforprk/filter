package org.prk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.prk.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends ParentDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		getCurrentSession().saveOrUpdate(user);
		getCurrentSession().flush();
		
	}

	@Override
	public boolean validateUser(User user) {
		Criteria c = getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("username",user.getUsername())).add(Restrictions.eq("password", user.getPassword()));
		if(c.list().size() > 0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		Criteria c = getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("username",userName));
		return (User) c.uniqueResult();
	} 

	
	
}
