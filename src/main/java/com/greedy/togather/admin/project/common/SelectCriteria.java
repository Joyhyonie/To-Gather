package com.greedy.togather.admin.project.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SelectCriteria {
	
	private int page;
	private int totalCount;
	private int limit;
	private int buttonAmount;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private String searchCondition;
	private String searchValue;

}
