package com.cgi.crm.dto;


public class LeadViewDto extends CommonDto{
	
	private String viewName;
	private String viewUniqueName;
	private String filterOn;
	private String visibleTo;
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
