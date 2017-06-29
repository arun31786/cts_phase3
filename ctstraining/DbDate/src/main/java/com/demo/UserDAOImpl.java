package com.demo;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.demo.util.DateFormatter;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void insertUser(User user) {
    em.persist(user);
  }
  
  @Override
  public List<User> findByDates(String d1, String d2) throws ParseException{
		TypedQuery<User> query = em.createNamedQuery("selectAllBetweenDates", User.class);
		query.setParameter("d1", DateFormatter.formatDate(d1));
		query.setParameter("d2", DateFormatter.formatDate(d2));
		List<User> userList = query.getResultList();
		System.out.println("Result is "+userList);

	  return userList;
}

  
  @Override
  public List<User> findAllUsers() {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = builder.createQuery(User.class);
    Root<User> root = cq.from(User.class);
    cq.select(root);
    return em.createQuery(cq).getResultList();
  }

}