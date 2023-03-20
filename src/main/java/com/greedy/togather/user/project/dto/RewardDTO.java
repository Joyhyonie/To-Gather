package com.greedy.togather.user.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RewardDTO {
	
	private String rewardNo;		// 리워드 번호
	private String projNo;			// 프로젝트 번호
	private String rewardName;		// 리워드명
	private String rewardContent;	// 리워드 구성
	private int rewardPrice;		// 리워드 가격
	private int rewardFee;			// 리워드 배송비
	private Date rewardDueDate;		// 리워드 배송예정일
	
}
