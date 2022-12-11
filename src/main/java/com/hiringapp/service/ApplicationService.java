package com.hiringapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

import com.hiringapp.converter.ApplicationConverter;
import com.hiringapp.dao.ApplicationRepository;
import com.hiringapp.dto.ApplicationDTO;
import com.hiringapp.model.Application;

@Configuration
public class ApplicationService {
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	ApplicationConverter converter;
	
	/**
	 * get all details and compared to final time to applying time
	 * @return
	 */
	public List<Application> findAll() {
	
	return applicationRepository.findAll();
	}

	public List<Application> findByLastDate() {
		LocalDate localDate = LocalDate.now();
		return applicationRepository.findByLastDate(localDate );
	}

	public Application save(ApplicationDTO applicationDTO) {
		Application application = converter.toModel(applicationDTO);
		try {
			 application = applicationRepository.save(application);
		}catch(DataAccessException e){
			e.getMessage();
		}
		return application;
 
	}
}
