package com.greedy.togather.admin.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.togather.admin.project.service.AdminProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/project")
public class AdminProjectController {
	
	private final AdminProjectService adminProjectService;
	
	
	public AdminProjectController(AdminProjectService adminProjectService) {
		this.adminProjectService = adminProjectService;
		
	}
	
	
	@GetMapping("/list")
	public String boardList(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String searchCondition,
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminProjectController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminProjectController] searchMap : {}", searchMap);
		
		Map<String, Object> boardListAndPaging = adminProjectService.seletProjectList(searchMap, page);
		model.addAttribute("paging", boardListAndPaging.get("paging"));
		model.addAttribute("adminProjectList", boardListAndPaging.get("adminProjectList"));
	
		
		return "/admin/project/projectList";
	}
	

	

}
