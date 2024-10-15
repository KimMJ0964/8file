package com.skt.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;
import com.skt.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class myPageLoginSessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myPageLoginSessionTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        String loginValue = loginUser.getMemId();
	    System.out.println("Session login value: " + loginValue);
	    
	    Member member = new MemberServiceImpl().myPageInfo(loginValue);
	    ArrayList<Board> board = new MemberServiceImpl().myPageBoard(loginValue);
	    ArrayList<BoardComment> boardComment = new MemberServiceImpl().myPageComment(loginValue);

	    request.setAttribute("member", member);
	    System.out.println(member);
	    
	    // board 값이 null이 아니고 빈 리스트가 아닐 경우에만 설정
	    if (board != null && !board.isEmpty()) {
	        request.setAttribute("communityList", board);
	    }

	    // boardComment 값이 null이 아니고 빈 리스트가 아닐 경우에만 설정
	    if (boardComment != null && !boardComment.isEmpty()) {
	        request.setAttribute("userCommentsList", boardComment);
	    }
	    
		request.getRequestDispatcher("views/myPage/myPage.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
