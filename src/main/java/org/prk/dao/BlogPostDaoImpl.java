package org.prk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.prk.domain.BlogPost;
import org.prk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogPostDaoImpl extends ParentDaoImpl implements BlogPostDao {

	@Autowired
	private UserDao userDao;
	@Override
	public void addPostForUser(BlogPost post) {
		System.out.println(post.getUser().getUsername());
		post.setUser(userDao.getUserByUserName(post.getUser().getUsername()));
		getCurrentSession().saveOrUpdate(post);
		
	}

	@Override
	public List<BlogPost> fetchBlogPostbyUser(User user) {
		Criteria c = getCurrentSession().createCriteria(BlogPost.class,"post");
		c.createAlias("post.user", "user");
		c.add(Restrictions.eq("user.username",user.getUsername()));
		return (List<BlogPost>) c.list();
	}

}
