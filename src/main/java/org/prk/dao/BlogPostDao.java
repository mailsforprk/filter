package org.prk.dao;

import java.util.List;

import org.prk.domain.BlogPost;
import org.prk.domain.User;

public interface BlogPostDao {
	void addPostForUser(BlogPost post);
	List<BlogPost>  fetchBlogPostbyUser(User user);
}
