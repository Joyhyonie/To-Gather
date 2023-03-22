package com.greedy.togather.user.project.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.togather.Chap99ToGatherApplication;
import com.greedy.togather.common.paging.MoreSelectCriteria;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

@SpringBootTest
@ContextConfiguration(classes = {Chap99ToGatherApplication.class})
public class ProjectServiceTests {
	
	@Autowired
	private ProjectService projectService;
	
	@Test
	@DisplayName("프로젝트 리스트 조회용 서비스 테스트")
	public void selectProjectListTest() {
		
		// given
		int page = 1;
		String categoryNo = "CA002";
		
		// when
		Map<String, Object> projectList = projectService.selectProjectList(page, categoryNo);
		
		// then
		assertNotNull(projectList);
		System.out.println(projectList);
	}
	
	@Test
	@DisplayName("프로젝트 상세 페이지 조회용 서비스 테스트")
	public void selectProjectDetailTest() {
		
		// given
		
		// when
		Map<String, Object> projectList = projectService.selectProjectDetail("PJ000000001");
				
		// then
		assertNotNull(projectList);
		System.out.println(projectList);
		
	}
	
//	@Test
//	@Disabled
//	@DisplayName("리워드 조회용 서비스 테스트")
//	public void selectRewardListTest() {
//		
//		// given
//		RewardDTO reward = new RewardDTO();
//		reward.setProjNo("PJ000000001");
//		
//		// when
//		List<RewardDTO> rewardList = projectService.selectRewardList(reward);
//						
//		// then
//		assertNotNull(rewardList);
//		System.out.println(rewardList);
//	}
//	
//	@Test
//	@Disabled
//	@DisplayName("총 기부금 & 댓글 개수 조회용 서비스 테스트")
//	public void selectDonationAndReplyCountTest() {
//		
//		// given
//		
//		// when
//		ReplyDTO reply = projectService.selectDonationAndReplyCount("PJ000000001");
//		
//		// then
//		assertNotNull(reply);
//		System.out.println(reply);
//	}
	
	@Test
	@DisplayName("댓글 조회용 서비스 테스트")
	public void selectReplyListTest() {
		
		// given
		ReplyDTO reply = new ReplyDTO();
		reply.setProjNo("PJ000000001");
				
		// when
		List<ReplyDTO> replyList = projectService.selectReplyList(reply);
		
								
		// then
		assertNotNull(replyList);
		System.out.println(replyList);
	}
	
	
	

}
