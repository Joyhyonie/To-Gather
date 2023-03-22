package com.greedy.togather.user.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UserDTO {

	private String userNo;
	private String email;
	private String pwd;
	private String userName;
	private String profileName;
	private String phone;
	private String address;
	private Date joinDate;
	private Date quitDate;
	private char quitYn;
	private String userToken;
	
}
