package org.prk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParentDaoImpl implements ParentDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}

}
