package com.greedy.togather.user.user.model.dao;



import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.user.user.model.dto.AuthDTO;
import com.greedy.togather.user.user.model.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	UserDTO findByUserId(String userId);

	String selectUserById(String userId);

	int insertUser(UserDTO user);

	int insertUserRole();

	int updateUser(UserDTO user);

	int deleteUser(UserDTO user);

	int insertAuth(AuthDTO auth);

	int updatePwd(UserDTO updatePwd);

	String findLoginId(UserDTO user);

	UserDTO searchPwd(UserDTO user);

	
}


