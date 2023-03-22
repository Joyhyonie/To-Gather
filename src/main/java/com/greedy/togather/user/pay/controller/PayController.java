package com.greedy.togather.user.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.togather.user.pay.dto.OrderDTO1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {
	
	@GetMapping("/payScreen")
	public String payScreen() {
		
		return "/user/pay/payScreen";
	}
	
	@GetMapping("/payComplete")
	public String payComplete() {
		
		return "/user/pay/payComplete";
	}
	
	@PostMapping("/order")
	public @ResponseBody String postPayComplete(@ModelAttribute OrderDTO1 order) {
		
		
		
		
		return "redirect:/pay/payComplete";
	}
	
	
}
