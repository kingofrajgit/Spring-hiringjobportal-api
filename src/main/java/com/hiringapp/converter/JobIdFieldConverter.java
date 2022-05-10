package com.hiringapp.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.hiringapp.model.AppliedApplication;

@Configuration
public class JobIdFieldConverter {
	
	public List<Integer> toDTO(List<AppliedApplication> list){
		int jobId = 0;
		List<Integer> jobIdList = new ArrayList<>();
		
		for(AppliedApplication n : list) {
			jobId = n.getJobid();
			jobIdList.add(jobId);
		}
		return jobIdList;
		
	}
}
