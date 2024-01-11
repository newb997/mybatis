package com.study.mybatis.member.contoroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.service.MemberServiceImpl;
import com.study.mybatis.member.vo.Member;

public class MypageUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = new Member();
		
		m.setUser_id(request.getParameter("user_id"));
		m.setUser_pwd(request.getParameter("user_pwd"));
		m.setUser_name(request.getParameter("user_name"));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));
		
		int result = new MemberServiceImpl().updateMember(m);
		
		if(result > 0 ) {
			response.sendRedirect(request.getContextPath());	// root로 가게해줌
		} else {
			request.setAttribute("ErrorMsg", "회원수정 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	
	}

}
