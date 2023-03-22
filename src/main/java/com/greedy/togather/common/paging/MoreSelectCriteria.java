package com.greedy.togather.common.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoreSelectCriteria {
	
    private int page;					// 요청한 페이지 번호
    private int totalCount;				// 전체 게시물 수
    private int limit;					// 한 페이지에 보여줄 게시물 수
    private int maxPage;				// 가장 마지막 페이지
    private int startRow;				// DB 조회 시 최신 글 부터 조회해야 하는 행의 시작 수
    private int endRow;					// DB 조회 시 최신글부터 조회해야 하는 행의 마지막 수

}
