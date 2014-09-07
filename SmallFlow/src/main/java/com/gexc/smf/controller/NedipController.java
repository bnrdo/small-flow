package com.gexc.smf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gexc.smf.domain.CashInflow;
import com.gexc.smf.domain.FlowActivity;
import com.gexc.smf.service.CashInflowService;
import com.gexc.smf.service.FlowActivityService;

import static com.gexc.smf.util.Util.capitalizeFirstLetter;

@Controller
@SessionAttributes({"oper", "path", "isReadOnly"})
public class NedipController {
	
	@Autowired
	private FlowActivityService faServ;
	
	@Autowired
	private CashInflowService cinServ;
	

	@RequestMapping(value = "nedip/editOrDelete.do", method = RequestMethod.POST)
	protected String editOrDelete(ModelMap model, @RequestBody CashInflow cashInflow, @RequestParam String oper)
			throws Exception {
		
		boolean isReadOnly = "edit".equals(oper) ? false : true;
		
		model.put("cashInflowForm", cashInflow);
		
		model.put("isReadOnly", isReadOnly);
		model.put("path",  capitalizeFirstLetter(oper) + " " + cashInflow.getId() + "?");
		model.put("oper", oper);
		
		return "cash-inflow/nedip";
	}
	
	@RequestMapping(value = "nedip/new.do", method = RequestMethod.GET)
	protected String createNew(ModelMap model)
			throws Exception {
		
		String oper = "new";
		
		model.put("cashInflowForm", new CashInflow());
		
		model.put("isReadOnly", false);
		model.put("path", capitalizeFirstLetter(oper));
		model.put("oper", oper);
		
		return "cash-inflow/nedip";
	}
	
	@RequestMapping(value = "nedip/save.do", method = RequestMethod.POST)
	protected String save(@Valid @ModelAttribute("cashInflowForm") CashInflow cashInflowForm, 
						BindingResult binding, ModelMap model){
		
		if(binding.hasErrors()){
			return "cash-inflow/nedip";
		}
		
		cinServ.save(cashInflowForm);
		
		return "cash-inflow/cash-inflow";
	}
	
	@RequestMapping(value = "nedip/delete.do", method = RequestMethod.POST)
	protected String delete(@Valid @ModelAttribute("cashInflowForm") CashInflow cashInflowForm, BindingResult binding){
		
		cinServ.delete(cashInflowForm);
		
		return "cash-inflow/cash-inflow";
	}

	@ModelAttribute("activityList")
	public List<FlowActivity> getFlowAcitivities() {
		return faServ.listAll();
	}
}
