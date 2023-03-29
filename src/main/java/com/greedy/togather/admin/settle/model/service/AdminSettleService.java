package com.greedy.togather.admin.settle.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.togather.admin.settle.model.dao.AdminSettleMapper;
import com.greedy.togather.admin.settle.model.dto.AdminFundingDTO;
import com.greedy.togather.admin.settle.model.dto.AdminProjectDTO;
import com.greedy.togather.admin.settle.model.dto.AdminSettleDTO;

import com.greedy.togather.common.paging.Pagenation;
import com.greedy.togather.common.paging.SelectCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AdminSettleService {

	
private final AdminSettleMapper adminSettleMapper;
	
	public AdminSettleService(AdminSettleMapper adminSettleMapper) {
		this.adminSettleMapper = adminSettleMapper;
	}
	
	public Map<String, Object> selectSettleList(Map<String, String> searchMap, int page) {
			
		int totalCount = adminSettleMapper.selectTotalCount(searchMap);
		log.info("[AdminSettleService] totalCount : {}", totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[AdminSettleService] selectCriteria : {}", selectCriteria);
		
		List<AdminSettleDTO> settleList = adminSettleMapper.selectSettleList(selectCriteria);
		log.info("[AdminSettleService] settleList : {}", settleList);
		
		Map<String, Object> settleListAndPaging = new HashMap<>();
		settleListAndPaging.put("paging", selectCriteria);
		settleListAndPaging.put("settleList", settleList);
		
		return settleListAndPaging;
	}

	public void deleteSettleChecked(AdminSettleDTO settle) {

		adminSettleMapper.deleteSettleChecked(settle);
		
	}

	public AdminSettleDTO selectProjInfo(String settleNo) {
		
		return adminSettleMapper.selectProjInfo(settleNo);
		
		
	}

	public List<AdminFundingDTO> selectFundingInfo(String projNo) {
		
		return adminSettleMapper.selectFundingInfo(projNo);
	}

	public void doSettle(String projNo) {		
		
		adminSettleMapper.doSettle(projNo);
	}

	public List<AdminProjectDTO> selectEndProject() {
		return adminSettleMapper.selectEndProject();
	}

	public void insertTblSettle(String projNo) {
		adminSettleMapper.insertTblSettle(projNo);
		
	}





}