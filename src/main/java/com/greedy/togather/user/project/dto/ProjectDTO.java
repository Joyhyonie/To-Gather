package com.greedy.togather.user.project.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjectDTO {
	
	private String projNo;			// 프로젝트번호
	private String userNo;			// 회원번호
	private String projName;		// 프로젝트명
	private String projSummary;		// 프로젝트 간략 소개
	private String projDetail;		// 프로젝트 상세 소개
	private String projInfoTitle;	// 리워드 안내 제목
	private String projInfoBody;	// 리워드 안내 내용
	private Date fundingStartDate;	// 펀딩 시작일
	private Date fundingEndDate;	// 펀딩 종료일
	private int fundingGoal;		// 펀딩 목표 금액
	private int fundingAchive;		// 펀딩 달성 금액
	private String projStatus;		// 상태
	private String projReview;		// 후기 내용
	
	private CategoryDTO category;		// 카테고리 정보
	private MakerDTO maker;				// 메이커 정보
	private List<RewardDTO> rewardList;	// 리워드 정보
	private List<LikeDTO> likeList; 	// 좋아요 정보
	private List<ReplyDTO> replyList;	// 댓글 정보
}
