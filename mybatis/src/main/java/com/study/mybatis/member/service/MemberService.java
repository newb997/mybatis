package com.study.mybatis.member.service;

import com.study.mybatis.member.vo.Member;

public interface MemberService {

	// 인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
	
	/*public abstarct*/ Member loginMember(Member m);	//안써도 알아서 붙여서 컴파일됨
	
	int insertMember(Member m);
	
	int checkId(String userId);
	
	int updateMember(Member m);
	
	int deleteMember(String userId);
}
