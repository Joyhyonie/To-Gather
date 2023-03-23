package com.greedy.togather.admin.settle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/settle")
public class AdminSettleController {
	
	@GetMapping(value="/list")
	public String main() {
		return "admin/settle/settleList";
	}

}
