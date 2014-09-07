package com.gexc.smf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gexc.smf.domain.CashInflow;

@Repository
public class CashInflowDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List listAll(){
		return criteria(CashInflow.class).list();
	}
	
	public void save(CashInflow inflow){
		currentSession().saveOrUpdate(inflow);
	}
	
	public void delete(CashInflow inflow){
		currentSession().delete(inflow);
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private Criteria criteria(Class<?> clazz){
		return currentSession().createCriteria(clazz);
	}
}
