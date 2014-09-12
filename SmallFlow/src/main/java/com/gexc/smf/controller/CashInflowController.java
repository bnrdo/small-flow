package com.gexc.smf.controller;

import com.gexc.smf.model.Field;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gexc.smf.domain.CashInflow;
import com.gexc.smf.domain.FlowActivity;
import com.gexc.smf.model.TableConfig;
import com.gexc.smf.model.TableData;
import com.gexc.smf.service.CashInflowService;
import com.gexc.smf.service.FlowActivityService;

@Controller
@RequestMapping(value = "cash-inflow/")
public class CashInflowController extends CrudController<CashInflow> {

	@Autowired
	private FlowActivityService faServ;

	@Autowired
	private CashInflowService cinServ;

	@RequestMapping(value = "editOrDelete.do", method = RequestMethod.POST)
	protected String editOrDelete(ModelMap model, @RequestBody CashInflow form,
			@RequestParam String oper) throws Exception {
		return super.editOrDelete(model, form, oper);
	}

	@RequestMapping(value = "new.do", method = RequestMethod.GET)
	protected String createNew(ModelMap model) throws Exception {
		return super.createNew(model);
	}

	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	protected String save(@Valid @ModelAttribute("form") CashInflow form,
			BindingResult binding, ModelMap model) {
		return super.save(form, binding, model);
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	protected String delete(@Valid @ModelAttribute("form") CashInflow form,
			BindingResult binding) {
		return super.delete(form, binding);
	}

	@RequestMapping(value = "crud.do", method = RequestMethod.GET)
	protected String show(ModelMap model) {
		return super.show(model);
	}
	
	@RequestMapping(value = "back.do", method = RequestMethod.GET)
	protected String back() {
		return super.back();
	}

	@Override
	public CashInflow createInitForm() {
		return new CashInflow();
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "table-data.do", method = RequestMethod.GET)
	public TableData<CashInflow> getData() {
		return new TableData<CashInflow>(cinServ.listAll());
	}

	@ModelAttribute("activityList")
	public List<FlowActivity> getFlowAcitivities() {
		return faServ.listAll();
	}
	
	@Override
	public TableConfig getTableConfig(){
		TableConfig retVal = new TableConfig();
		List<Field> fields = new ArrayList<>();

		fields.add(new Field("id", "ID"));
		fields.add(new Field("activityIdFk", "Activity ID"));
		fields.add(new Field("amount", "Amount"));
		fields.add(new Field("date", "Date"));
		fields.add(new Field("notes", "Nota"));
		
		retVal.setFields(fields);
		
		return retVal;
	}
}
