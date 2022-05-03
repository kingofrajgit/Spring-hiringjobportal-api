package com.hiring.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hiring.app.dao.ApplicationRepository;
import com.hiring.app.dao.UserRepository;
import com.hiring.app.exception.MyOwnRuntimeException;
import com.hiring.app.model.User;
import com.hiring.app.validator.RegistrationValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ApplicationRepository application;

	@Autowired
	RegistrationValidation validation;

	public String inserUserDetails(User user) {
		String ans = null;
		try {
			User m = userRepository.save(user);
			if (m != null) {
				ans = "success";
			} else {
				throw new MyOwnRuntimeException("unsuccess");
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
			if (m != null) {
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
			if (m != null) {
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

	public Object forgetPassword(String password, String mailId) {

		String result = null;
		try {
			int m = userRepository.forgetPassword(password, mailId);
			if (m != 0) {
				result = "successfull";

			} else {
				result = "unsuccessfull";
			}
		} catch (SQLException e) {
			result = "unsuccessfull";
		}
		return result;
	}

	// public List<Application> getApplicationByUserMailId(String emailId) {
	// return application.findApplicationByEmail(emailId);
	// }

}
