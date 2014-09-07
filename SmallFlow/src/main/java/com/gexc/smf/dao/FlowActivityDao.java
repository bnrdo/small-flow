package com.gexc.smf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gexc.smf.domain.FlowActivity;

@Repository
public class FlowActivityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List listAll(){
		return sessionFactory.getCurrentSession().createCriteria(FlowActivity.class).list();
	}
}
