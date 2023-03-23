package com.greedy.togather.user.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.ReplyWriterDTO;
import com.greedy.togather.user.project.dto.RewardDTO;
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
	public String goEducation(@RequestParam(defaultValue="1") int page, Model model) {
		
		String categoryCode ="CA001";
		String category = "education";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		log.info("[ProjectController] page : {}", page);
		log.info("[ProjectController] projectListAndPaging : {}", projectListAndPaging);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/disaster")
	public String goDisaster(@RequestParam(defaultValue="1") int page, Model model) {
		
		String categoryCode ="CA002";
		String category = "disaster";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/environment")
	public String goEnvironment(@RequestParam(defaultValue="1") int page, Model model) {
		
		String categoryCode ="CA003";
		String category = "environment";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/medical")
	public String goMedical(@RequestParam(defaultValue="1") int page, Model model) {
		
		String categoryCode ="CA004";
		String category = "medical";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/organic")
	public String goOrganic(@RequestParam(defaultValue="1") int page, Model model) {	
		
		String categoryCode ="CA005";
		String category = "organic";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/wild")
	public String goWild(@RequestParam(defaultValue="1") int page, Model model) {	
		
		String categoryCode ="CA006";
		String category = "wild";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
	}
	
	@GetMapping("/pet")
	public String goPet(@RequestParam(defaultValue="1") int page, Model model) {	
		
		String categoryCode ="CA007";
		String category = "pet";
		
		Map<String, Object> projectListAndPaging = projectService.selectProjectList(page, categoryCode);
		model.addAttribute("paging", projectListAndPaging.get("paging"));
		model.addAttribute("projectList", projectListAndPaging.get("projectList"));
		model.addAttribute("category", category);
		
		return "user/project/viewProjects/viewSelectedProjects";
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
	public String viewProjectDetail(@RequestParam(value="projNo", required=false) String projNo, Model model) {
		
		/* 프로젝트 상세 내용 조회 */
		Map<String, Object> allProjectDetails = projectService.selectProjectDetail(projNo);
		log.info("[ProjectController] allProjectDetails : {}", allProjectDetails);
		
		model.addAttribute("detail", allProjectDetails.get("projectDetail"));
		model.addAttribute("rewardList", allProjectDetails.get("rewardList"));
		model.addAttribute("donationAndReplyCount", allProjectDetails.get("donationAndReplyCount"));
		
		return "/user/project/viewProjectDetail/viewProjectDetail";
	}
	
	/* 댓글 조회(비동기통신) */
	@GetMapping("/loadReply")
	public ResponseEntity<List<ReplyDTO>> viewReplyList(ReplyDTO loadReply, Model model) {
		
		log.info("[ProjectController] loadReply : {}", loadReply);
		
		List<ReplyDTO> replyList = projectService.selectReplyList(loadReply);
		log.info("[ProjectController] replyList : {}", replyList); /* 조회된 최신 댓글 확인 */
		
		model.addAttribute("replyList", replyList);
		
		return ResponseEntity.ok(replyList);
	}
	
	/* 댓글 등록(비동기통신) */
	@PostMapping("/registReply")
	public ResponseEntity<String> registReply(@RequestBody ReplyDTO registReply,
			  								  @AuthenticationPrincipal ReplyWriterDTO writer) {
		log.info("[ProjectController] registReply : {}\", registReply");
		
		/* 랜덤 댓글 기부금 설정 */
		int random = (int)(Math.random() * 3) + 1; 
		int donation = (random == 1) ? 100 : 0;
		log.info("[ProjectController] donation : {}\", donation");
		
		/* registReply에는 projNo, replyBody만 담겨 있는 상태 */
		registReply.setWriter(writer); 		// 댓글 작성자 = 로그인 유저
		registReply.setDonation(donation);	// 랜덤 댓글 기부금
		
		projectService.insertReply(registReply);
		
		return ResponseEntity.ok("댓글 등록 완료💟");
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
