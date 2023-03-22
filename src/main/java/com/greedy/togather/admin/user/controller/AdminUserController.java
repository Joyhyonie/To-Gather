package com.greedy.togather.admin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.togather.admin.user.model.dto.AdminUserDTO;
import com.greedy.togather.admin.user.model.service.AdminUserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
	private final AdminUserService adminUserService;
	public AdminUserController(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	
	/* 리스트 페이지 조회 기능(페이징, 검색기능) */
	@GetMapping("/list")
	public String selectUserList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminUserController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminUserController] searchMap : {}", searchMap);
		
		Map<String, Object> userListAndPaging = adminUserService.selectUserList(searchMap, page);
		model.addAttribute("paging", userListAndPaging.get("paging"));
		model.addAttribute("userList", userListAndPaging.get("userList"));
		
		return "admin/user/userList";
	}
	
	/* 삭제 기능 (체크박스) */
	
	

}
