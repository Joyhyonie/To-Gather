package com.greedy.togather.admin.project.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.greedy.togather.Chap99ToGatherApplication;
import com.greedy.togather.admin.project.common.Pagenation;
import com.greedy.togather.admin.project.common.SelectCriteria;
import com.greedy.togather.admin.project.dto.AdminProjectDTO;

@SpringBootTest
@ContextConfiguration(classes = {Chap99ToGatherApplication.class})
public class AdminProjectMapperTests {

	@Autowired
	private AdminProjectMapper adminProjectMapper;
	
	@Test
	@Disabled
	public void 매퍼_인터페이스_의존성_주입_테스트() {
		
		assertNotNull(adminProjectMapper);
	}
	
	@Test
	@Disabled
	public void 프로젝트_조회용_매퍼_테스트() {
		
		//given
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", "projNm");
		searchMap.put("searchValue", "PJ000000021");

		//when
		int totalCount = adminProjectMapper.selectTotalCount(searchMap);
		
		
		//then
		assertNotNull(totalCount);
	}
	
	@Test

	public void 프로젝트_리스트_매퍼_테스트() {
		
		//given
		int page = 1;
		int totalCount = 10;
		int limit = 3;
		int buttonAmount = 5;
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", "projNm");
		searchMap.put("searchValue", "PJ000000021");
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit,
				buttonAmount, searchMap);
		
		
		//when
		List<AdminProjectDTO> adminProjectList = adminProjectMapper.selectAdminProjectList(selectCriteria);
		
		
		//then
		assertNotNull(adminProjectList);
		
		
	}
	

	
}
