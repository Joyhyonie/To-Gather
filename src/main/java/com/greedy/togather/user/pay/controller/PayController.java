package com.greedy.togather.user.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.togather.user.pay.dto.PayOrderDTO;
//import com.greedy.togather.user.pay.service.PaymentService;
import com.greedy.togather.user.pay.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {
	
	private final PaymentService paymentService;
	
	public PayController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/payScreen")
	public String payScreen() {
		
		return "/user/pay/payScreen";
	}
	
	@GetMapping("/payComplete")
	public String payComplete() {
		
		return "/user/pay/payComplete";
	}
	
	@PostMapping("/payComplete")
	public @ResponseBody String postPayComplete(/* @RequestBody Map<String, String> requestMap */@RequestBody PayOrderDTO order) {
		

		log.info("order : {}",order);
		
		paymentService.registOrder(order);
		paymentService.registDelivery(order);
		paymentService.registPayment(order);
		paymentService.updatefundingAchive(order);
		
		return "success";
	}
	
	
}
