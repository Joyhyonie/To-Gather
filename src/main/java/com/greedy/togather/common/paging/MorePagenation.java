package com.greedy.togather.common.paging;

public class MorePagenation {
	
	/* 프로젝트 리스트 페이징을 위해 메소드 생성 */
	public static MoreSelectCriteria getSelectCriteria(int page, int totalCount, int limit) {
		
		 int startRow;	// 조회할 시작 번호
		 int endRow;	// 마지막 행 번호
		 int maxPage;	// 전체 페이지에서 가장 마지막 페이지 (마지막 페이지에서는 더보기 버튼 X)
		 
		 maxPage = (int) Math.ceil((double) totalCount / limit);
		 startRow = (page - 1) * limit + 1;
	     endRow = startRow + limit - 1;
		 
	     MoreSelectCriteria moreSelectCriteria = new MoreSelectCriteria(page, totalCount, limit, startRow, endRow, maxPage);
	     
	     return moreSelectCriteria;
	}

}
