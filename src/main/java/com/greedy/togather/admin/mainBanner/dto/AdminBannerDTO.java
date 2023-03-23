package com.greedy.togather.admin.mainBanner.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AdminBannerDTO {
	
	private String mpCode;
	private String projNo;
	private Date mpStartDate;
	private Date mpEndDate;
	private Date mpRegDate;
	private Date mpCategory;
	private String mpStatus;
	

}
