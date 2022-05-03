package com.hiring.app.validator;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.hiring.app.model.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class RegistrationValidation {
//u.getUserMailId().equals( user.getUserMailId()) || u.getUserPass().equals(user.getUserPass())
	public String emailPasswordValidation(List<User> m, User user) {
		String ans = null;
		for (User u : m) {
			if(u.getUserMailId().equals( user.getUserMailId())) {
				log.info("this email id is already presnt");
				ans = "invalid credential";
				break;
			}
			else {
				ans = "success";
			}
		}
		return ans;
	}
	
	public String loginValidation(List<User> m, User user) {
		String ans = null;
		for (User u : m) {
			if(u.getUserMailId().equals( user.getUserMailId()) && u.getUserPass().equals(user.getUserPass())) {
				log.info("this email id and password is  presnt");
				ans = "success";
				break;
			}
			else {
				ans = "unsuccess";
			}
		}
		return ans;
	}
}
