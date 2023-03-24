package com.greedy.togather.admin.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.togather.admin.project.dao.StatusDTO;
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
	
	@GetMapping("/home")
	public String adminProjectHomeSearch(Model model) {
		
		Map<String, StatusDTO> statusMap = new HashMap<>();
		statusMap.put("statEvaluation", new StatusDTO("projStatus", "심사"));
		statusMap.put("statStart", new StatusDTO("projStatus", "진행"));
		statusMap.put("statReject", new StatusDTO("projStatus", "반려"));
		statusMap.put("statStop", new StatusDTO("projStatus", "중단"));
		statusMap.put("statEnd", new StatusDTO("projStatus", "마감"));
		statusMap.put("statReview", new StatusDTO("projReview", "후기"));

		
		model.addAttribute("statusMap", statusMap);
		
		return "/admin/project/Projecthome";
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
	
	@GetMapping("/page")
	public String adminProjectPage(@RequestParam("projNo") String projNo, Model model) {
		
		model.addAttribute("projNo", projNo);
		
		return "/admin/project/projectlist";
	}
	


}
