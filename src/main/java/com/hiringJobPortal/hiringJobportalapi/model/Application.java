package com.hiringJobPortal.hiringJobportalapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hiring_companys")
public class Application {
	@Id
	@NotNull
	@Column(name = "job_id")
	int jobId;
	
	String branch;
	
	@Column(name = "company_name")
	String companyName;
	
	String roll;
	
	int vacancy;
	
	@Column(name = "location_details")
	String location;

	@Column(name = "finish_date")
	LocalDate lastDate;
	
	String skills;
	
	int salary ;
	
	@Column(name="mail_id")
	String mailId;
}
