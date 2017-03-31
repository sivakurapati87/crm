package com.cgi.crm.service;

import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.LeadView;

public interface LeadViewService {

 public	void saveOrUpdateLeadView(LeadViewDto leadViewDto);

	public	LeadView getLeadViewById(Integer id);
	
	

}
