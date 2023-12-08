package com.tjoeun.ilsan.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service // bean 등록
public class MemberServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	public void getMemberList() {
		
		logger.debug("getMemberList");
		
	}

}
