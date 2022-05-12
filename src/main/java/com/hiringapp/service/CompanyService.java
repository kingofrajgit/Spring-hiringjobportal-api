package com.hiringapp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

import com.hiringapp.converter.CompanyConverter;
import com.hiringapp.dao.CompanyRepository;
import com.hiringapp.dto.CompanyFieldDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.CompanyFildes;
import com.hiringapp.validator.CompanyValidator;

@Configuration
public class CompanyService {

	@Autowired
	CompanyConverter converter;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CompanyValidator validator;

	/**
	 * registration
	 * 
	 * @param company
	 * @return
	 * @throws ValidatorException
	 */
	public CompanyFildes registration(CompanyFieldDTO companyDTO) throws ValidatorException {

		String result = null;
		String mail = companyDTO.getMailId();
		try {
			CompanyFildes n = companyRepository.findByMailId(mail);
			if (n == null) {
				// validate
				validator.companyRegistrationValidator(companyDTO);
				// converter
				CompanyFildes model = converter.toModel(companyDTO);
				// repository
				model = companyRepository.save(model);
				System.out.println(model);
				// validate
				validator.insertVerification(model);
				return model;
			} else {
				throw new ValidatorException("please change email or passowrd");
			}
		} catch (DataAccessException e) {
			// exception result
			result = e.getMessage();
			
			throw new ValidatorException(result);
		}

	}

	public String login(CompanyFieldDTO companyDTO) {
		String result = null;
		try {
			// validate
			validator.companyRegistrationValidator(companyDTO);
			String mail = companyDTO.getMailId();
			
			CompanyFildes companys = companyRepository.findByMailId(mail);
			System.out.println(companys);
			validator.validatePassword(companyDTO, companys);
			result = "success";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	public String forgotPassword(CompanyFieldDTO company) throws ValidatorException, SQLException {
		String result = null;
		try {
			// validate
			validator.companyRegistrationValidator(company);
			int n = companyRepository.forgetPassword(company.getPassword(), company.getMailId());
			if (n != 0) {
				result = "your password update is successfull";
			} else {
				throw new ValidatorException("your password update is successfull");
			}
		} catch (DataAccessException e) {
			result = e.getMessage();
		}
		return result;
	}
}
