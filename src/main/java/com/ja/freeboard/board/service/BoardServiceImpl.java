package com.ja.freeboard.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.BoardSQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.*;


@Service
public class BoardServiceImpl {

	@Autowired
	private BoardSQLMapper boardSQLMapper;
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeContent(BoardVo boardVo) {
		boardSQLMapper.insert(boardVo);
		
	}
	
	public List<Map<String,Object>> getBoardList() {
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		List<BoardVo> boardList = boardSQLMapper.selectAll();
		
		for(BoardVo boardVo : boardList) {
			
			MemberVo memberVo = memberSQLMapper.selectByNo(boardVo.getMember_no());
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("memberVo", memberVo);
			map.put("boardVo", boardVo);
			
			list.add(map);		
		}
				
		return list;		
	}
	

	public Map<String,Object> getBoard(int board_no) {
		
		 Map<String,Object> map = new HashMap<String, Object>();
		 
		 
		 boardSQLMapper.updateReadCount(board_no);
		
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		MemberVo memberVo = memberSQLMapper.selectByNo(boardVo.getMember_no());
		
		map.put("memberVo", memberVo);
		map.put("boardVo", boardVo);
		
		return map;
	}

	
	public void deleteContent(int board_no) {	
		boardSQLMapper.deleteByNo(board_no);
	}
	public void updateContent(BoardVo boardVo) {
		boardSQLMapper.update(boardVo);
	}
	
}
