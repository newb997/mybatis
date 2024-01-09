package com.study.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.study.mybatis.board.service.BoardServiceImpl;
import com.study.mybatis.board.vo.Board;
import com.study.mybatis.common.Pagination;
import com.study.mybatis.common.vo.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalRecord = new BoardServiceImpl().selectTotalRecord();	// 현재 총 게시물 개수 얻어오기
		//System.out.println(totalRecord);
		
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));	//String으로 가져오니까 형변환
		
		PageInfo pi = Pagination.getPageInfo(totalRecord, nowPage, 5, 3);
		
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}
	

}








