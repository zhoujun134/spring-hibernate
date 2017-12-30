package com.springwithhibernate.service.impl;

import com.springwithhibernate.dao.ITestHibernateDAO;
import com.springwithhibernate.service.ITestHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("testHibernateService")
public class TestHibernateServiceImpl implements ITestHibernateService {

	@Autowired
	private ITestHibernateDAO testHibernateDAO;
	
	public void test() {
		Object o = this.testHibernateDAO.test();
		System.out.println("test: " + o);
	}

	public boolean transfer(float money, int from, int to) throws Exception{
		
		if(money>0){
			boolean b = this.testHibernateDAO.minusMoney(from, money);
			if(!b){
				throw new Exception("余额不足");
			}
//			int i = 1/0;
			this.testHibernateDAO.addMoney(to, money);
			return true;
		}else{
			return false;
		}
	}

	public Serializable save(Object o) {
		
		return this.testHibernateDAO.save(o);
	}
	
	public <T> T getEntity(Class clazz,Serializable id){
		
		return this.testHibernateDAO.getEntity(clazz, id);
	}
}
