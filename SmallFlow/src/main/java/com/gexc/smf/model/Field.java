package com.gexc.smf.model;


public class Field{
	
	private String data;
	private String title;
	
	public Field(String data, String title){
		this.data = data;
		this.title = title;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}