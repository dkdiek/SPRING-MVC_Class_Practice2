package com.tjoeun.ilsan.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.ilsan.member.sql.OrderInfoMapper;

@Repository
public class OrderInfoDaoImpl implements OrderInfoDao {
	
	@Autowired
	SqlSession sqlSession; //root-context에서 session 가져오기

	@Override
	public List<Map> selectOrderInfo() {
		OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);//쿼리문을 부르는 아이디
		return mapper.selectOrderInfo();
	}

}
