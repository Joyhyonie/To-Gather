package com.greedy.togather.admin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserController {

	@GetMapping(value="/userlist")
	public String main() {
		return "admin/user/userList";
	}
	
}
