package com.greedy.togather.user.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.common.paging.MoreSelectCriteria;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

@Mapper
public interface ProjectMapper {

	/* 프로젝트 리스트 조회 */
	int selectProjectsTotalCount(); /* 페이징 처리를 위한 카테고리별 총 프로젝트 수 */
	List<ProjectDTO> selectProjectList(MoreSelectCriteria selectCriteria, String categoryNo);
	
	/* 프로젝트 상세 페이지 조회 */
	List<ProjectDTO> selectProjectDetail(String projNo);
	
	/* 프로젝트 상세 페이지 중, 리워드 조회 */
	List<RewardDTO> selectRewardList(RewardDTO reward);
	
	/* 프로젝트 상세 페이지 중, 댓글 */
	List<ReplyDTO> selectReplyList(ReplyDTO reply); /* 조회 */
	void insertReply(ReplyDTO reply); /* 등록 */
	
	/* 프로젝트 상세 페이지 중, 총 기부금 & 댓글 개수 조회 */
	ReplyDTO selectDonationAndReplyCount(String projNo);
	
	
	
}
