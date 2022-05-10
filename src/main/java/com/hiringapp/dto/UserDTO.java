package com.hiringapp.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserDTO {
	
	private String userMailId = null;

	private String userPass = null;

	private String userName = null;
	
	private LocalDate dateOfBirth = null;
	
	private String collegeName = null;
	
	private String course = null;
	
	private String branch = null;

	private String gender = null;

	private long phoneNumber = 0;

}
