package com.greedy.togather.user.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.togather.common.paging.MorePagenation;
import com.greedy.togather.common.paging.MoreSelectCriteria;
import com.greedy.togather.user.project.dao.ProjectMapper;
import com.greedy.togather.user.project.dto.FileDTO;
import com.greedy.togather.user.project.dto.MakerDTO;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.ReplyDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProjectService {
	
	private final ProjectMapper projectMapper;
	
	public ProjectService(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}
	
	/* 프로젝트 리스트 조회 */
	public Map<String, Object> selectProjectList(int page, String categoryNo) {
		
		/* 전체 게시글 수 확인 (페이징 처리를 위해) */
		int totalCount = projectMapper.selectProjectsTotalCount(categoryNo);
		log.info("[ProjectService] totalCount : {}", totalCount);
		log.info("[ProjectService] categoryNo : {}", categoryNo);
		
		/* 프로젝트 페이지 구성 */
		int limit = 8;
		
		MoreSelectCriteria selectCriteria = MorePagenation.getSelectCriteria(page, totalCount, limit);
		log.info("[ProjectService] selectCriteria : {}",  selectCriteria);
		
		List<ProjectDTO> projectList = projectMapper.selectProjectList(selectCriteria, categoryNo);
		log.info("[ProjectService] projectList : {}",  projectList);
		
		Map<String, Object> projectListAndPaging = new HashMap<>();
		projectListAndPaging.put("paging", selectCriteria);
		projectListAndPaging.put("projectList", projectList);
		
		return projectListAndPaging;
	}
	
	/* 프로젝트 상세 페이지 조회 */
	public Map<String, Object> selectProjectDetail(String projNo) {
		
		/* 프로젝트 상세 내용 */
		ProjectDTO projectDetail = projectMapper.selectProjectDetail(projNo);
		log.info("[ProjectService] projectDetail : {}", projectDetail);
		
		/* 리워드 조회 */
		List<RewardDTO> rewardList = projectMapper.selectRewardList(projNo);
		log.info("[ProjectService] rewardList : {}", rewardList);
		
		/* 총 기부금 & 댓글 개수 조회 */
		ReplyDTO donationAndReplyCount = projectMapper.selectDonationAndReplyCount(projNo);
		log.info("[ProjectService] donationAndReplyCount : {}", donationAndReplyCount);
		
		Map<String, Object> allProjectDetails = new HashMap<>();
		allProjectDetails.put("projectDetail", projectDetail);
		allProjectDetails.put("rewardList", rewardList);
		allProjectDetails.put("donationAndReplyCount", donationAndReplyCount);
		
		return allProjectDetails;
	}
	
	/* 프로젝트 상세 페이지 중, 댓글 */
	/* 조회 */
	public List<ReplyDTO> selectReplyList(ReplyDTO reply) {
		
		return projectMapper.selectReplyList(reply);
	}
	
	/* 등록 */
	public void insertReply(ReplyDTO reply) {
		
		projectMapper.insertReply(reply);
	}

	/* 프로젝트 신청 페이지 */
	public void createProject(ProjectDTO project, MakerDTO maker, List<RewardDTO> reward) {
		
		/* 각 테이블에 데이터 저장 */
		projectMapper.insertProjectInfo(project);
		
		projectMapper.insertMakerProfile(project.getProcessedMakerProfile());
		
		projectMapper.insertMainImage(project.getProcessedMainImage());
		
		for(FileDTO file : project.getProcessedSubImageList()) {
			projectMapper.insertSubImage(file);
		}

		projectMapper.insertSettleDoc(project.getProcessedSettleDoc()); 
		
		projectMapper.insertAccountDoc(project.getProcessedAccountDoc());
		
		projectMapper.insertEtcDoc(project.getProcessedEtcDoc());
		
		projectMapper.insertMakerInfo(maker);		
		
		projectMapper.insertRewardInfo(reward);
		
	}
	
}
