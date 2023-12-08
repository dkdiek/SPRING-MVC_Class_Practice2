package com.tjoeun.ilsan.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.ilsan.member.dao.OrderInfoDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderInfoDao orderInfoDao;
	
	@Override
	@Transactional(readOnly = true)//셀렉트는 안해도 상관없음 insert,update는 사영
	public List<Map> getOrderList() {
		// TODO Auto-generated method stub
		return orderInfoDao.selectOrderInfo();
	}

}
