package com.demo;

import java.text.ParseException;
import java.util.List;

public interface UserDAO {

	  void insertUser(User user);
	  List<User> findAllUsers();
	  List<User> findByDates(String d1, String d2) throws ParseException;

	}