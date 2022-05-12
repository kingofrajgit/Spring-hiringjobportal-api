package com.hiringapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiringapp.dto.MessageDTO;
import com.hiringapp.dto.UserDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.Application;
import com.hiringapp.model.User;
import com.hiringapp.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	/**
	 * this mail id and password check method is used for registration purpose
	 * 
	 * @param user
	 * @return
	 * @return
	 * @throws ValidatorException
	 */
	@PostMapping("user/checkByMailAndpass")
	public ResponseEntity<?> checkByMailAndPass(@RequestBody UserDTO user) throws ValidatorException {
		try {
			String result = service.getEmailAndPass(user);
			MessageDTO message = new MessageDTO(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		} catch (ValidatorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * this method is used for registration purpose
	 * 
	 * @param user
	 * @return
	 * @return
	 */
	@PostMapping("user/registration")
	public ResponseEntity<?> registration(@RequestBody UserDTO user) {
		String result = null;
		try {
			result = service.insertUserDetails(user);
			MessageDTO message = new MessageDTO(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * this method is used for login purpose
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("user/login")
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
		try {
			User result = service.login(userDTO);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * this method is used by delete by user id
	 * 
	 * @param emailId
	 * @return
	 */
	@PostMapping("user/deletById")
	public ResponseEntity<?> deleteUserById(@RequestParam("mailId") String emailId) {
		try {
			String result = service.deleteUserById(emailId);
			MessageDTO message = new MessageDTO(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * this method is used for password changing purpose
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("user/forgetPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody UserDTO user) {
		try {
			String password = user.getUserPass();
			String mailId = user.getUserMailId();
			String result = service.forgotPassword(password, mailId);
			MessageDTO message = new MessageDTO(result);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("user/registration/viweMyApplication")
	public ResponseEntity<?> viweMyApplication(@RequestParam("mailId") String mailId) {

		try {
			List<Application> list = service.getApplicationByUserMailId(mailId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
