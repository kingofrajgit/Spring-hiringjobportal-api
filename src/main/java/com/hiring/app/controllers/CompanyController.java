package com.hiring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.app.dto.CompanyFieldDTO;

import com.hiring.app.service.CompanyService;

@RestController
public class CompanyController {		
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping("company/registration")
	public ResponseEntity<String> registration(@RequestBody CompanyFieldDTO company) {
		String result = null;
		try {
			result = companyService.registration(company);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
