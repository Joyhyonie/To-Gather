package com.greedy.togather.user.pay.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.togather.user.pay.dto.PayOrderDTO;
import com.greedy.togather.user.pay.dto.PaymentDTO;
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
	public String payScreen(/*@RequestBody Map<String, Object> reqMap*/@RequestParam("projNo") String projNo, @RequestParam("rewardNo") String rewardNo, Model model) {
			//@RequestParam("projNo") String projNo, @RequestParam("rewardNo") String rewardNo, 
			
//			ModelAndView model = new  ModelAndView();
			
//			System.out.println("size >>> " + reqMap.size());//2 이상
//			System.out.println("projNo 1>>>" + reqMap.get("projNo"));// prjoNO=
//			System.out.println("rewardNo >>> " + reqMap.get("rewardNo")); // rewardNo = 
			/* 프로젝트 상세 내용 조회 */
			Map<String, Object> payScreenDetails = paymentService.searchPayScreen(projNo, rewardNo);		
			log.info("[PayController] payScreenDetails : {}", payScreenDetails);
//			Map<String, Object> payScreenDetails = paymentService.searchPayScreen(rewardNo);
			
			System.out.println(rewardNo);
			System.out.println(projNo);
			
			
			model.addAttribute("payD", payScreenDetails.get("projectNo"));
			model.addAttribute("rewardL", payScreenDetails.get("reward"));
			
			//model.addAllObjects(payScreenDetails);
//			model.setViewName("/user/pay/payScreen");
		
		return "/user/pay/payScreen";
	}
	
	@GetMapping("/payComplete")
	public String payComplete(@RequestParam(value="payNo", required=false) String payNo, Model model) { 
		
		Map<String, Object> paymentList = paymentService.slectPayment(payNo);
		model.addAttribute("order", paymentList.get("payment"));
		
		return "/user/pay/payComplete";
	}
	
	@PostMapping("/payComplete")
	public @ResponseBody PayOrderDTO postPayComplete(/* @RequestBody Map<String, String> requestMap */@RequestBody PayOrderDTO order) {
		

//		log.info("order : {}",order);
		
		PayOrderDTO orderList = order;
		
		paymentService.registOrder(order);
		paymentService.registDelivery(order);
		paymentService.registPayment(order);
		paymentService.updatefundingAchive(order);
		
		return orderList;
	}
	
	@PostMapping("/cancel")
	public @ResponseBody String payCancel(@RequestParam(value= "payNo") String payNo) {
		
		
		
		return "";
	}
	
}
