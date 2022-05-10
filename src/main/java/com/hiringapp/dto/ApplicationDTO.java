package com.hiringapp.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
	
	int jobId;
	
	String branch;
	
	String companyName;
	
	String roll;
	
	int vacancy;
	
	String location;

	LocalDate lastDate;
	
	String skills;
	
	int salary ;
	
	String mailId;
}
