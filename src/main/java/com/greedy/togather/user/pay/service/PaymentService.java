package com.greedy.togather.user.pay.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.togather.user.pay.dao.PaymentMapper;
import com.greedy.togather.user.pay.dto.PayOrderDTO;
import com.greedy.togather.user.pay.dto.PaymentDTO;

@Service
@Transactional
public class PaymentService {
	
	private final PaymentMapper paymentMapper;
	
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	public void registOrder(PayOrderDTO order) /*throws orderRegistException*/{
		int result1 = paymentMapper.registOrder(order);
		
//		if(!(result1 > 0 )) {
//			throw new orderRegistException("결제에 실패하였습니다.");
//		}
	}

	public void registDelivery(PayOrderDTO order) {
		
		int result2 = paymentMapper.registDelivery(order);		
	}

	public void registPayment(PayOrderDTO order) {
		
		int result3 = paymentMapper.registPayment(order);
		
	}

	public void updatefundingAchive(PayOrderDTO order) {
		
		int result4 = paymentMapper.updatefundingAchive(order);
	}

	public String selectPayment(PaymentDTO payment) {
		
		String result5 = paymentMapper.selectPayment(payment);
		
		return paymentMapper.selectPayment(payment);
	}


	 
		
	
}


