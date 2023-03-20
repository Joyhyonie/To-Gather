package com.greedy.togather.user.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.greedy.togather.common.paging.SelectCriteria;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

@Mapper
public interface ProjectMapper {

	/* 프로젝트 리스트 조회 */
	int selectProjectsTotalCount(String categoryNo); /* 페이징 처리를 위한 카테고리별 총 프로젝트 수 */
	List<ProjectDTO> selectProjectList(SelectCriteria selectCriteria, String categoryNo);
	
	/* 프로젝트 상세 페이지 조회 */
	List<ProjectDTO> selectProjectDetail(String projNo);
	
	/* 프로젝트 상세 페이지 중, 리워드 조회 */
	List<RewardDTO> selectRewardList(RewardDTO reward);
	
	/* 프로젝트 상세 페이지 중, 댓글 조회 */
	List<ReplyDTO> selectReplyList(ReplyDTO reply);
	
	/* 프로젝트 상세 페이지 중, 총기부금&댓글개수 조회 */
	ReplyDTO selectDonationAndReplyCount(String projNo);
	
	
}
