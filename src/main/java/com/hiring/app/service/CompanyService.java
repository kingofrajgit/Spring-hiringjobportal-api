package com.hiring.app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.hiring.app.converter.CompanyConverter;
import com.hiring.app.dao.CompanyRepository;
import com.hiring.app.dto.CompanyFieldDTO;
import com.hiring.app.exception.ValidatorException;
import com.hiring.app.model.CompanyFildes;
import com.hiring.app.validator.CompanyValidator;

@Configuration
@Service
public class CompanyService {
	
	@Autowired
	CompanyConverter converter;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyValidator validator;
	
	/**
	 * registration 
	 * @param company
	 * @return
	 * @throws ValidatorException 
	 */
	public String registration(CompanyFieldDTO company) throws ValidatorException {
		
		String result = null;
		try {
			//validate
			validator.companyRegistrationValidator(company);
			//converter
			CompanyFildes model = converter.toModel(company);
			//repository
			 model = companyRepository.save(model);
			//validate
			 validator.insertVerification(model);
			 result = "successfull";
		}catch(DataAccessException e) {
			//exception result
			result =e.getMessage();
		}
		return result;
	}
}
