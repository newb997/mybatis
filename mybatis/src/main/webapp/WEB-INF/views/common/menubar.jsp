<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
<style>
	a {
		text-decoration: none;
		color: black;
	}
	.nav-area {
		background-color: black;
		color: white;
		height: 40px;
	}
	.menu {
		width: 250px;
		height: 40px;
		vertical-align: middle;
		text-align:center;
		font-size: 15px;
		font-weight: bold;
	}
	.menu:hover {
		color: goldenrod;
		cursor: pointer;
	}
</style>
</head>
<body>
	<!-- 240105 -->
	<h1 align="center">Welcome to AddInEdu Mybatis</h1>
	<div class="login-area" align="right">
		<!-- 로그인 전 -->
		<form action="" method="post">
			<!-- table>(tr>td*3)*3 -->
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId" required></td>
					<td rowspan="2"><button style="height: 50px;">로그인</button></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="userPwd" required></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<a href="">회원가입</a>
						<a href="">아이디 / 비번찾기</a>
					</td>
				</tr>
			</table>
		</form>
		
	<!-- 로그인 후 -->
<!-- 	
		<div>
			<table>
				<tr>
					<td colspan="2">
						<h3>xxx님 환영합니다</h3>
					</td>
				</tr>
				<tr>
					<td><a href="">마이페이지</a> / </td>
					<td><a href="">로그아웃</a></td>
				</tr>
			</table>
		</div>
	</div>
	 -->
	
		<br>
	
		<div class="nav-area" align="center">
			<table>
				<tr>
					<td class="menu">HOME</td>
					<td class="menu">공지사항</td>
					<td class="menu">게시판</td>
					<td class="menu">ETC</td>
				</tr>
			</table>
		</div>
	
	

</body>
</html>