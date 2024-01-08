package com.study.mybatis.member.contoroller;

import java.io.IOException;

import com.study.mybatis.member.service.MemberServiceImpl;
import com.study.mybatis.member.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		//System.out.println("id : " + id + "pwd :" + pwd );
		
		Member m = new Member();
		m.setUser_id(id);
		m.setUser_pwd(pwd);
		
		// 한줄로 쓰면
//		m.setUser_id(request.getParameter("userId"));
//		m.setUser_pwd(request.getParameter("userPwd"));
		
		
//		MemberServiceImpl lu = new MemberServiceImpl();
//		Member loginUser = lu.loginMember(m);
//		한줄로 쓰면
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		if(loginUser == null) { //로그인 실패
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
			// getContextPath() : root path를 의미함
		}
		
	}

}
