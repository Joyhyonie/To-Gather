package com.greedy.togather.user.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.greedy.togather.Chap99ToGatherApplication;

@SpringBootTest
@ContextConfiguration(classes = {Chap99ToGatherApplication.class})
public class ProjectControllerTests {

	@Autowired
	private ProjectController projectController;	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	}
	
	
	@Test
	@DisplayName("프로젝트 리스트 조회용 컨트롤러 테스트")
	public void selectProjectListTest() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/project/disaster"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	@DisplayName("프로젝트 상세 페이지 조회용 컨트롤러 테스트")
	public void selectProjectDetailTest() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/project/detail"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	@DisplayName("리워드 조회용 컨트롤러 테스트")
	public void selectRewardListTest() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/project/loadReward"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	@DisplayName("댓글 조회용 컨트롤러 테스트")
	public void selectReplyListTest() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/project/loadReply"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	@DisplayName("총 기부금 & 댓글 개수 조회용 컨트롤러 테스트")
	public void selectDonationAndReplyCountTest() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/project/loadDonationAndReplyCount"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
}
