package com.cgi.crm.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.Lead;
import com.cgi.crm.entity.LeadView;
import com.cgi.crm.service.LeadViewService;
import com.cgi.crm.util.TransformEntityToDto;

@Controller
@RequestMapping("/leadView")
public class LeadViewController {
	
	@Autowired
	LeadViewService leadViewService;

	@RequestMapping(value="/saveOrUpdateLeadView", method=RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateLeadView(HttpServletRequest request,
			@RequestBody LeadViewDto leadViewDto){
		// if (Utils.getLoginUserId(request) != null) {
		try {
			leadViewService.saveOrUpdateLeadView(leadViewDto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
		// } else {
				// log.error("User must login");
				// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				// }
	}
	
	
	@RequestMapping(value="/getLeadViewById/{viewId}", method=RequestMethod.POST)
	public ResponseEntity<?> getLeadViewById(HttpServletRequest request,
			@PathVariable("viewId") Integer id){
		// if (Utils.getLoginUserId(request) != null) {
		LeadView leadView = null;
		LeadViewDto dto = new LeadViewDto();
				
		try {
			if(id != null){
				leadView = leadViewService.getLeadViewById(id);
				TransformEntityToDto.leadViewToLeadViewDto(leadView, dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<LeadViewDto>(dto, HttpStatus.OK);
		// } else {
				// log.error("User must login");
				// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				// }
	}
	
	@RequestMapping(value="/getAllLeadViewFields", method=RequestMethod.GET)
	public ResponseEntity<?> getAllLeadViewFields(HttpServletRequest request){
		// if (Utils.getLoginUserId(request) != null) {
		Map<String, String> fieldsMap = new HashMap<String, String>();
		try {
			Field[] fields = Lead.class.getDeclaredFields();
			String fieldK="",fieldValue = "";
			for(Field field : fields){
				if(!field.getType().equals(Boolean.class)){
					fieldK = field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
					fieldValue = fieldK.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
				}
				fieldsMap.put(field.getName(), fieldValue);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Map<String, String>>(fieldsMap, HttpStatus.OK);
		// } else {
				// log.error("User must login");
				// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				// }
	}
	
}
