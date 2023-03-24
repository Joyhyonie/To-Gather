package com.greedy.togather.user.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.common.paging.MoreSelectCriteria;
import com.greedy.togather.user.project.dto.FileDTO;
import com.greedy.togather.user.project.dto.MakerDTO;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

import lombok.extern.slf4j.Slf4j;

@Mapper
public interface ProjectMapper {

	/* 프로젝트 리스트 조회 */
	int selectProjectsTotalCount(String categoryNo); /* 페이징 처리를 위한 카테고리별 총 프로젝트 수 */
	List<ProjectDTO> selectProjectList(MoreSelectCriteria selectCriteria, String categoryNo);
	
	/* 프로젝트 상세 페이지 */
	/* 전체 화면 조회 */
	ProjectDTO selectProjectDetail(String projNo);
	
	/* 리워드 조회 */
	List<RewardDTO> selectRewardList(String projNo);
	
	/* 총 기부금 & 댓글 개수 조회 */
	ReplyDTO selectDonationAndReplyCount(String projNo);
	
	/* 댓글 조회 & 등록 */
	List<ReplyDTO> selectReplyList(ReplyDTO reply);
	void insertReply(ReplyDTO reply);
	
	/* 프로젝트 신청 */
	/* TBL_PROJECT에 정보 등록 */
	void insertProjectInfo(ProjectDTO project);
	
	/* TBL_FILE에 메인 이미지 등록 */
	void insertMainImage(FileDTO mainImage);
	
	/* TBL_FILE에 서브 이미지 등록 */
	void insertSubImage(FileDTO file);
	
	/* TBL_FILE에 정산서류 등록 */
	void insertSettleDoc(FileDTO settleDoc);
	
	/* TBL_FILE에 메인 이미지 등록 */
	void insertAccountDoc(FileDTO accountDoc);
	
	/* TBL_FILE에 메인 이미지 등록 */
	void insertEtcDoc(FileDTO etcDoc);
	
	/* TBL_PROJECT에 정보 등록 */
	void insertMakerInfo(MakerDTO maker);
	
	/* TBL_PROJECT에 정보 등록 */
	void insertRewardInfo(RewardDTO reward);
	
	
	
	
	
	
	
}
