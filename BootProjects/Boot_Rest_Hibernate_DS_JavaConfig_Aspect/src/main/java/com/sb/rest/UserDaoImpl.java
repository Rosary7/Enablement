package com.sb.rest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	/**
	 * When we create session using SessionFactory.openSession(), no transaction is created, so our operations are 
	 * executed outside of transaction context. 
     * In order to see our changes, we have to start a new transaction and commit it,
	 */
	// Programmatic  transaction management
    public User addUser1(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = null;
		logger.info("....Entering addUser1().....");
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			logger.info("....commit....");
		} catch (Exception e) {
			if(tx != null){
				logger.info("....rollback.....");
				tx.rollback();
			}
		}
		return user;
	}
	
    // Declarative  transaction management with Spring
	@Transactional
	 public User addUser2(User user) {
		logger.info("....Entering addUser1().....");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}
    
    public List <User> getAllUsers() {
    	Session session = this.sessionFactory.getCurrentSession();
		List<User>  list = session.createQuery("from User").list();
		logger.info("....Entering getAllUsers()");
		return list;
    }
    
}
