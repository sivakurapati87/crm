package com.cgi.crm.dto;

public class CommonDto {
	private Integer id;
	private String createdBy;
	private String strCreatedOn;
	private String updatedBy;
	private String strUpdatedOn;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStrCreatedOn() {
		return strCreatedOn;
	}

	public void setStrCreatedOn(String strCreatedOn) {
		this.strCreatedOn = strCreatedOn;
	}

	public String getStrUpdatedOn() {
		return strUpdatedOn;
	}

	public void setStrUpdatedOn(String strUpdatedOn) {
		this.strUpdatedOn = strUpdatedOn;
	}

}
