package com.greedy.togather.admin.user.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.admin.user.model.dto.AdminFundingDTO;
import com.greedy.togather.admin.user.model.dto.AdminTotalFundingDTO;
import com.greedy.togather.admin.user.model.dto.AdminUserDTO;
import com.greedy.togather.common.paging.SelectCriteria;

@Mapper
public interface AdminUserMapper {
	
		int selectTotalCount(Map<String, String> searchMap);

		List<AdminUserDTO> selectUserList(SelectCriteria selectCriteria);

		void deleteUserChecked(AdminUserDTO user);

		AdminUserDTO selectUserDetail(String userNo);

		List<AdminFundingDTO> selectFundingDetail(String userNo);



	}


