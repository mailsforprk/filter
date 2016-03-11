/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.prk.controller;

import java.util.Date;
import java.util.Map;

import org.prk.domain.BlogPost;
import org.prk.domain.User;
import org.prk.service.BlogPostService;
import org.prk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private BlogPostService blogPostServiceImpl;
	@Autowired 
	private User user;
	


	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET )
	public ModelAndView login() {
		return new ModelAndView("login", "command", new User());
		
	}
	/*
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public String validateLogin(@ModelAttribute User user,ModelMap model) {
		model.put("message", user.getUsername());
		if(userServiceImpl.validateUser(user)){
			this.user = user;
			return "userHome";
		}else{
			return "redirect:/login";
		}
		
		
	}*/
	
	@RequestMapping(value="/register", method=RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView regiter() {
		return new ModelAndView("register", "command", new User());
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST )
	public String createUser(@ModelAttribute User user,ModelMap model) {
		model.put("message", user.getUsername());
		this.user = user;
		userServiceImpl.addUser(user);
		return "userHome";
		
		}
	@RequestMapping(value="/postBlog", method=RequestMethod.GET )
	public ModelAndView newPost() {
		return new ModelAndView("newPost", "blogPost", new BlogPost());
		
	}
	
	@RequestMapping(value="/postBlog", method=RequestMethod.POST )
	public String postNewPost(@ModelAttribute BlogPost blogPost,ModelMap model) {
		blogPost.setUser(user);
		blogPostServiceImpl.addPostForUser(blogPost);
		model.put("time", new Date());
		model.put("message", user.getUsername());
		model.put("postList", blogPostServiceImpl.fetchBlogPostbyUser(user));
		return "userHome";
		
	}

}
