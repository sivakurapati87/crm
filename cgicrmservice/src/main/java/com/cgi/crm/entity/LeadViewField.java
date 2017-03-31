package com.cgi.crm.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author skurapati
 *
 */
@Entity
@Table(name = "lead_view_field")
public class LeadViewField extends CommonInfo {

	private String fieldName;
	private String fieldTitle;
	private Integer leadViewId;
	private String align;
	private Boolean sortable;
	@ManyToOne
	@JoinColumn(name = "leadViewId", insertable = false, updatable = false)
	private LeadView leadView;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldTitle() {
		return fieldTitle;
	}

	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}

	public Integer getLeadViewId() {
		return leadViewId;
	}

	public void setLeadViewId(Integer leadViewId) {
		this.leadViewId = leadViewId;
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

	public LeadView getLeadView() {
		return leadView;
	}

	public void setLeadView(LeadView leadView) {
		this.leadView = leadView;
	}

}
