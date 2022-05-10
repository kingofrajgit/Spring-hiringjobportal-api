package com.hiringapp.converter;

import org.springframework.context.annotation.Configuration;

import com.hiringapp.dto.CompanyFieldDTO;
import com.hiringapp.model.CompanyFildes;

@Configuration
public class CompanyConverter {
	
	public CompanyFildes toModel(CompanyFieldDTO companyDTO) {
		
		CompanyFildes companyField = new CompanyFildes();
		companyField.setMailId(companyDTO.getMailId());
		companyField.setPassword(companyDTO.getPassword());
		return companyField;
		
	}
}
