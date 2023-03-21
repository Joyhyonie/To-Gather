package com.greedy.togather.admin.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.admin.project.common.SelectCriteria;
import com.greedy.togather.admin.project.dto.AdminProjectDTO;

@Mapper
public interface AdminProjectMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<AdminProjectDTO> selectAdminProjectList(SelectCriteria selectCriteria);
		
	
	


}
