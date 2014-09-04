package com.gexc.smf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	protected String showDashboard(HttpServletRequest request) throws Exception {
		return "index";
	}
}