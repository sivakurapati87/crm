package com.cgi.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.crm.dao.LeadDao;
import com.cgi.crm.dto.LeadDto;
import com.cgi.crm.dto.ViewJson;
import com.cgi.crm.entity.Lead;
import com.cgi.crm.service.LeadService;
import com.cgi.crm.util.Constants;
import com.cgi.crm.util.TransformDtoToEntity;
import com.cgi.crm.util.Utils;

@Service
@Transactional
public class LeadServiceImpl implements LeadService {
	private Logger LOG = Logger.getLogger(LeadServiceImpl.class);
	@Autowired
	private LeadDao leadDao;
	/*@Autowired
	private ModelMapper modelMapper;*/

	public void saveOrUpdateLead(LeadDto leadDto) {
		try {
			Lead lead = null;
			if (leadDto.getId() != null) {
				lead = (Lead) leadDao.getObjectById(leadDto.getId(), Lead.class);
			} else {
				lead = new Lead();
			}
			TransformDtoToEntity.leadDtoToLead(leadDto, lead);
			leadDao.saveOrUpdate(lead);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}

	}

	public Lead getLeadById(Integer id) {
		Lead lead = null;
		try {
			
			if (id != null) {
				lead = (Lead) leadDao.getObjectById(id, Lead.class);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lead;
	}

	public LeadDto deleteLeadById(Integer id) {
		try {
			Lead lead = null;
			if (id != null) {
				lead = (Lead) leadDao.getObjectById(id, Lead.class);
				lead.setDeleteFlag(Boolean.TRUE);
				lead.setUpdatedOn(new Date());
				leadDao.saveOrUpdate(lead);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	public Map<String,Object> getLeads() {
		List<LeadDto> leadDtoList = null;
		Map<String,Object> leadDataWithFieldsMap =null;
		try {
			StringBuilder hqlQuery = new StringBuilder("select l.id,l.firstName,l.lastName,l.company,l.email,l.description,l.title,l.phone from Lead l order by COALESCE(l.updatedOn,l.createdOn) DESC NULLS LAST");
			List<?> list = leadDao.getListByQuery(hqlQuery.toString(), null, null, null);
			if (list != null && list.size() > 0) {
				leadDtoList = new ArrayList<LeadDto>();
				
				leadDataWithFieldsMap= new HashMap<String, Object>();
				for(Object obj:list){
					LeadDto dto = new LeadDto();
					Object[] object = (Object[]) obj;
					dto.setId(Utils.getIntegerValueOfBigDecimalObj(object[0]));
					dto.setFirstName(Utils.getStringValueOfObj(object[1]));
					dto.setLastName(Utils.getStringValueOfObj(object[2]));
					dto.setCompany(Utils.getStringValueOfObj(object[3]));
					dto.setEmail(Utils.getStringValueOfObj(object[4]));
					if(object[5]!=null)
					dto.setDescription(new String((byte[])object[5],Constants.Common.UTF_8));
					dto.setTitle(Utils.getStringValueOfObj(object[6]));
					dto.setPhone(Utils.getStringValueOfObj(object[7]));
					leadDtoList.add(dto);
				}
				
				List<ViewJson> viewJsonList = new ArrayList<ViewJson>();
				makeJson(viewJsonList);
				leadDataWithFieldsMap.put("data", leadDtoList);
				leadDataWithFieldsMap.put("fields", viewJsonList);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return leadDataWithFieldsMap;
	}
	private void makeJson(List<ViewJson> viewJsonList) {
		ViewJson json1=new ViewJson();
		json1.setField("firstName");
		json1.setTitle("first Name");
		json1.setAlign("Left");
		json1.setSortable(Boolean.TRUE);
		viewJsonList.add(json1);
		
		ViewJson json2=new ViewJson();
		json2.setField("lastName");
		json2.setTitle("Last Name");
		json2.setAlign("Left");
		json2.setSortable(Boolean.TRUE);
		viewJsonList.add(json2);
		
		ViewJson json3=new ViewJson();
		json3.setField("company");
		json3.setTitle("Company");
		json3.setAlign("Left");
		json3.setSortable(Boolean.TRUE);
		viewJsonList.add(json3);
		
		ViewJson json5=new ViewJson();
		json5.setField("title");
		json5.setTitle("Title");
		json5.setAlign("Left");
		json5.setSortable(Boolean.TRUE);
		viewJsonList.add(json5);
		
		ViewJson json6=new ViewJson();
		json6.setField("phone");
		json6.setTitle("Phone Number");
		json6.setAlign("Left");
		json6.setSortable(Boolean.TRUE);
		viewJsonList.add(json6);
		
		ViewJson json4=new ViewJson();
		json4.setField("email");
		json4.setTitle("Email");
		json4.setAlign("Left");
		json4.setSortable(Boolean.TRUE);
		viewJsonList.add(json4);
		
		
		
		
}

}
