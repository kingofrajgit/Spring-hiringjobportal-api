package com.hiringapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

import com.hiringapp.converter.JobIdFieldConverter;
import com.hiringapp.converter.UserConverter;
import com.hiringapp.dao.ApplicationRepository;
import com.hiringapp.dao.AppliedApplicationRepository;
import com.hiringapp.dao.UserRepository;
import com.hiringapp.dto.UserDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.Application;
import com.hiringapp.model.AppliedApplication;
import com.hiringapp.model.User;
import com.hiringapp.validator.UserValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ApplicationRepository application;
	
	@Autowired
	AppliedApplicationRepository appliedJob;

	@Autowired
	UserValidation validation;
	
	@Autowired
	UserConverter userConverter;
	
	@Autowired
	JobIdFieldConverter dTOConverter;
	
	static final String SUCCESS = "success";
	
	static final String UNSUCCESS = "unsuccess";
	
	/**
	 * this method used for registration purpose
	 * @param user
	 * @return
	 */
	public String insertUserDetails(UserDTO userDTO) {
		String ans = null;
		try {
			// validation
			validation.userFieldValidation(userDTO);
			//convert DTO into model
			User user = userConverter.toModel(userDTO);
			//repository
			User m = userRepository.save(user);
			if (m != null) {
				ans = SUCCESS;
			} else {
				throw new ValidatorException(UNSUCCESS);
			}
		} catch (Exception e) {
			ans = e.getMessage();
		}

		return ans;
	}
	
	/**
	 * this feature used for get email and  password that can be used to verify registration 
	 * @param user
	 * @return
	 * @throws ValidatorException 
	 */
	public String getEmailAndPass(UserDTO user) throws ValidatorException {

		String ans = null;
		try {
			List<User> m = userRepository.findAll();
			if (m != null) {
				ans = validation.emailPasswordValidation(m, user);
			} else {
				
				throw new ValidatorException("records not found");
			}
		} catch (ValidatorException e) {
			log.info(e.getMessage());
			throw new ValidatorException(e.getMessage());
		}
		return ans;
	}

	public String deleteUserById(String mailId) {

		log.info("user mail id :" + " " + mailId);
		String ans = null;
		try {
			userRepository.deleteById(mailId);
			ans = "your account wolud be removed ";
		} catch (Exception e) {
			log.warn("user mail id :" + " " + mailId + " " + "is user id not removed");
			ans = "sorry your account is not remove";
		}
		return ans;
	}
	
	/**
	 * this method use for login service 
	 * @param userDTO
	 * @return
	 */
	public User login(UserDTO userDTO) {
		
		User user = new User();
		try {
			user = userConverter.toModel(userDTO);
			List<User> m = userRepository.findAll();
			if (m != null) {
				user = validation.loginValidation(m, user);
				
			} else {
				throw new SQLException("records not found");
			}
		} catch (RuntimeException e) {
			log.info("email id and password verfication is unsuccess");
		} catch (SQLException e) {
			log.warn("records not found");
		}
		return user;
	}

	public String forgotPassword(String password, String mailId) throws ValidatorException, SQLException {

		String result = null;
		try {
			int m = userRepository.forgetPassword(password, mailId);
			if (m != 0) {
				result = SUCCESS;

			} else {
				throw new ValidatorException("password Update is unsuccess");  
			}
		} catch (DataAccessException e) {
			result = e.getMessage();
		}
		return result;
	}

	 public   List<Application> getApplicationByUserMailId(String emailId) {
	 List<AppliedApplication> list = appliedJob.findByMailId(emailId);
	 List<Integer> n = dTOConverter.toDTO(list);
	 List<Application> applicationList = new ArrayList<>();
	 for(int job : n ) {
	 Application applications = application.findAllByJobId(job);
	 applicationList.add(applications);
	 }
	 return applicationList;
	 }

}
