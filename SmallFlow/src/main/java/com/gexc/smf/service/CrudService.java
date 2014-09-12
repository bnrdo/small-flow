package com.gexc.smf.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gexc.smf.dao.CrudDao;

@Service
public class CrudService<T> {
	
	@Autowired
	private CrudDao<T> dao;
	
	@Transactional
	public void save(T t){
		dao.save(t);
	}
	
	@Transactional
	public void delete(T t){
		dao.delete(t);
	}
}
