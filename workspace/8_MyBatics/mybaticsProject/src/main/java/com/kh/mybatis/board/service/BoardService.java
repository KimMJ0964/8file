package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.BoardFile;
import com.kh.mybatis.common.vo.PageInfo;

import jakarta.servlet.http.HttpServletRequest;

public interface BoardService {
	int selectListCount();

    ArrayList<Board> selectList(PageInfo pi);

    Board increaseCount(int boardNo);

    ArrayList<Board> selectMyPageBoardList(String loginId);

    int insertBoard(Board b, List<BoardFile> bfList);

    int insertComment(BoardComment boardComment);

    int deleteBoard(HttpServletRequest request, int boardNo);

    int updateBoard(Board b, BoardFile bf);

    ArrayList<BoardComment> commentList(int boardNo);

    ArrayList<BoardComment> replyList(int boardNo);

    int selectSearchCount(HashMap<String, String> map);

    ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

    List<BoardFile> filePath(int boardNo);

    int boardLike(HashMap<String, Object> map);

    int insertReply(BoardComment boardReply);

    int deleteComment(BoardComment boardComment);

    int likeCount(int boardNo);

    Board boardUpdatePage(int boardNo);
}
