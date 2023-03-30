package com.greedy.togather.admin.settle.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class AdminProjectDTO {
	
	private String projNo;
	private String categoryNo;
	private String userNo;
	private String projNm;
	private String projSummary;
	private String projDetail;
	private String projInfoTitle;
	private String projInfoBody;
	private Date fundingStartDate;
	private Date fundingEndDate;
	private int fundingGoal;
	private int fundingAchive;
	private Date projRegDate;
	private Date projRejectDate;
	private Date projConfirmDate;
	private Date projStopDate;
	private String projStatus;
	private String projReview;
	
	private AdminMakerDTO maker;
	private List<AdminUserDTO> userList;
	private List<AdminFundingDTO> fundingList;
}
