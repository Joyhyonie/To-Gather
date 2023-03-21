package com.greedy.togather.user.pay.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PaymentDTO {
	
	private String payNo;
	private String orderNo;
	private String payMethod;
	private int payPrice;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date payDate;
	
}
