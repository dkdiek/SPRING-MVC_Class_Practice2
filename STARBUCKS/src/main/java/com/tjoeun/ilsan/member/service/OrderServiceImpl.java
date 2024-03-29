package com.tjoeun.ilsan.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.tjoeun.ilsan.member.dao.OrderInfoDao;

@Service
@EnableTransactionManagement
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderInfoDao orderInfoDao;
	
	@Override
	@Transactional(readOnly = true)//셀렉트는 안해도 상관없음 insert,update는 사용
	public List<Map> getOrderList() {
		// TODO Auto-generated method stub
		return orderInfoDao.selectOrderInfo();
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})//셀렉트는 안해도 상관없음 insert,update는 사용
	public void order(Map map) throws Exception {
		String menu = (String)map.get("menu");
		String amount = (String)map.get("amount");
		int sum = 0;
		if ("cake".equals(menu)) {
			sum = 5000 * Integer.parseInt(amount);
		}
		if ("coffee".equals(menu)) {
			sum = 5500 * Integer.parseInt(amount);
		}
		if ("sandwich".equals(menu)) {
			sum = 6000 * Integer.parseInt(amount);
		}
		map.put("sum", sum);
		map.put("user_id", "hongkdManual");

		int count = orderInfoDao.insertOrderInfo(map);
		if (0 == count) {
			throw new Exception();
		}
	}

}
