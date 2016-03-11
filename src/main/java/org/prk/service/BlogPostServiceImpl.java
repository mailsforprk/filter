package org.prk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.prk.dao.BlogPostDao;
import org.prk.domain.BlogPost;
import org.prk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class BlogPostServiceImpl extends ParentServiceImpl implements BlogPostService  {

	@Autowired
	private BlogPostDao blogPostDao;
	
	@Override
	@Transactional
	public void addPostForUser(BlogPost post) {

		blogPostDao.addPostForUser(post);
		
	}

	@Override
	@Transactional
	public List<BlogPost> fetchBlogPostbyUser(User user) {
		
		return blogPostDao.fetchBlogPostbyUser(user);
	}
	
}
