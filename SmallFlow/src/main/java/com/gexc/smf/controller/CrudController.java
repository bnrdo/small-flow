package com.gexc.smf.controller;

import static com.gexc.smf.util.Util.capitalizeFirstLetter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gexc.smf.model.Field;
import com.gexc.smf.model.TableConfig;
import com.gexc.smf.model.TableData;
import com.gexc.smf.service.CrudService;


@SessionAttributes({"oper", "path", "isReadOnly", "tableModel", "fields"})
public abstract class CrudController<T> {
	
	@Autowired
	private CrudService<T> crudService;
	
	protected String editOrDelete(ModelMap model, T form, String oper)
			throws Exception {
		
		boolean isReadOnly = "edit".equals(oper) ? false : true;
		
		model.put("form", form);
		
		model.put("isReadOnly", isReadOnly);
		model.put("path",  capitalizeFirstLetter(oper));
		model.put("oper", oper);
		
		return "crud/edit";
	}
	
	protected String createNew(ModelMap model) throws Exception {
		
		String oper = "new";
		
		model.put("form", createInitForm());
		
		model.put("isReadOnly", false);
		model.put("path", capitalizeFirstLetter(oper));
		model.put("oper", oper);
		
		return "crud/edit";
	}
	
	protected String save(T form, BindingResult binding, ModelMap model){
		
		if(binding.hasErrors()){
			return "crud/edit";
		}
		
		crudService.save(form);
		
		return "crud/read";
	}
	
	protected String delete(T form, BindingResult binding){
		
		crudService.delete(form);
		
		return "crud/read";
	}
	
	protected String show(ModelMap model){
		List<Field> tableModel = getTableConfig().getFields();
		List<String> names = new ArrayList<>();
		
		for(Field field : tableModel){
			names.add(field.getData());
		}
		
		model.put("fields", names);
		model.put("tableModel", tableModel);
		
		return "crud/read";
	}
	
	protected String back(){
		return "crud/read";
	}
	
	public abstract TableData<T> getData();
	
	public abstract TableConfig getTableConfig();
	
	public abstract T createInitForm();
}
