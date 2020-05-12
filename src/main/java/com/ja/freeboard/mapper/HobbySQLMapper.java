package com.ja.freeboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.ja.freeboard.vo.HobbyVo;

public interface HobbySQLMapper {
	
	@Insert("INSERT INTO FB_Hobby VALUES(FB_Hobby_seq.nextval,#{member_no},#{hobby_category_no})")
	public void insert(
			@Param("member_no") int member_no,
			@Param("hobby_category_no") int hobby_category_no);
	

}
