package com.cgi.crm.service.impl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.crm.dao.LeadViewDao;
import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.LeadView;
import com.cgi.crm.service.LeadViewService;
import com.cgi.crm.util.TransformDtoToEntity;


@Service
@Transactional
public class LeadViewServiceImpl implements LeadViewService {
	private Logger LOG = Logger.getLogger(LeadServiceImpl.class);
	@Autowired
	private LeadViewDao leadViewDao;

	public void saveOrUpdateLeadView(LeadViewDto leadViewDto) {
		LeadView leadView = null;
		try {
			if(leadViewDto.getViewName() != null && leadViewDto.getViewUniqueName() != null){
				if(leadViewDto.getId() != null){
					leadView = (LeadView) leadViewDao.getObjectById(leadViewDto.getId(), LeadView.class);
					
				}else{
					leadView = new LeadView();
				}
				TransformDtoToEntity.leadViewDtoToLeadView(leadViewDto, leadView);
				leadViewDao.saveOrUpdate(leadView);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public LeadView getLeadViewById(Integer id) {
		LeadView leadView = null;
		try {
			leadView = (LeadView) leadViewDao.getObjectById(id, LeadView.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return leadView;
	}
	
}
