package com.skt.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import common.Template;
import com.skt.member.model.dao.MemberDao;
import com.skt.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = new MemberDao();

	// 사용자 정보 업데이트 로직
	public int updateMember(Member member) {
		SqlSession sqlSession = Template.getSqlSession();

		int updateUser = memberDao.updateMember(sqlSession, member);
		if (updateUser > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return updateUser;
	}

	// 비밀번호 변경
	public int updatePassword(Member member) {
		SqlSession sqlSession = Template.getSqlSession();

		int updateUser = memberDao.updatePassword(sqlSession, member);
		if (updateUser > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return updateUser;
	}

	public String selectPasswordByMemId(String memId) {
		SqlSession sqlSession = Template.getSqlSession();
		String result = memberDao.selectPasswordByMemId(sqlSession, memId);

		return result;
	}

	public ArrayList<Board> myPageBoard(String memId) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = memberDao.myPageBoard(sqlSession, memId);

		sqlSession.close();

		return list;
	}

	public ArrayList<BoardComment> myPageComment(String memId) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<BoardComment> list = memberDao.myPageComment(sqlSession, memId);

		sqlSession.close();

		return list;
	}

	public Member getMemberById(String memId) {
		SqlSession sqlSession = Template.getSqlSession();
		Member member = null;

		member = memberDao.getMemberById(sqlSession, memId);

		sqlSession.commit();

		return member;
	}

	// 회원 삭제
	public int deleteMember(String memId) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = 0;

		result = memberDao.deleteMember(sqlSession, memId);

		sqlSession.commit();

		sqlSession.close();

		return result;
	}

	public Member myPageInfo(String loginValue) {
		SqlSession sqlSession = Template.getSqlSession();

		Member member = memberDao.myPageInfo(sqlSession, loginValue);

		sqlSession.close();

		return member;
	}

	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = null;

		try {
			loginUser = memberDao.loginMember(sqlSession, m);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return loginUser;
	}

	public String searchByEmailOrPhone(String input) {
		SqlSession sqlSession = Template.getSqlSession();
		String searchId = null;

		try {
			searchId = memberDao.searchByEmailOrPhone(sqlSession, input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return searchId;
	}

	public String searchPassword(String memId, String email) {
		SqlSession sqlSession = Template.getSqlSession();
		String searchPwd = null;

		try {
			searchPwd = memberDao.searchPassword(sqlSession, memId, email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return searchPwd;
	}

	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = memberDao.insertMember(sqlSession, m);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result;
	}

	@Override
	public int checkId(java.lang.String checkId) {
		// SqlSession 객체를 생성
		SqlSession sqlSession = Template.getSqlSession();
		int result = 0;

		try {
			// MemberDao의 checkId 메서드 호출
			result = memberDao.checkId(sqlSession, checkId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close(); // SqlSession 객체 닫기
		}

		return result;
	}

}
