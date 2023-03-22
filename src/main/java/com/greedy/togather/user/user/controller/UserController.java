package com.greedy.togather.user.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.togather.common.exception.user.UserModifyException;
import com.greedy.togather.common.exception.user.UserRegistException;
import com.greedy.togather.common.exception.user.UserRemoveException;
import com.greedy.togather.user.user.model.dto.MailDto;
import com.greedy.togather.user.user.model.dto.UserDTO;
import com.greedy.togather.user.user.service.AuthenticationService;
import com.greedy.togather.user.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {


	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	
	private final PasswordEncoder passwordEncoder;
    private final MessageSourceAccessor messageSourceAccessor;
    private final UserService userService;
    private final AuthenticationService authenticationService;
    

    public UserController(MessageSourceAccessor messageSourceAccessor, UserService userService, PasswordEncoder passwordEncoder, 
    		AuthenticationService authenticationService) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
        
        
        
    }

    /* 로그인 */
    @GetMapping("/login")
    public String goLogin() {

        return "user/login/login";
    }

    /* 로그인 실패 */
   @PostMapping("/loginfail")
    public String loginFailed(RedirectAttributes rttr) {
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
    	
    	return "redirect:/user/login";
    }
    
   /* 아이디 찾기 */
   @GetMapping("/searchId")
   public String goSearchId() {
	   
	   return "user/login/searchId";
   }
   

   /* 비밀번호 찾기 */
   @PostMapping("/searchPwd")
   public String resetPassword(@ModelAttribute UserDTO user, RedirectAttributes rttr) {
      
	   Boolean result = userService.resetPassword(user.getPhone(), user.getEmail());
       if(result == true) {
           rttr.addFlashAttribute("msg", "임시비밀번호를 이메일로 전송했습니다");
           return "redirect:/user/login";
       } else {
           rttr.addFlashAttribute("msg", "비밀번호를 찾지 못했습니다");
           return "redirect:/user/searchPwd";
       }
  
   } 
   
   /* 비밀번호 찾기 */
   @GetMapping("/searchPwd")
   public String goSearchPwd() {
	   
	   return "user/login/searchPwd";
   }
    
   /* 비밀번호 찾기 결과 */
   @GetMapping("/searchPwdResult")
   public String goSearchPwdResult() {
	   
	   return "user/login/searchPwdResult";
   }
   
 
   /* 회원 가입 페이지 */
    @GetMapping("/signup")
    public String goRegister() {
    	
    	return "user/login/signup";
    }
    
    
    /* 아이디 중복 확인 */
    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody UserDTO user) {
    	
    	String result = "사용 가능한 아이디입니다.";
    	log.info("[UserController] Request Check ID : {}", user.getEmail());
    	
    	if(userService.selectUserById(user.getEmail())) {
    		log.info("[UserController] Already Exist");
    		result = "중복 된 아이디가 존재합니다.";
    	}    	
    	
    	return ResponseEntity.ok(result);
    }
    
    /* 회원 가입 */
    @PostMapping("/signup")
    public String registUser(@ModelAttribute UserDTO user,
    		@RequestParam String address1, @RequestParam String address2,
    		RedirectAttributes rttr) throws UserRegistException {
    	
    	String address =  "$" + address1 + "$" + address2;
    	user.setAddress(address);
    	user.setPwd(passwordEncoder.encode(user.getPwd()));
    	
    	log.info("[UserController] registUser request User : " + user);
    	
    	userService.registUser(user);
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.signup"));
    	
    	return "user/login/successSignUp";
    }
    
    /* 내 정보 수정페이지 */
    @GetMapping("/myInfo")
    public String goModifyUser(@AuthenticationPrincipal UserDTO loginUser, Model model) {
    	
    	String[] address = loginUser.getAddress().split("\\$");
    	
    	model.addAttribute("address", address);
    	
    	return "user/myPage/myInfo";
    }
    
  
    /* 회원 정보 수정 */
    @PostMapping("/myInfo")
    public String modifyUser(@ModelAttribute UserDTO updateUser,
    		@RequestParam String address1, @RequestParam String address2,
    		@AuthenticationPrincipal UserDTO loginUser,
    		RedirectAttributes rttr) throws UserModifyException {
    	
    	String address = "$" + address1 + "$" + address2;
    	updateUser.setAddress(address);
    	updateUser.setUserNo(loginUser.getUserNo());
    	
    	log.info("[UserController] modifyUser request User : {}", updateUser);
    	
    	userService.modifyUser(updateUser);
    	

    	SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginUser.getEmail()));
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.modify"));
    	
    	return "redirect:/";
    }
    
    /* 회원 정보 수정 시 세션에 저장 된 정보 업데이트 */
    protected Authentication createNewAuthentication(String email) {
    	
    	UserDetails newPrincipal = authenticationService.loadUserByUsername(email);
    	UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;
        
    }
    
    /* 비밀 번호만 변경 */
    @PostMapping("/myInfo.pwd")
    public String modifyPwd(@ModelAttribute UserDTO updatePwd, @AuthenticationPrincipal UserDTO loginUser,
    		RedirectAttributes rttr) throws UserModifyException {
    	
    	updatePwd.setPwd(passwordEncoder.encode(updatePwd.getPwd()));
    	updatePwd.setUserNo(loginUser.getPwd());
    	
    	log.info("[UserController] modifyPwd request User : {}", updatePwd);
    	
    	userService.modifyPwd(updatePwd);
 
    	SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginUser.getPwd()));
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.pwd"));
    	
    	return "redirect:/";
    	
    }
   
    
 
    
    /* 회원 탈퇴 페이지 */
    @GetMapping("/withdrawal")
    public String goWithDrawal() {
    	
    	return "user/myPage/withdrawal";
    }
    
    /* 회원 탈퇴 */
    @GetMapping("/delete")
    public String deleteUser(@AuthenticationPrincipal UserDTO user, RedirectAttributes rttr) throws UserRemoveException {
    	
        log.info("[UserController] user : " + user);
        
        userService.removeUser(user);

        SecurityContextHolder.clearContext();

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.delete"));

        return "redirect:/";
    }
    
    /* 마이 페이지 */
    @GetMapping("/myPage")
    public String goMyPage() {
    	
    	return "user/myPage/myPage";
    }
  
    /* 좋아요한 프로젝트 */
    @GetMapping("/likedProject")
    public String goLikedProject() {
    	
    	return "user/myPage/likedProject";
    }
    
    /* 나의 프로젝트 */
    @GetMapping("/myProject")
    public String goMyProject() {
    	
    	return "user/myPage/myProject";
    }
   
    
    
    
    /* 내 정보 비밀번호 변경 */
    @GetMapping("/myInfo.pwd")
    public String goMyInfoPwd() {
    	
    	return "user/myPage/myInfo.pwd";
    
    }
    
    
    /* 아이디 찾기 */
    
    @PostMapping("/searchId")
    public String doFindIdSearch(@ModelAttribute UserDTO user, Model model) {
    log.info("[UserController] user : " + user);
    String email = userService.findLoginId(user);
    model.addAttribute("email", email);
    log.info("[UserController] model : " + model);
    String result = "";
    
    if(email != null) {
    result = "user/login/searchIdResult";
    } else {
    result = "user/login/searchId";
    }
    return result;

    }

}
