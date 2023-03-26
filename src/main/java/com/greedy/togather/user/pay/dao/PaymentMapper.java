package com.greedy.togather.user.pay.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.togather.user.pay.dto.PayOrderDTO;
import com.greedy.togather.user.pay.dto.PaymentDTO;
import com.greedy.togather.user.project.dto.ProjectDTO;
import com.greedy.togather.user.project.dto.RewardDTO;

@Mapper
public interface PaymentMapper {

	

	int registOrder(PayOrderDTO order);

	int registDelivery(PayOrderDTO order);

	int registPayment(PayOrderDTO order);

	int updatefundingAchive(PayOrderDTO order);

	PaymentDTO selectPayment(String payNo);

	ProjectDTO selectProjectDetail(String projNo);

	RewardDTO selectRewardList(String rewardNo);

}
