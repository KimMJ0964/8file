package com.skt.member.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.member.model.vo.Member;

public class MemberDao {

	public int updateMember(SqlSession sqlSession, Member member) {
		System.out.println("UpdateDaoResult member : " + member);
		int UpdateDaoResult = sqlSession.update("memberMapper.updateMember", member);
		System.out.println("UpdateDaoResult : " + UpdateDaoResult);
		
		return UpdateDaoResult;
    }
    
    // 비밀번호 변경
    public int updatePassword(SqlSession sqlSession, Member member) {
    	return sqlSession.update("memberMapper.updatePassword", member);
    }
    
    public String selectPasswordByMemId(SqlSession sqlSession, String memId){
    	return sqlSession.selectOne("memberMapper.selectPasswordByMemId", memId);
    }
    
    public ArrayList<Board> myPageBoard(SqlSession sqlSession, String memId){
    	return (ArrayList)sqlSession.selectList("boardMapper.myPageBoard", memId);
    }
    
    public ArrayList<BoardComment> myPageComment(SqlSession sqlSession, String memId) {
    	return (ArrayList)sqlSession.selectList("boardMapper.myPageComment", memId);
    }
    
    public Member getMemberById(SqlSession session, String memId) {
        return session.selectOne("memberMapper.selectMemberById", memId);
    }
    
    public int deleteMember(SqlSession session, String memId) {
        return session.update("memberMapper.deleteMember", memId);
    }
    
    public Member myPageInfo(SqlSession sqlSession, String loginValue) {
    	return sqlSession.selectOne("memberMapper.myPageInfo", loginValue);
    }
    
    public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember",m);
	}

	public String searchByEmailOrPhone(SqlSession sqlSession, String input) {
		System.out.println("전달된 입력 값: " + input); 
	    return sqlSession.selectOne("memberMapper.searchByEmailOrPhone", input);
	}

	public String searchPassword(SqlSession sqlSession, String memId, String email) {
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("memId", memId);
	    paramMap.put("email", email);

	    return sqlSession.selectOne("memberMapper.searchPwd", paramMap);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public int checkId(SqlSession sqlSession, String checkId) {
        return sqlSession.selectOne("memberMapper.checkId", checkId);
    }
}