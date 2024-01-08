package com.study.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.common.Template;
import com.study.mybatis.member.dao.MemberDao;
import com.study.mybatis.member.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();	// 세션 얻어오기
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();		//세션끊기
		return loginUser;
	}

	@Override
	public int checkId(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		int checkid = mDao.checkId(sqlSession, userId);
		sqlSession.close();
		return checkid;
	}
	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		int insertUser = mDao.insertMember(sqlSession, m);
		
		// mybatis-config.xml 에서 <transactionManager type="JDBC" /> JDBC로 해놨으면 commit을 따로 해줘야함 싫으면 MANAGED
		if(insertUser > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		return insertUser;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
