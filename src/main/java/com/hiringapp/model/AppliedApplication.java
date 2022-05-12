package com.hiringapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "job_application")
public class AppliedApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int application_id = 0;
	
	@Column(name = "job_id")
	private int jobid = 0;
	

	@Column(name = "user_mail_Id")
	private String mailId = null;
	
	
}
