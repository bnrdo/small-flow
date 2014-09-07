package com.gexc.smf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gexc.smf.dao.CashInflowDao;
import com.gexc.smf.domain.CashInflow;

@Service
public class CashInflowService {
	
	@Autowired
	private CashInflowDao cashInflowDao;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<CashInflow> listAll(){
		return cashInflowDao.listAll();
	}
	
	@Transactional
	public void save(CashInflow inflow){
		cashInflowDao.save(inflow);
	}
	
	@Transactional
	public void delete(CashInflow inflow){
		cashInflowDao.delete(inflow);
	}
}
