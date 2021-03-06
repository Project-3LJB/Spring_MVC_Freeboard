package com.ja.freeboard.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.HobbySQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.MemberVo;


@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	@Autowired
	private HobbySQLMapper hobbySQLMapper;
	
	public void joinMember(MemberVo vo, int [] member_hobby) {
		
		int member_key = memberSQLMapper.createKey();
		vo.setMember_no(member_key);
		memberSQLMapper.insert(vo);
		
		if(member_hobby == null) {
			return;
		}
		
		
		for(int hobby : member_hobby) {
			hobbySQLMapper.insert(member_key, hobby);
			
		}
		
	}
	
	public MemberVo login(MemberVo vo) {
		
		return memberSQLMapper.selectByIdAndPw(vo);
		
		
	}

}
