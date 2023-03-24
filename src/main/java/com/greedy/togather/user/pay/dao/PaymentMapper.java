package com.greedy.togather.user.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.user.pay.dto.PayOrderDTO;
import com.greedy.togather.user.pay.dto.PaymentDTO;

@Mapper
public interface PaymentMapper {

	

	int registOrder(PayOrderDTO order);

	int registDelivery(PayOrderDTO order);

	int registPayment(PayOrderDTO order);

	int updatefundingAchive(PayOrderDTO order);

	String selectPayment(PaymentDTO payment);

}
