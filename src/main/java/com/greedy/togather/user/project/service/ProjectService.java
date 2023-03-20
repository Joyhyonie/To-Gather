package com.greedy.togather.user.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.togather.user.project.dao.ProjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProjectService {
	
	private final ProjectMapper projectMapper;
	
	public ProjectService(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}
}
