package com.cgi.crm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.crm.dto.LeadDto;
import com.cgi.crm.dto.LeadViewDto;
import com.cgi.crm.entity.Lead;
import com.cgi.crm.dto.ViewJson;
import com.cgi.crm.service.LeadService;
import com.cgi.crm.util.TransformEntityToDto;

@RestController
@RequestMapping("/LeadController")
public class LeadController {
	private Logger LOG = Logger.getLogger(LeadController.class);
	@Autowired
	private LeadService leadService;

	@RequestMapping(value = "/saveOrUpdateLead", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> saveOrUpdateLead(@RequestBody LeadDto leadDto,
			HttpServletRequest request) {
		// if (Utils.getLoginUserId(request) != null) {
		try {
			if (leadDto != null) {
				leadService.saveOrUpdateLead(leadDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);

		}

		return new ResponseEntity<Object>(HttpStatus.OK);
		// } else {
		// log.error("User must login");
		// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		// }
	}

	@RequestMapping(value = "/getLeads", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getLeads(HttpServletRequest request) {
		// if (Utils.getLoginUserId(request) != null) {
		Map<String,Object> leadDataWithFieldsMap = null;
		try {
			leadDataWithFieldsMap = leadService.getLeads();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);

		}

		return new ResponseEntity<Object>(leadDataWithFieldsMap, HttpStatus.OK);
		// } else {
		// log.error("User must login");
		// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		// }
	}
	
	@RequestMapping(value = "/getLeadById/{leadId}", method = RequestMethod.GET)
	public ResponseEntity<?> getLeadById(HttpServletRequest request,
			@PathVariable("leadId")Integer id ){
		
		// if (Utils.getLoginUserId(request) != null) {
		
		Lead lead = null;
		LeadDto leadDto = new LeadDto();
		try {
			if(id != null){
				lead = leadService.getLeadById(id);
				TransformEntityToDto.leadToLeadDto(leadDto, lead);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<LeadDto>(leadDto, HttpStatus.OK);
		// } else {
				// log.error("User must login");
				// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				// }
	}
	
	@RequestMapping(value = "/deleteLeadById/{leadId}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteLeadById(HttpServletRequest request,
			@PathVariable("leadId")Integer id ){
		
		// if (Utils.getLoginUserId(request) != null) {
		
		LeadDto leadDto = null;
		
		try {
			if(id != null){
				leadDto = leadService.deleteLeadById(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<LeadDto>(leadDto, HttpStatus.OK);
		// } else {
				// log.error("User must login");
				// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				// }
	}
	
	@RequestMapping(value = "/cloneLead/{leadId}", method = RequestMethod.GET)
	public ResponseEntity<?> cloneLead(HttpServletRequest request, @PathVariable("leadId") Integer id){
		
		// if (Utils.getLoginUserId(request) != null) {
		
		try {
			Lead lead = null;
			LeadDto leadDto = new LeadDto();
			if(id != null){
				
				lead = leadService.getLeadById(id);
				lead.setId(null);
				TransformEntityToDto.leadToLeadDto(leadDto, lead);
				leadService.saveOrUpdateLead(leadDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
		// } else {
		// log.error("User must login");
		// return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		// }
	}
	
	
	
}
