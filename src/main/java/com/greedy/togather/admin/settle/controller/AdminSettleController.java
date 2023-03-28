package com.greedy.togather.admin.settle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.togather.admin.settle.model.dto.AdminFundingDTO;

import com.greedy.togather.admin.settle.model.dto.AdminSettleDTO;
import com.greedy.togather.admin.settle.model.service.AdminSettleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/settle")
public class AdminSettleController {
	
	private AdminSettleService adminSettleService;
	
	public AdminSettleController(AdminSettleService adminSettleService) {
		 this.adminSettleService = adminSettleService;
	}
	
	/* 리스트 페이지 조회 기능(페이징, 검색기능) */
	@GetMapping("/list")
	public String selectSettleList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminSettleController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminSettleController] searchMap : {}", searchMap);
		
		Map<String, Object> settleListAndPaging = adminSettleService.selectSettleList(searchMap, page);
		model.addAttribute("paging", settleListAndPaging.get("paging"));
		model.addAttribute("settleList", settleListAndPaging.get("settleList"));
		
		return "admin/settle/settleList";
	}
	
	/* 삭제 기능 (체크박스) */
	@ResponseBody
	@PostMapping("/delete")
	public String deletesettleChecked(@RequestParam(value="checkBox[]") List<String> checkList, AdminSettleDTO settle) {
		
		/* 체크된 리스트가 가지고 있는 settleNo를 settleDTO에 set한 후에 service 레이어에 보낸다 */ 
		
		log.info("[AdminSettleController] checkList {}", checkList );
		
		for(String checkInfo : checkList) {
			settle.setSettleNo(checkInfo);
			log.info("[AdminSettleController] settle {}", settle);
			
			adminSettleService.deleteSettleChecked(settle);
		}

		return "redirect:/admin/settle/settleList";
	}
	
	/* 해당 프로젝트 정산 상세 페이지 조회 기능 */
	@GetMapping("/detail/{settleNo}")
	public String selectSettleDetail(@PathVariable("settleNo") String settleNo, Model model) {
		
		log.info("[AdminSettleController] settleNo : {}", settleNo);
		
		/* 프로젝트 정보 조회*/
		AdminSettleDTO projInfo = adminSettleService.selectProjInfo(settleNo);
		log.info("[AdminSettleController] projInfo : {}", projInfo);
		

		/* 펀딩 내역 조회*/
		String projNo = projInfo.getProjNo();
		log.info("[AdminSettleController] projInfo.ProjNo : {}", projInfo.getProjNo());
		
		List<AdminFundingDTO> fundingInfo = adminSettleService.selectFundingInfo(projNo);
		log.info("[AdminSettleController] fundingInfo : {}", fundingInfo);

		/* 총 펀딩 금액 계산 */
		int totalPay = 0; // 총 결제금액
		int totalRefund = 0; // 총 환불 금액
		
		for(AdminFundingDTO funding : fundingInfo) {
			totalPay += funding.getPay().getPayPrice();
			totalRefund += funding.getPay().getRefund().getRefundPrice();
			
		}
		
		int totalFunding = totalPay - totalRefund; // 총 펀딩금액
		int mnCharge = (int) (totalFunding * 0.07); // 운영 수수료
		int payCharge = (int) (totalFunding * 0.03); // 결제 수수료
		
		
		model.addAttribute("projInfo", projInfo);
		model.addAttribute("fundingInfo", fundingInfo);
		model.addAttribute("totalPay", totalPay);
		model.addAttribute("totalRefund", totalRefund);
		model.addAttribute("totalFunding", totalFunding);
		model.addAttribute("mnCharge", mnCharge);
		model.addAttribute("payCharge", payCharge);

		return "admin/settle/settleDetail";
	}
	

}
