package com.hiring.app.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.hiring.app.exception.ValidatorException;
import com.hiring.app.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RegistrationValidation {
//u.getUserMailId().equals( user.getUserMailId()) || u.getUserPass().equals(user.getUserPass())
	public String emailPasswordValidation(List<User> m, User user) {
		String ans = null;
		for (User u : m) {
			if (u.getUserMailId().equals(user.getUserMailId())) {
				log.info("this email id is already presnt");
				ans = "invalid credential";
				break;
			} else {
				ans = "success";
			}
		}
		return ans;
	}

	public void loginFieldValidation(User user) throws Exception {
		String userMailId = user.getUserMailId();
		String userPass = user.getUserPass();
		String userName = user.getUserName();
		LocalDate dateOfBirth = user.getDateOfBirth();
		String collegeName = user.getCollegeName();
		String course = user.getCourse();
		String branch = user.getBranch();
		String gender = user.getGender();
		long phoneNumber = user.getPhoneNumber();
		System.out.println(dateOfBirth);
		// try {
		fieldMailIdValidation(userMailId);
		fieldPasswordValidation(userPass);
		fieldDateOfBirthValidate(dateOfBirth);
//		 	}catch() {
//		 		
//		 	}
		if (userName == null || "".equals(userMailId.trim())) {
			throw new ValidatorException("name filed is not empty");
		}
		if (collegeName == null || "".equals(collegeName.trim())) {
			throw new ValidatorException("data filed is not empty");
		}
		if (course == null || "".equals(collegeName.trim())) {
			throw new ValidatorException("college filed is not empty");
		}
		if (branch == null || "".equals(branch.trim())) {
			throw new ValidatorException("branch filed is not empty");
		}
		if (gender == null || "".equals(gender.trim())) {
			throw new ValidatorException("gender filed is not empty");
		}
		if (phoneNumber == 0) {
			throw new ValidatorException("phone number filed is not empty");
		}
	}

	public void fieldDateOfBirthValidate(LocalDate dateOfBirth) throws ValidatorException {
//		if (dateOfBirth == null) {
//			throw new ValidatorException("date of birth filed is mandatory");
//		}
		if (dateOfBirth.isBefore(LocalDate.now())) {
			throw new ValidatorException("feature date is not date of birth");
		}
	}

	public void fieldMailIdValidation(String userMailId) throws ValidatorException {
		String inValid = "invalid mail Id";
		if (userMailId == null || "".equals(userMailId.trim())) {
			throw new ValidatorException(inValid);
		}
		if (!userMailId.contains("@")) {
			throw new ValidatorException(inValid);
		}
	}

	public void fieldPasswordValidation(String userPass) throws ValidatorException {
		String inValid = "password field cannot is empty";
		if (userPass == null || "".equals(userPass.trim())) {
			throw new ValidatorException(inValid);
		}
	}

	public String loginValidation(List<User> m, User user) {
		String ans = null;
		for (User u : m) {
			if (u.getUserMailId().equals(user.getUserMailId()) && u.getUserPass().equals(user.getUserPass())) {
				log.info("this email id and password is  presnt");
				ans = "success";
				break;
			} else {
				ans = "unsuccess";
			}
		}
		return ans;
	}

}
