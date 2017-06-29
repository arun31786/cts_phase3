package com.demo;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userManager")
public class UserManagerImpl implements UserManager {

  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional
  public void insertUser(User user) {
    userDAO.insertUser(user);
  }

  @Override
  public List<User> findAllUsers() {
    return userDAO.findAllUsers();
  }
  
  @Override
  public List<User> findByDates(String d1, String d2) throws ParseException{
	  return userDAO.findByDates(d1, d2);
  }


}