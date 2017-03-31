package com.cgi.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 
 * @author skurapati
 *
 */
@Entity
@Table(name = "lead_view")
public class LeadView extends CommonInfo {

	private String viewName;
	@Column(unique = true)
	private String viewUniqueName;
	private String filterOn;
	private String visibleTo;
	@Lob
	private byte[] query;

	public byte[] getQuery() {
		return query;
	}

	public void setQuery(byte[] query) {
		this.query = query;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewUniqueName() {
		return viewUniqueName;
	}

	public void setViewUniqueName(String viewUniqueName) {
		this.viewUniqueName = viewUniqueName;
	}

	public String getVisibleTo() {
		return visibleTo;
	}

	public void setVisibleTo(String visibleTo) {
		this.visibleTo = visibleTo;
	}

	public String getFilterOn() {
		return filterOn;
	}

	public void setFilterOn(String filterOn) {
		this.filterOn = filterOn;
	}

}
