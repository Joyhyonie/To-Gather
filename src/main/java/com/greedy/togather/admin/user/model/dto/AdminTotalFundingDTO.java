package com.greedy.togather.admin.user.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class AdminTotalFundingDTO {

	private String userNo;
	private int payCount;
	private int totalPay;
	private int totalRefund;
	private int totalFunding;
	
	private List<AdminFundingDTO> FundingList; 
}
