package com.hiring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hiring.app.dao.CollegeRepository;
import com.hiring.app.dao.CourseRepository;
import com.hiring.app.exception.ValidatorException;
import com.hiring.app.model.Courses;
import com.hiring.app.model.ViewCollege;

@Configuration
public class RegisterRequirementService {

	@Autowired
	CollegeRepository college;

	@Autowired
	CourseRepository course;

	public List<ViewCollege> getAll() {
		return college.findAll();

	}

	public String insertCollege(ViewCollege details) {

		String ans = null;
		try {
			ViewCollege m = college.save(details);
			if (m != null) {
				ans = "success";
			} else {
				throw new ValidatorException("unsuccess");
			}
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}

	public String courseInsert(Courses courseDetails) {

		String ans = null;
		try {
			Courses m = course.save(courseDetails);
			if (m != null) {
				ans = "success";
			} else {
				throw new ValidatorException("unsuccess");
			}
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}

	public List<Courses> getAllCourse() {
		return course.findAll();
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
