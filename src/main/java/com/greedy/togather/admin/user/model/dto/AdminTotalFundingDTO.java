package com.greedy.togather.admin.user.model.dto;

import lombok.Data;

@Data
public class AdminTotalFundingDTO {

	private String userNo;
	private int totalPay;
	private int totalRefund;
	private int totalFunding;
}
