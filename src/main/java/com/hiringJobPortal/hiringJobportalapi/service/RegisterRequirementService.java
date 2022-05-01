package com.hiringJobPortal.hiringJobportalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hiringJobPortal.hiringJobportalapi.dao.CollegeRepository;
import com.hiringJobPortal.hiringJobportalapi.dao.CourseRepository;
import com.hiringJobPortal.hiringJobportalapi.model.Courses;
import com.hiringJobPortal.hiringJobportalapi.model.ViewCollege;

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
			if (!m.equals(null)) {
				ans = "success";
			} else {
				throw new Exception("unsuccess");
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
			if (!m.equals(null)) {
				ans = "success";
			} else {
				throw new Exception("unsuccess");
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