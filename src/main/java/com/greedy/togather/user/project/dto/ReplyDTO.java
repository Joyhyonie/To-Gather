package com.greedy.togather.user.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDTO {
	
	private String replyNo;		// 댓글 번호
	private String projNo;		// 프로젝트 번호
	private String replyBody;	// 댓글 내용
	private Date replyRegDate;	// 작성일
	private int donation;		// 기부금
	private String userId;		// SUBSTR(B.EMAIL, 1, INSTR(B.EMAIL, '@') -1) 회원 아이디
	
	private ReplyWriterDTO writer;	// 댓글 작성자 정보
}
