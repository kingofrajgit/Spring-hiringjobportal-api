package com.hiringapp.validator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

import com.hiringapp.dto.UserDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserValidation {
//u.getUserMailId().equals( user.getUserMailId()) || u.getUserPass().equals(user.getUserPass())
	String success = "success";
	String unsuccess = "unsuccess";
	/**
	 * this method using email password Validation purpose
	 * @param m
	 * @param user
	 * @return
	 */
	public String emailPasswordValidation(List<User> m, UserDTO user) {
		String ans = null;
		for (User u : m) {
			if (u.getUserMailId().equals(user.getUserMailId())) {
				log.info("this email id is already presnt");
				ans = "all ready present";
				break;
			} else {
				ans = success;
			}
		}
		return ans;
	}
	
	/**
	 * this method used for user fields validation purpose
	 * @param userDTO
	 * @throws Exception
	 */
	public void userFieldValidation(UserDTO userDTO) throws ValidatorException {
		String userMailId = userDTO.getUserMailId();
		String userPass = userDTO.getUserPass();
		String userName = userDTO.getUserName();
		LocalDate dateOfBirth = userDTO.getDateOfBirth();
		String collegeName = userDTO.getCollegeName();
		String course = userDTO.getCourse();
		String branch = userDTO.getBranch();
		String gender = userDTO.getGender();
		long phoneNumber = userDTO.getPhoneNumber();
		try {
		fieldMailIdValidate(userMailId);
		fieldPasswordValidation(userPass);
		fieldDateOfBirthValidate(dateOfBirth);
		}catch(DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
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
	
	/***
	 * this method is used to Validate DateOfBirth
	 * @param dateOfBirth
	 * @throws ValidatorException
	 */
	public void fieldDateOfBirthValidate(LocalDate dateOfBirth) throws ValidatorException {
		if (dateOfBirth == null) {
			throw new ValidatorException("date of birth filed is mandatory");
		}
		if (!dateOfBirth.isBefore(LocalDate.now())) {
			System.out.println(dateOfBirth.isBefore(LocalDate.now()));
			throw new ValidatorException("feature date is not date of birth");
		}
	}
	
	/**
	 * this method is used to validate the mail id  
	 * @param userMailId
	 * @throws ValidatorException
	 */
	public void fieldMailIdValidate(String userMailId) throws ValidatorException {
		String inValid = "invalid mail Id";
		if (userMailId == null || "".equals(userMailId.trim())) {
			throw new ValidatorException(inValid);
		}
		if (!userMailId.contains("@")) {
			throw new ValidatorException(inValid);
		}
	}
	
	/**
	 * this method used to validate the password
	 * @param userPass
	 * @throws ValidatorException
	 */
	public void fieldPasswordValidation(String userPass) throws ValidatorException {
		String inValid = "password field cannot is empty";
		if (userPass == null || "".equals(userPass.trim())) {
			throw new ValidatorException(inValid);
		}
	}
	
	/**
	 * this method used for login purpose
	 * @param m
	 * @param user
	 * @return
	 */
	public User loginValidation(List<User> m, User user) {
		User userDetails = new User();
		for (User u : m) {
			if (u.getUserMailId().equals(user.getUserMailId()) && u.getUserPass().equals(user.getUserPass())) {
				log.info("this email id and password is  presnt");
				userDetails = u;
				break;
			} 
		}
		return userDetails;
	}

}
