package com.hiring.app.converter;

import org.springframework.context.annotation.Configuration;

import com.hiring.app.dto.CompanyFieldDTO;
import com.hiring.app.model.CompanyFildes;

@Configuration
public class CompanyConverter {
	
	public CompanyFildes toModel(CompanyFieldDTO companyDTO) {
		
		CompanyFildes companyField = new CompanyFildes();
		companyField.setMailId(companyDTO.getMailId());
		companyField.setPassword(companyDTO.getPassword());
		return companyField;
		
	}
}
