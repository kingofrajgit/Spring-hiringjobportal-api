package com.hiringJobPortal.hiringJobportalapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiringJobPortal.hiringJobportalapi.dao.CollegeRepository;
import com.hiringJobPortal.hiringJobportalapi.model.Courses;
import com.hiringJobPortal.hiringJobportalapi.model.ViewCollege;
import com.hiringJobPortal.hiringJobportalapi.service.RegisterRequirementService;

@RestController
public class RegisterRequirementController {

	@Autowired
	CollegeRepository college;

	@Autowired
	RegisterRequirementService requirement;
	
	@PostMapping("Register/Requirement/CollegeInsert")
	public String insertCollege(@RequestBody ViewCollege college) {
		return requirement.insertCollege(college);
	} 
	
	@PostMapping("Register/Requirement/specificationInsert")
	public  String insertCourse(@RequestBody Courses course) {
		 return requirement.courseInsert(course);
	}
	
	@GetMapping("Register/Requirement/findCollege")
	public List<ViewCollege> getAll() {
		return requirement.getAll();
	}
	@GetMapping("Register/Requirement/findCourse")
	public List<Courses> getAllCourse() {
		return requirement.getAllCourse();
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
