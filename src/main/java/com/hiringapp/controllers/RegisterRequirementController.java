package com.hiringapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiringapp.dao.CollegeRepository;
import com.hiringapp.dto.MessageDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.Courses;
import com.hiringapp.model.ViewCollege;
import com.hiringapp.service.RegisterRequirementService;

@RestController
public class RegisterRequirementController {

	@Autowired
	CollegeRepository college;

	@Autowired
	RegisterRequirementService requirement;
	
	/**
	 * this method used for adding college information
	 * @param college
	 * @return
	 */
	@PostMapping("Register/Requirement/CollegeInsert")
	public ResponseEntity<?> insertCollege(@RequestBody ViewCollege college) {
		MessageDTO message = new MessageDTO();
		String string = null;
		try {
			 string =  requirement.insertCollege(college);
			 message.setMessage(string);
		} catch (ValidatorException e) {
			e.printStackTrace();
			message.setMessage(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		message.setMessage(string);
		return new ResponseEntity<>(message,HttpStatus.OK);
	} 
	
	/**
	 * this method used for add courses information
	 * @param course
	 * @return responsEntity 
	 */
	@PostMapping("Register/Requirement/specificationInsert")
	public  ResponseEntity<?> insertCourse(@RequestBody Courses course) {
		MessageDTO message = new MessageDTO();
		 try {
			 String string = requirement.courseInsert(course);
			message.setMessage(string);
			return new ResponseEntity<>(message,HttpStatus.OK);
		} catch (ValidatorException e) {
			e.printStackTrace();
			message.setMessage(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * this method used to get the college list
	 * @return
	 */
	@GetMapping("Register/Requirement/findCollege")
	public ResponseEntity<?> getAll() {
		MessageDTO message = new MessageDTO();
		try {
			return new ResponseEntity<>( requirement.getAll(),HttpStatus.OK);
		} catch (ValidatorException e) {
			e.printStackTrace();
			message.setMessage(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("Register/Requirement/findCourse")
	public ResponseEntity<?> getAllCourse() {
		MessageDTO message = new MessageDTO();
		try {
			return new ResponseEntity<>(requirement.getAllCourse(),HttpStatus.OK);
		} catch (ValidatorException e) {
			e.printStackTrace();
			message.setMessage(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("Register/deleteCollege/{id}")
	public String deleteCollege(@PathVariable("id")int id) {
		return requirement.deletecollege(id);
	}
	
	@GetMapping("Register/deleteCourse/{id}")
	public String deleteCourse(@PathVariable("id")int id) {
		return requirement.deleteCourse(id);
	}
	
	 
	

}
