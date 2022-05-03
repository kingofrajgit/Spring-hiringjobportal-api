package com.hiring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hiring.app.model.User;
import com.hiring.app.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("user/registration")
	public String inserUserDetails(@RequestBody User user) {
		
		return service.inserUserDetails(user);
		
	}
	
	@PostMapping("user/checkByMailAndpass")
	public Object checkByMailAndPass(@RequestBody User user){
		return service.getEmailAndPass(user);
	}
	
	@PostMapping("user/login")
	public Object login(@RequestBody User user){
		return service.login(user);
	}
	
	@PostMapping("user/deletById")
	public Object deleteUserById(@RequestParam("mailId")String emailId){
		return service.deleteUserById(emailId);
	}
	@PostMapping("user/forgetPassword")
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
