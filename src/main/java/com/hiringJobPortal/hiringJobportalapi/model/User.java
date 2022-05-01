package com.hiringJobPortal.hiringJobportalapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "job_hiring")
public class User {

	@Id
	@Column(name = "user_mail_id")
	private String userMailId = null;

	@Column(name = "user_pass")
	private String userPass = null;

	@Column(name = "user_name")
	private String userName = null;
	
	@Column(name = "date_of_birdth")
	private String dateOfBirdth = null;
	
	@Column(name = "college_name")
	private String collegeName = null;
	
	private String course = null;
	
	private String branch = null;

	private String gender = null;

	@Column(name = "phone_number")
	private long phoneNumber = 0;
}
