package com.greedy.togather.user.project.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.togather.Chap99ToGatherApplication;
import com.greedy.togather.common.paging.SelectCriteria;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

@SpringBootTest
@ContextConfiguration(classes = {Chap99ToGatherApplication.class})
public class ProjectMapperTests {
	
	@Autowired
	private ProjectMapper projectMapper;
	
	@Test
	@DisplayName("프로젝트 리스트 조회용 매퍼 테스트")
	public void selectProjectListTest() {
		// given
		SelectCriteria critetia = new SelectCriteria();
		critetia.setEndRow(10);
		critetia.setStartRow(1);
		
		// when
		List<ProjectDTO> projectList = projectMapper.selectProjectList(critetia, "CA003");
		
		// then
		assertNotNull(projectList);
		System.out.println(projectList);
	}
	
	@Test
	@DisplayName("프로젝트 상세페이지 조회용 매퍼 테스트")
	public void selectProjectDetailTest() {
		// given
		
		// when
		List<ProjectDTO> projectDetail = projectMapper.selectProjectDetail("PJ000000001"); 
		
		// then
		assertNotNull(projectDetail);
		System.out.println(projectDetail);
	}
	
	@Test
	@DisplayName("리워드 조회용 매퍼 테스트")
	public void selectRewardListTest() {
		// given
		RewardDTO reward = new RewardDTO();
		reward.setProjNo("PJ000000001");
		
		// when
		List<RewardDTO> rewardList = projectMapper.selectRewardList(reward);
		
		// then
		assertNotNull(rewardList);
		System.out.println(rewardList);
	}
	
	@Test
	@DisplayName("댓글 조회용 매퍼 테스트")
	public void selectReplyListTest() {
		// given
		ReplyDTO reply = new ReplyDTO();
		reply.setProjNo("PJ000000001");
		
		// when
		List<ReplyDTO> replyList = projectMapper.selectReplyList(reply);
		
		// then
		assertNotNull(replyList);
		System.out.println(replyList);
	}
	
	
	

}
