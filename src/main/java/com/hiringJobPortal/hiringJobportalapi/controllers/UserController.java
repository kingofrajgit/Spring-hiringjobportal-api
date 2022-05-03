package com.hiringJobPortal.hiringJobportalapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiringJobPortal.hiringJobportalapi.model.User;
import com.hiringJobPortal.hiringJobportalapi.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("user/registration")
	public String inserUserDetails(@RequestBody User user) {
		
		return service.inserUserDetails(user);
		
	}
	
	@PostMapping("user/registration/checkByMailAndpass")
	public Object checkByMailAndPass(@RequestBody User user){
		return service.getEmailAndPass(user);
	}
	
	@PostMapping("user/registration/login")
	public Object login(@RequestBody User user){
		return service.login(user);
	}
	
	@PostMapping("user/registration/deletById")
	public Object deleteUserById(@RequestParam("mailId")String emailId){
		return service.deleteUserById(emailId);
	}
	@PostMapping("user/registration/forgetPassword")
	public Object forgetPassword(@RequestBody User user){
		String password = user.getUserPass();
		String mailId = user.getUserMailId();
		return service.forgetPassword(password,mailId);
	}
	
//	@GetMapping("user/registration/viweMyApplication")
//	public  List<User> viweMyApplication(@RequestParam("mailId")String mailId){
//		return service.getApplicationByUserMailId(mailId);
//	}
	
}
