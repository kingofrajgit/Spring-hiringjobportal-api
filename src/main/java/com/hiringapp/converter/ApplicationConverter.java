package com.hiringapp.converter;

import org.springframework.context.annotation.Configuration;

import com.hiringapp.dto.ApplicationDTO;
import com.hiringapp.model.Application;

@Configuration
public class ApplicationConverter {
	
	public ApplicationDTO toDTO(Application application) {
		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setJobId(application.getJobId());
		applicationDTO.setBranch(application.getBranch());
		applicationDTO.setCompanyName(application.getCompanyName());
		applicationDTO.setLastDate(application.getLastDate());
		applicationDTO.setLocation(application.getLocation());
		applicationDTO.setMailId(application.getMailId());
		applicationDTO.setRoll(application.getRoll());
		applicationDTO.setSalary(application.getSalary());
		applicationDTO.setSkills(application.getSkills());
		applicationDTO.setVacancy(application.getVacancy());
		return applicationDTO;
	}
	
	public Application toModel(ApplicationDTO applicationDTO) {
		Application application = new Application();
		application.setJobId(applicationDTO.getJobId());
		application.setBranch(applicationDTO.getBranch());
		application.setCompanyName(applicationDTO.getCompanyName());
		application.setLastDate(applicationDTO.getLastDate());
		application.setLocation(applicationDTO.getLocation());
		application.setMailId(applicationDTO.getMailId());
		application.setRoll(applicationDTO.getRoll());
		application.setSalary(applicationDTO.getSalary());
		application.setSkills(applicationDTO.getSkills());
		application.setVacancy(applicationDTO.getVacancy());
		return application;
	}
}
