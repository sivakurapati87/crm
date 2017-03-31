package com.cgi.crm.util;

import com.cgi.crm.dto.LeadDto;
import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.Lead;
import com.cgi.crm.entity.LeadView;

public class TransformEntityToDto {
	public static void leadToLeadDto(LeadDto leadDto, Lead lead) {
		leadDto.setId(lead.getId());
		leadDto.setAnnual_revenue(lead.getAnnual_revenue());
		leadDto.setCity(lead.getCity());
		leadDto.setCompany(lead.getCompany());
		leadDto.setCountry(lead.getCountry());
		leadDto.setCurrentGenerators(lead.getCurrentGenerators());
		leadDto.setDeleteFlag(lead.getDeleteFlag());
		if (lead.getDescription() != null) {
			leadDto.setDescription(new String(lead.getDescription()));
		}
		leadDto.setEmail(lead.getEmail());
		leadDto.setFax(lead.getFax());
		leadDto.setFirstName(lead.getFirstName());
		leadDto.setIndustry(lead.getIndustry());
		leadDto.setIsConverted(lead.getIsConverted());
		leadDto.setIsLeadUnread(lead.getIsLeadUnread());
		leadDto.setPrimary(lead.getPrimary());
		leadDto.setLastName(lead.getLastName());
		leadDto.setLeadsource(lead.getLeadsource());
		leadDto.setLeadstatus(lead.getLeadstatus());
		leadDto.setMobile(lead.getMobile());
		leadDto.setNoOfEmp(lead.getNoOfEmp());
		leadDto.setNoOfLocations(lead.getNoOfLocations());
		leadDto.setOwner(lead.getOwner());
		leadDto.setPhone(lead.getPhone());
		leadDto.setPostal(lead.getPostal());
		leadDto.setProductInterest(lead.getProductInterest());
		leadDto.setRating(lead.getRating());
		leadDto.setSalutation(lead.getSalutation());
		leadDto.setSicCode(lead.getSicCode());
		leadDto.setState(lead.getState());
		leadDto.setStreet(lead.getStreet());
		leadDto.setTitle(lead.getTitle());
		leadDto.setWebsite(lead.getWebsite());
		if (lead.getId() != null) {
			leadDto.setUpdatedBy(lead.getUpdatedBy());
			leadDto.setStrUpdatedOn(Utils.convertDateToString(lead.getUpdatedOn()));
		} else {
			leadDto.setCreatedBy(lead.getCreatedBy());
			leadDto.setStrCreatedOn(Utils.convertDateToString(lead.getCreatedOn()));
		}

	}

	public static void leadViewToLeadViewDto(LeadView leadView, LeadViewDto dto) {
		// TODO Auto-generated method stub
		dto.setId(leadView.getId());
		dto.setViewName(leadView.getViewName());
		dto.setViewUniqueName(leadView.getViewUniqueName());
		dto.setFilterOn(leadView.getFilterOn());
		dto.setVisibleTo(leadView.getVisibleTo());
		dto.setCreatedBy(leadView.getCreatedBy());
		dto.setStrCreatedOn(Utils.convertDateToString(leadView.getCreatedOn()));
		dto.setUpdatedBy(leadView.getUpdatedBy());
		dto.setStrUpdatedOn(Utils.convertDateToString(leadView.getUpdatedOn()));
	}
}
