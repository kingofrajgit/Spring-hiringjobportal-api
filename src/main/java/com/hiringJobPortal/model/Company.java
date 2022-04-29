package com.hiringJobPortal.model;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hiring_companys")
public class Company {

	String branch;	
	String companyName;	
	String roll	;
	String vacancy;	
	String location;
	String last_date ; 
}
