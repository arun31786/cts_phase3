package com.demo;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
@NamedQueries(@NamedQuery(name="selectAllBetweenDates",query="select user from User user where user.dateofbirth BETWEEN :d1 AND :d2"))
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID", nullable = false)
  private int id;
  
  @Column(name="EMAIL", nullable = false)
  private String email;
  
  @Column(name="NAME", nullable = false)
  private String name;
  
  @Column(name="DOB", nullable = false)
  private Date dateofbirth;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDateofbirth() {
	return dateofbirth;
}

public void setDateofbirth(Date dateofbirth) {
	this.dateofbirth = dateofbirth;
}

public User(String email, String name, Date dateofbirth) {
	super();
	this.email = email;
	this.name = name;
	this.dateofbirth = dateofbirth;
}

public User() {}

@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", name=" + name
			+ ", dateofbirth=" + dateofbirth + "]";
}
  
}