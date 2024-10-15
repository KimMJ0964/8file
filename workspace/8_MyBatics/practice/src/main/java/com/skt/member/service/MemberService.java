package com.skt.member.service;

import com.skt.member.model.vo.Member;

public interface MemberService {
	
	public abstract int updatePassword(Member member);
	
	public abstract Member loginMember(Member m);
	
	public String searchByEmailOrPhone(String input);

	public abstract String searchPassword(String memId, String email);
	
	public int insertMember(Member m);
	
	public int checkId(String checkId);
}
