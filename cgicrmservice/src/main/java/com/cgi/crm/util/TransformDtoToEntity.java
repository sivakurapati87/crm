package com.cgi.crm.util;

import java.util.Date;

import com.cgi.crm.dto.LeadDto;
import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.Lead;
import com.cgi.crm.entity.LeadView;

public class TransformDtoToEntity {

	public static void leadDtoToLead(LeadDto dto, Lead lead) {
		lead.setAnnual_revenue(dto.getAnnual_revenue());
		lead.setCity(dto.getCity());
		lead.setCompany(dto.getCompany());
		lead.setCountry(dto.getCountry());
		lead.setCurrentGenerators(dto.getCurrentGenerators());
		lead.setDeleteFlag(dto.getDeleteFlag());
		if(dto.getDescription()!=null){
		lead.setDescription(dto.getDescription().getBytes());
		}
		lead.setEmail(dto.getEmail());
		lead.setFax(dto.getFax());
		lead.setFirstName(dto.getFirstName());
		lead.setIndustry(dto.getIndustry());
		lead.setIsConverted(dto.getIsConverted());
		lead.setIsLeadUnread(dto.getIsLeadUnread());
		lead.setPrimary(dto.getPrimary());
		lead.setLastName(dto.getLastName());
		lead.setLeadsource(dto.getLeadsource());
		lead.setLeadstatus(dto.getLeadstatus());
		lead.setMobile(dto.getMobile());
		lead.setNoOfEmp(dto.getNoOfEmp());
		lead.setNoOfLocations(dto.getNoOfLocations());
		lead.setOwner(dto.getOwner());
		lead.setPhone(dto.getPhone());
		lead.setPostal(dto.getPostal());
		lead.setProductInterest(dto.getProductInterest());
		lead.setRating(dto.getRating());
		lead.setSalutation(dto.getSalutation());
		lead.setSicCode(dto.getSicCode());
		lead.setState(dto.getState());
		lead.setStreet(dto.getStreet());
		lead.setTitle(dto.getTitle());
		lead.setWebsite(dto.getWebsite());
		if (dto.getId() != null) {
			lead.setUpdatedBy(dto.getUpdatedBy());
			lead.setUpdatedOn(new Date());
		} else {
			lead.setCreatedBy(dto.getCreatedBy());
			lead.setCreatedOn(new Date());
		}

	}

	public static void leadViewDtoToLeadView(LeadViewDto dto,
			LeadView leadView) {
		leadView.setViewName(dto.getViewName());
		leadView.setViewUniqueName(dto.getViewUniqueName());
		leadView.setVisibleTo(dto.getVisibleTo());
		leadView.setFilterOn(dto.getFilterOn());
		if(leadView.getId()!=null){
			leadView.setUpdatedBy(dto.getUpdatedBy());
			leadView.setUpdatedOn(Utils.convertStringToDate(dto.getStrUpdatedOn()));
		}else{
			leadView.setCreatedBy(dto.getCreatedBy());
			leadView.setCreatedOn(new Date());
		}
	}
}
