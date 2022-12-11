package com.hiringapp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hiringapp.dao.CollegeRepository;
import com.hiringapp.dao.CourseRepository;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.Courses;
import com.hiringapp.model.ViewCollege;

@Configuration
public class RegisterRequirementService {

	@Autowired
	CollegeRepository college;

	@Autowired
	CourseRepository course;

	public List<ViewCollege> getAll() throws ValidatorException {
		try {
			return college.findAll();
		}catch(DataAccessException e) {
			throw new ValidatorException("no list found");
		}

	}

	public String insertCollege(ViewCollege details) throws ValidatorException {

		String ans = null;
		try {
			ViewCollege m = college.save(details);
			if (m != null) {
				ans = "success";
			} else {
				throw new ValidatorException("unsuccess");
			}
		} catch (Exception e) {
			throw new ValidatorException("unsuccess");
		}

		return ans;
	}

	public String courseInsert(Courses courseDetails) throws ValidatorException {

		String ans = null;
		try {
			Courses m = course.save(courseDetails);
			if (m != null) {
				ans = "success";
			} else {
				throw new ValidatorException("unsuccess");
			}
		} catch (Exception e) {
			throw new ValidatorException("unsuccess");
		}

		return ans;
	}

	public List<Courses> getAllCourse() throws ValidatorException {
		try {
			return course.findAll();
		}catch(DataAccessException e) {
			throw new ValidatorException("no list found");
		}

	}

	public String deletecollege(int id) {

		String ans = null;
		try {
			college.deleteById(id);
			ans = "success";
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}

	public String deleteCourse(int id) {
		String ans = null;
		try {
			course.deleteById(id);
			ans = "success";
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}
}
