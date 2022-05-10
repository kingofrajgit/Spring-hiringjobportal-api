package com.hiringapp.converter;

import org.springframework.context.annotation.Configuration;

import com.hiringapp.dto.UserDTO;
import com.hiringapp.model.User;

@Configuration
public class UserConverter {

	/**
	 * convert DTO to model 
	 * @param userDTO
	 * @return
	 */
	public User toModel(UserDTO userDTO) {
		User user = new User();
		user.setUserMailId(userDTO.getUserMailId());
		user.setUserPass(userDTO.getUserPass());
		user.setUserName(userDTO.getUserName());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setCollegeName(userDTO.getCollegeName());
		user.setCourse(userDTO.getCourse());
		user.setBranch(userDTO.getBranch());
		user.setGender(userDTO.getGender());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		return user;
	}
	
	/**
	 * convert model to DTO
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO toDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserMailId(user.getUserMailId());
		userDTO.setUserPass(user.getUserPass());
		userDTO.setUserName(user.getUserName());
		userDTO.setDateOfBirth(user.getDateOfBirth());
		userDTO.setCollegeName(user.getCollegeName());
		userDTO.setCourse(user.getCourse());
		userDTO.setBranch(user.getBranch());
		userDTO.setGender(user.getGender());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		return userDTO;
	}
	


}
