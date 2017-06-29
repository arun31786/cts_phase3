package com.demo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.User;
import com.demo.UserManager;
import com.demo.util.DateFormatter;

@Controller
public class MyPathsHandlers {
	@Autowired
	UserManager userManager;
//	UserManager userManager = new UserManagerImpl();
	
//	http://localhost:8080/DbDate/
	@RequestMapping(value="/", method=RequestMethod.GET)
		public String getHomePage(Model model) throws ParseException{
		model.addAttribute("title", "HomePage");
		userManager.insertUser(new User("arun@gmail.com", "Arun Kumar", DateFormatter.formatDate("1986-07-31")));
		userManager.insertUser(new User("arti@gmail.com", "Arti", DateFormatter.formatDate("1989-10-08")));
		userManager.insertUser(new User("umang@cog.com", "Umang Jain", DateFormatter.formatDate("1991-11-17")));
		userManager.insertUser(new User("mark@yahoo.co.in", "Mark Carl", DateFormatter.formatDate("1992-03-31")));
		
		return "client";
	}

	@RequestMapping(value="/getUsers",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getJsonUsers() throws ParseException{
		String d1 = "1987-01-01";
		String d2 = "1990-12-31";
		return userManager.findByDates(d1, d2);
	}


}
