package com.greedy.togather.user.pay.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderDTO1 {
	
	private String orderNo;
	private String userNO;
	private String projNo;
	private String rewardNo;
	private Date orderDate;
	private int rewardQuantity;
	private int rewardPrice;
	private int extraReward;
	private int deliveryFee;
	private int dcPrice;
	private int payPrice;
}
