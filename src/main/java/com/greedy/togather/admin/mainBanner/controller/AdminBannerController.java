package com.greedy.togather.admin.mainBanner.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.togather.admin.mainBanner.service.AdminBannerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/mainbanner")
public class AdminBannerController {
	
	private final AdminBannerService adminBannerService;
	
	public AdminBannerController(AdminBannerService adminBannerService) {
		
		this.adminBannerService = adminBannerService;
	}

	@GetMapping("list")
	public String bannerList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminBannerController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminBannerController] searchMap : {}", searchMap);
		
		Map<String, Object> boardListAndPaging = adminBannerService.selectBannerList(searchMap, page);
		model.addAttribute("paging", boardListAndPaging.get("paging"));
		model.addAttribute("bannerList", boardListAndPaging.get("bannerList"));
		
		
		return "admin/mainBanner/mainBannerList";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
