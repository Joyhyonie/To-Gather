package com.greedy.togather.user.project.controller;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.togather.user.project.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
	
	private final ProjectService projectService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public ProjectController(ProjectService projectService, MessageSourceAccessor messageSourceAccessor) {
		this.projectService = projectService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	/* 카테고리별 프로젝트 페이지로의 이동 */
	@GetMapping("/education")
	public String goEducation() {		
		return "user/project/viewProjects/viewSelectedProjects/educationProjects";
	}
	
	@GetMapping("/disaster")
	public String goDisaster() {		
		return "user/project/viewProjects/viewSelectedProjects/disasterProjects";
	}
	
	@GetMapping("/environment")
	public String goEnvironment() {		
		return "user/project/viewProjects/viewSelectedProjects/environmentProjects";
	}
	
	@GetMapping("/medical")
	public String goMedical() {		
		return "user/project/viewProjects/viewSelectedProjects/medicalProjects";
	}
	
	@GetMapping("/organic")
	public String goOrganic() {		
		return "user/project/viewProjects/viewSelectedProjects/organicProjects";
	}
	
	@GetMapping("/wild")
	public String goWild() {		
		return "user/project/viewProjects/viewSelectedProjects/wildProjects";
	}
	
	@GetMapping("/pet")
	public String goPet() {		
		return "user/project/viewProjects/viewSelectedProjects/petProjects";
	}
	
	/* ------------------------------------------------------------------------------------------------------ */
	
	/* 프로젝트 신청 페이지 */
	@GetMapping("/create")
	public String goToCreateProject() {
		return "user/project/createProject/createProject";
	}
	
	@PostMapping("/create")
	public String createProject() {
		

		return "redirect:/project/submit";
	}
	
	/* 프로젝트 최종 제출 후 페이지 */
	@GetMapping("/submit") 
	public String submitProject() {
		
		return "/user/project/createProject/submitProject";
	}
	
	/* ------------------------------------------------------------------------------------------------------ */
	
	/* 프로젝트 상세 페이지 */
	@GetMapping("/detail")
	public String viewProjectDetail() {
		return "/user/project/viewProjectDetail/viewProjectDetail";
	}
	
	/* 프로젝트 공유 페이지 */
	@GetMapping("/share")
	public String shareProject() {
		return "/user/project/viewProjectDetail/shareProject";
	}
	
	/* ------------------------------------------------------------------------------------------------------ */
	
	/* 프로젝트 후기 작성 */
	@GetMapping("/review")
	public String goToWriteReview() {
		return "/user/project/writeReview/writeReview";
	}
	

}
