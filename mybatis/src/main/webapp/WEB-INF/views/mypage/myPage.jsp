<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#area1 {
		text-align: center;
	}
</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<div id="area1">
		<h1>마이페이지</h1>
		<form action="mypageUpdate.me" method="post">
			<input type="hidden" name="user_id" value="${ loginUser.user_id }">
			<table>
			<label for="">이름</label>
			<div>
				<input type="text" name="user_name" size="30px" readonly="readonly" value="${ loginUser.user_name }">
			</div>
			<label for="">비밀번호</label>
			<div>
				<input type="password" name="user_pwd" size="30px" value="${ loginUser.user_pwd }">
			</div>
			<label for="">EMAIL</label>
			<div>
				<input type="email" name="email" size="30px" value="${ loginUser.email }">
			</div>
			<label for="">전화번호</label>
			<div>
				<input type="text" name="phone" size="30px" value="${ loginUser.phone }">
			</div>
			<label for="">주소</label>
			<div>
				<input type="text" name="address" size="30px" value="${ loginUser.address }">
			</div>
			<br>
			<input type="submit" value="수정">
			&emsp;
			<input type="reset" value="삭제">
			</table>
		</form>
	</div>
</body>
</html>