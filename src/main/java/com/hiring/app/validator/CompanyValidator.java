package com.hiring.app.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.hiring.app.dto.CompanyFieldDTO;
import com.hiring.app.exception.ValidatorException;
import com.hiring.app.model.CompanyFildes;

@Validated
@Configuration
public class CompanyValidator {
	
	public void companyRegistrationValidator(CompanyFieldDTO company) throws ValidatorException{
		String mailId = company.getMailId();
		String password = company.getPassword();
		String mailIdError = "invalid mail Id";
		//emailId validate
		if (mailId == null || "".equals(mailId.trim())) {
			throw new ValidatorException(mailIdError);
		}
		if (!mailId.contains("@")) {
			throw new ValidatorException(mailIdError);
		}
		String passwordError = "password field cannot is empty";
		//password validate
		if (password == null || "".equals(password.trim())) {
			throw new ValidatorException(passwordError);
		}
	}

	public void insertVerification(CompanyFildes model) throws ValidatorException {
		String passwordError = "sorry sir your account is not valid try again";
		if(model == null) {
			throw new ValidatorException(passwordError);

		}
		
	}

}
