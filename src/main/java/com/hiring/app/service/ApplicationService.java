package com.hiring.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hiring.app.dao.ApplicationRepository;
import com.hiring.app.model.Application;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class ApplicationService {
	@Autowired
	ApplicationRepository applicationRepository;
	
	/**
	 * get all details and compared to final time to applying time
	 * @return
	 */
	public List<Application> findAll() {
		
	return applicationRepository.findAll();
	}

	public List<Application> findByLastDate() {
		LocalDate localDate = LocalDate.now();
		List<Application> list = applicationRepository.findByLastDate(localDate );
		
		System.out.println(localDate );
		return list;
	}
}
