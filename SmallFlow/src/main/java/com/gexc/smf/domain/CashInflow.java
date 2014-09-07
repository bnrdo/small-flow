package com.gexc.smf.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name= "tbl_cash_inflow")
public class CashInflow {
	
	@Id
	@GeneratedValue
	@Column(name = "cin_id")
	private Integer id;
	
	@Column(name = "cin_activity_id")
	private Integer activityIdFk;
    
	@NotNull
	@Column(name = "cin_date")
	private Date date;
	
	@NotNull
	@Column(name = "cin_amount")
	private BigDecimal amount;
	
	@Column(name = "cin_notes")
	private String notes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivityIdFk() {
		return activityIdFk;
	}

	public void setActivityIdFk(Integer activityIdFk) {
		this.activityIdFk = activityIdFk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
