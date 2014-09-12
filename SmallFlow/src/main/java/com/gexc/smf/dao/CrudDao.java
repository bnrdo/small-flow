package com.gexc.smf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gexc.smf.domain.CashInflow;

@Repository
public class CrudDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(T t) {
		currentSession().saveOrUpdate(t);
	}

	public void delete(T t) {
		currentSession().delete(t);
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
