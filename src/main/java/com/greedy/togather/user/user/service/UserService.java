package com.greedy.togather.user.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.togather.common.exception.user.UserModifyException;
import com.greedy.togather.common.exception.user.UserRegistException;
import com.greedy.togather.common.exception.user.UserRemoveException;
import com.greedy.togather.user.user.model.dao.UserMapper;
import com.greedy.togather.user.user.model.dto.AuthDTO;
import com.greedy.togather.user.user.model.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserService {
	
	 private final UserMapper mapper;
	 private final PasswordEncoder passwordEncoder;


	    public UserService(UserMapper mapper, PasswordEncoder passwordEncoder) {
	        this.mapper = mapper;
	        this.passwordEncoder = passwordEncoder;
	        
	        
	    }

	    public boolean selectUserById(String userId) {

	        String result = mapper.selectUserById(userId);

	        return result != null ? true : false;
	    }

	    public void registUser(UserDTO user) throws UserRegistException{

	    	log.info("[UserService] registUser {}", user);
	    	
	        int result1 = mapper.insertUser(user);
	        int result2 = mapper.insertUserRole();
	        
	        if(!(result1 > 0 && result2 > 0)){
	            throw new UserRegistException("회원 가입에 실패하였습니다.");
	        }
	    }
	    
	    public void registAuth(AuthDTO auth) throws UserRegistException {
	    	
	    	log.info("[UserService] registAuth {}", auth);
	    	
	    	int result = mapper.insertAuth(auth);
	    	
	    	if(!(result > 0 )) {
	    		throw new UserRegistException("권한 등록에 실패하였습니다.");
	    	}
	    }

	    public void modifyUser(UserDTO user) throws UserModifyException {
	    	
	    	int result = mapper.updateUser(user);
	        if(!(result > 0)) {
	            throw new UserModifyException("회원 정보 수정에 실패하셨습니다.");
	        }
	    }

	    public void removeUser(UserDTO user) throws UserRemoveException {
	    	
	        int result = mapper.deleteUser(user);

	        
	        if(!(result > 0)) {
	            throw new UserRemoveException("회원 탈퇴에 실패하셨습니다.");
	        }
	    }

		public void modifyPwd(UserDTO updatePwd) throws UserModifyException {

			log.info("[UserService] updatePwd {}", updatePwd);
			
			int result = mapper.updatePwd(updatePwd);
			
			log.info("[UserService] updatePwd {}", updatePwd);
			
			if(!(result > 0)) {
				throw new UserModifyException("비밀번호 변경에 실패하였습니다.");
			}
	
		}

		public String findLoginId(UserDTO user) {
		
			log.info("[userService] user : " + user);
			
			return mapper.findLoginId(user);
			
		}

		public Boolean resetPassword(String phone, String email) {
			// TODO Auto-generated method stub
			return null;
		}

	
	}
	


