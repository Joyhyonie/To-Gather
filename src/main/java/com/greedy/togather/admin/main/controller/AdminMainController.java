package com.greedy.togather.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
	
	@GetMapping(value = "")
	public String main() {
		return "admin/main/main";
	}
	
	@PostMapping(value="/")
	public String redirectMain() {
		return "redirect:/admin";
	}
}
