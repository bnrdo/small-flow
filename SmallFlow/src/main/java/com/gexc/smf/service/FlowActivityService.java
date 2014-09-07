package com.gexc.smf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gexc.smf.dao.FlowActivityDao;
import com.gexc.smf.domain.FlowActivity;

@Service
public class FlowActivityService {
	
	@Autowired
	private FlowActivityDao flowActivityDao;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<FlowActivity> listAll(){
		return flowActivityDao.listAll();
	}
}
