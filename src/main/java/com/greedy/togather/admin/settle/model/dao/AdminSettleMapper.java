package com.greedy.togather.admin.settle.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.admin.settle.model.dto.AdminSettleDTO;
import com.greedy.togather.common.paging.SelectCriteria;

@Mapper
public interface AdminSettleMapper {

    int selectTotalCount(Map<String, String> searchMap);

	List<AdminSettleDTO> selectSettleList(SelectCriteria selectCriteria);

	void deleteSettleChecked(AdminSettleDTO settle);

}