package com.hiringapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.hiringapp.dto.CompanyFieldDTO;
import com.hiringapp.dto.MessageDTO;
import com.hiringapp.model.CompanyFildes;
import com.hiringapp.service.CompanyService;

@RestController
public class CompanyController {		
	
	@Autowired
	CompanyService companyService;
	/**
	 * registration feature
	 * @param company
	 * @return
	 */
	@PostMapping("company/registration")
	public ResponseEntity<?> registration(@RequestBody CompanyFieldDTO company) {
		//messageDTO class
		MessageDTO message = new MessageDTO();
		CompanyFildes result = null;
		try {
			//service
			result = companyService.registration(company);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			//error message
			message.setMessage("please change email or passowrd");
			return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	/**
	 * login feature
	 * @param company
	 * @return
	 */
	@PostMapping("Company/login")
	public ResponseEntity<?> login(@RequestBody CompanyFieldDTO company) {
		//messageDTO class
		MessageDTO message = new MessageDTO();
		
		String result = null;
		try {
			result = companyService.login(company);
			message.setMessage(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		}catch(Exception e) {
			result = e.getMessage();
			message.setMessage(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	/**
	 * this method used for changing password (forgot password)
	 * @param company
	 * @return
	 */
	@PostMapping("Company/forgot")
	public ResponseEntity<?> forgot(@RequestBody CompanyFieldDTO company) {
		//messageDTO class
		MessageDTO message = new MessageDTO();
		String result = null;
		try {
			//service
			result = companyService.forgotPassword(company);
		}catch(Exception e) {
			e.printStackTrace();
		}
		message.setMessage(result);
		return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
	}
	
}
