package com.springwithhibernate.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.springwithhibernate.dao.ITestHibernateDAO;
import com.springwithhibernate.model.Account;

import java.io.Serializable;

@Repository
public class TestHibernateDAOImpl extends HibernateDaoSupport implements ITestHibernateDAO {

	
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Object test() {
		return null;
	}

	public boolean addMoney(int userId, float money) {

		Account account = this.getHibernateTemplate().get(Account.class, userId);
		account.setMoney(account.getMoney()+money);
		System.out.println(" set after 账户： " + account);
		try {
			this.getHibernateTemplate().update(account);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean minusMoney(int userId, float money) {

		Account account = this.getHibernateTemplate().get(Account.class, userId);
		System.out.println("minusMoney:  " + account + " money: " + money);
		if(account.getMoney()<=0){
			return false;
		}else{
			account.setMoney(account.getMoney()-money);
		}
		try {
			this.getHibernateTemplate().update(account);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Serializable save(Object o) {
		return this.getHibernateTemplate().save(o);
	}

	public <T> T getEntity(Class clazz,Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

}
