package com.cgi.crm.dto;

/**
 * 
 * @author skurapati
 *
 */
public class LeadDto extends CommonDto {

	private String salutation;
	private String firstName;
	private String lastName;
	private String phone;
	private String mobile;
	private String fax;
	private String email;
	private String owner;
	private String company;
	private String title;
	private String website;
	private String leadsource;
	private String leadstatus;
	private String rating;
	private String industry;
	private Integer noOfEmp;
	private String annual_revenue;
	private Boolean deleteFlag;
	private String street;
	private String city;
	private String state;
	private String postal;
	private String country;
	// Additional Info
	private String productInterest;
	private String currentGenerators;
	private String sicCode;
	private String primary;
	private Integer noOfLocations;
	// Description
	private String description;
	// Optional
	// private isassign_by_asgnment_rule(Boolean)
	private Boolean isConverted;
	private Boolean isLeadUnread;

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLeadsource() {
		return leadsource;
	}

	public void setLeadsource(String leadsource) {
		this.leadsource = leadsource;
	}

	public String getLeadstatus() {
		return leadstatus;
	}

	public void setLeadstatus(String leadstatus) {
		this.leadstatus = leadstatus;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getNoOfEmp() {
		return noOfEmp;
	}

	public void setNoOfEmp(Integer noOfEmp) {
		this.noOfEmp = noOfEmp;
	}

	public String getAnnual_revenue() {
		return annual_revenue;
	}

	public void setAnnual_revenue(String annual_revenue) {
		this.annual_revenue = annual_revenue;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProductInterest() {
		return productInterest;
	}

	public void setProductInterest(String productInterest) {
		this.productInterest = productInterest;
	}

	public String getCurrentGenerators() {
		return currentGenerators;
	}

	public void setCurrentGenerators(String currentGenerators) {
		this.currentGenerators = currentGenerators;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}


	public Integer getNoOfLocations() {
		return noOfLocations;
	}

	public void setNoOfLocations(Integer noOfLocations) {
		this.noOfLocations = noOfLocations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsConverted() {
		return isConverted;
	}

	public void setIsConverted(Boolean isConverted) {
		this.isConverted = isConverted;
	}

	public Boolean getIsLeadUnread() {
		return isLeadUnread;
	}

	public void setIsLeadUnread(Boolean isLeadUnread) {
		this.isLeadUnread = isLeadUnread;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

}
