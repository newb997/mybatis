package com.study.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.member.vo.Member;

public class MemberDao {

	//Member loginUser = mDao.loginMember(sqlSession, m);
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		/*
		 *	sqlSession에서 제공한느 메소드를 통해 sql문을 찾아 실행하고 결과를 바로 받음
		 *	결과 : sqlSession.sql문 종류에 맞는 메소드("매퍼의 별칭.해당sql문고유한id",[이 sql문을 완성시킬 객체]) [이 sql문을 완성시킬 객체]은 있을수도 없을수도있음
		 */
//		Member me = sqlSession.selectOne("", m);
//		return me;

		return sqlSession.selectOne("memberMapper.loginMember", m); 	
		//memberMapper.loginMember : member-mapper.xml에서 namespace.select id
	}

	// 아이디중복체크
	public int checkId(SqlSession sqlSession, String userId) {
		
		return sqlSession.selectOne("memberMapper.checkId", userId);
	}

	// 회원가입
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}
}
