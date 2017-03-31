package com.cgi.crm.service;

import java.util.Map;

import com.cgi.crm.dto.LeadDto;
import com.cgi.crm.entity.Lead;

public interface LeadService {
	public void saveOrUpdateLead(LeadDto leadDto);
	public Map<String,Object> getLeads();
	public Lead getLeadById(Integer id);
	public LeadDto deleteLeadById(Integer id);
	
}
