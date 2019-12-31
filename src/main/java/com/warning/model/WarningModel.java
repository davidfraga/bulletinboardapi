package com.warning.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Table(name="warning")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WarningModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer warning_id;
 
	@Column(name="title")
	private String title;
	
	@Column(name="description_text")
	private String description_text;
	
	@Column(name="date_published",nullable = false, updatable = false)
	@CreationTimestamp
	private Date date_published;

	@Column(name="date_viewed",nullable = true)
	private Date date_viewed;
	
	
	public WarningModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public WarningModel(String title, String description) {
		super();
		this.title = title;
		this.description_text = description;
		this.date_published = new Date();
	}
	
	public WarningModel(Integer warning_id, String title, String description, Date date_published, Date date_viewed) {
		super();
		this.warning_id = warning_id;
		this.title = title;
		this.description_text = description;
		this.date_published = date_published;
		this.date_viewed = date_viewed;
	}


	public Integer getWarning_id() {
		return warning_id;
	}


	public void setWarning_id(Integer warning_id) {
		this.warning_id = warning_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description_text;
	}


	public void setDescription(String description) {
		this.description_text = description;
	}


	public Date getDate_published() {
		return date_published;
	}


	public void setDate_published(Date date_published) {
		this.date_published = date_published;
	}


	public Date getDate_viewed() {
		return date_viewed;
	}


	public void setDate_viewed(Date date_viewed) {
		this.date_viewed = date_viewed;
	}
	
	
}