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

import com.hiringapp.dao.ApplicationRepository;
import com.hiringapp.dao.AppliedApplicationRepository;
import com.hiringapp.dto.ApplicationDTO;
import com.hiringapp.dto.MessageDTO;
import com.hiringapp.exception.ValidatorException;
import com.hiringapp.model.Application;
import com.hiringapp.model.AppliedApplication;
import com.hiringapp.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	AppliedApplicationRepository appliedApplications;
	
	@Autowired
	ApplicationService applicationService;
	
	/**
	 * this method used for registration purpose
	 * @param application
	 * @return 
	 * @return
	 */
	@PostMapping("application/insert")
	public  ResponseEntity<?> insertApplication(@RequestBody ApplicationDTO applicationDTO) {
		MessageDTO message = new MessageDTO();
		try {
			Application application = applicationService.save(applicationDTO);
			return new ResponseEntity<>(application,HttpStatus.OK);
		}catch(Exception e) {
			message.setMessage(e.getMessage());
			return new ResponseEntity<>(message.getMessage(),HttpStatus.BAD_REQUEST);
		}
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
				throw new ValidatorException("not found update records");
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
	 * Get all application
	 * 
	 * @return
	 */
//	@GetMapping("application/getAllApplication")
//	public List<Application> getAllApplication() {
//		MessageDTO message = new MessageDTO)();
//		try {
//		return applicationService.findAll();
//		}catch(Exception e ) {
//			return ResponseEntity<>(message.getMessage());
//		}
//
//	}

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
