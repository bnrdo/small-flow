package com.gexc.smf.model;

import java.util.List;

public class TableData<T> {
	private List<T> data;
	
	public TableData(List<T> data){
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
