package com.hiringJobPortal.hiringJobportalapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hiringJobPortal.hiringJobportalapi.dao.UserRepository;
import com.hiringJobPortal.hiringJobportalapi.model.User;
import com.hiringJobPortal.hiringJobportalapi.model.ViewCollege;
import com.hiringJobPortal.hiringJobportalapi.validator.RegistrationValidation;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RegistrationValidation validation;

	public String inserUserDetails(User user) {
		String ans = null;
		try {
			User m = userRepository.save(user);
			if (!m.equals(null)) {
				ans = "success";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}

	public Object getEmailAndPass(User user) {

		String ans = null;
		try {
			List<User> m = userRepository.findAll();
			if (!m.equals(null)) {
				ans = validation.emailPasswordValidation(m, user);
			} else {
				throw new SQLException("records not found");
			}
		} catch (RuntimeException e) {
			log.info("email id and password verfication is unsuccess");
			ans = "unsuccess";
		} catch (SQLException e) {
			log.warn("records not found");
			ans = e.getMessage();
		}
		return ans;
	}

	public Object deleteUserById(String mailId) {

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

	public Object login(User user) {
		String ans = null;
		try {
			List<User> m = userRepository.findAll();
			if (!m.equals(null)) {
				ans = validation.loginValidation(m, user);
			} else {
				throw new SQLException("records not found");
			}
		} catch (RuntimeException e) {
			log.info("email id and password verfication is unsuccess");
			ans = "unsuccess";
		} catch (SQLException e) {
			log.warn("records not found");
			ans = e.getMessage();
		}
		return ans;
	}

}
