package com.gexc.smf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gexc.smf.domain.CashInflow;
import com.gexc.smf.model.TableData;
import com.gexc.smf.service.CashInflowService;

@Controller
public class MainController {
	
	@Autowired
	private CashInflowService ciServ;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	protected String showDashboard(HttpServletRequest request) throws Exception {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/read.do", method = RequestMethod.GET)
	protected TableData<CashInflow> read(HttpServletRequest request) throws Exception {
		return new TableData<CashInflow>(ciServ.listAll());
	}
}