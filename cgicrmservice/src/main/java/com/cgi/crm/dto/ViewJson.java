package com.cgi.crm.dto;

/**
 * 
 * @author skurapati
 *
 */
public class ViewJson extends CommonDto {

	private String field;
	private String title;
	private String align;
	private Boolean sortable;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

}
