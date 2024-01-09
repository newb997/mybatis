package com.study.mybatis.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.board.vo.Board;
import com.study.mybatis.board.vo.Reply;
import com.study.mybatis.common.vo.PageInfo;

public class BoardDao {

	
	public int selectTotalRecord(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectTotalRecord");
	}

	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		/* 
			numPerPage(5개)
			 								offset(건너뛸숫자)			limit(조회할숫자)
			nowPage : 1		1 ~ 5				0						5개
			nowPage : 2		6 ~ 10				5						5개
			nowPage : 3		11 ~ 15				10						5개
		 */
		int limit = pi.getNumPerPage();
		int offset = (pi.getNowPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit = pi.getNumPerPage();
		int offset = (pi.getNowPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
	
	public int increaseCount(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Board selectBoard(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Reply> selectReplyList(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
