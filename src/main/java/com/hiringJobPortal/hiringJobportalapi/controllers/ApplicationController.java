package com.hiringJobPortal.hiringJobportalapi.controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.hiringJobPortal.hiringJobportalapi.dao.ApplicationRepository;
import com.hiringJobPortal.hiringJobportalapi.dao.AppliedApplicationRepository;
import com.hiringJobPortal.hiringJobportalapi.model.Application;
import com.hiringJobPortal.hiringJobportalapi.model.AppliedApplication;
import com.hiringJobPortal.hiringJobportalapi.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AppliedApplicationRepository appliedApplications;
	
	@Autowired
	ApplicationService applicationService;

	@PostMapping("application/insert")
	public Application insertApplication(@RequestBody Application application) {
		return applicationRepository.save(application);
	}

	/**
	 * update By Vacancy,Salary And FinalDate
	 * 
	 * @param id
	 * @param application
	 * @return
	 */
	@GetMapping("application/updateByVancancyAndSalaryAndFinalDate/{id}/{vacancy}/{salary}")
	public String updateByVancancyAndSalaryAndFinalDate(@PathVariable("id") int id,
			@PathVariable("vacancy") int vacancy, @PathVariable("salary") int salary) {
		String result = null;
		try {
			int m = applicationRepository.updateByVancancyAndSalaryAndFinalDate(id, vacancy, salary);
			if (m == 0) {
				throw new Exception("not found update records");
			} else {
				result = m + " " + "records is updated";
			}
		} catch (Exception e) {
			e.getMessage();
			result = e.getMessage();
		}
		return result;

	}

	/**
	 * 
	 * @param id
	 * @param application
	 * @return
	 */
//	@PutMapping("application/updateByVancancyAndSalaryAndFinalDate/{id}")
//	private Application updateByVancancyAndSalaryAndFinalDate(@PathVariable("id")int id,@RequestBody Application application) {
//		Application obj = applicationRepository.updateByVancancyAndSalaryAndFinalDate(id,application);
//		return application;
//		
//	}


	/**
	 * Get all application
	 * 
	 * @return
	 */
	@GetMapping("application/getAllApplication")
	public List<Application> getAllApplication() {
		return applicationRepository.findAll();

	}

	/**
	 * user apply job application
	 * 
	 * @param appliction
	 * @return
	 */
	@PostMapping("application/applyJobApplication")
	public AppliedApplication applyJobApplication(@RequestBody AppliedApplication appliction) {
		return appliedApplications.save(appliction);
	}
	
	/**
	 * get all application Where final date
	 * @return
	 */
	@GetMapping("application/getAllApplicationWhereFinalDate")
	 public List<Application> getAllApplicationWhereFinalDate() {
		return applicationService.findByLastDate();

	}

}
