package com.kh.spring.board.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.vo.PageInfo;

public interface BoardService {
	// 게시글 총 갯수 가져오기  
	public int selectListCount();
	
	// 게시글 목록 가져오기
	public ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 조회수 증가
	public int increaseCount(int bno);
	
	// 게시글 내용 가져오기
	public Board selectBoard(int bno);

	// 게시글 추가(insert)
	public int insertBoard(Board b);
	
	// 게시글 수정
	public int updateBoard(Board b);
	
	// 게시글 검색
	public List<Board> searchByCondition(String condition, String keyword);
	
	// 댓글 목록 가져오기
	public ArrayList<Reply> selectReply(int bno);
	
	// 댓글 추가
	public int insertReply(Reply r);
	
	// 조회수 상위 5개
	public ArrayList<Board> selectTopBoardList();
}
