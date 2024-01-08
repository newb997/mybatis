<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<h1 align="center">회원가입</h1>
	
	<form method="post" action="insert.me" id="enrollForm">
		<table align="center">
			<tr>
				<td>* ID</td>
				<td>
					<input name="user_id" id="userId" required>
					<div id="checkResult" style="font-size: 0.8em; display: none;"></div>
				</td>
			</tr>
			<tr>
				<td>* PWD</td>
				<td><input type="password" name="user_pwd" required></td>
			</tr>
			<tr>
				<td>* NAME</td>
				<td><input name="user_name" required></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>BIRTHDAY</td>
				<td><input name="birthday" placeholder="생년월일(6자리)" onfocus="this.placeholder=''" onblur="this.placeholder='생년월일(6자리)'"></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td>
					<input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F">여
				</td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td><input name="phone" placeholder="-포함" onfocus="this.placeholder=''" onblur="this.placeholder='-포함'"></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input name="address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
		
	<script>
		$(()=>{
			const $idInput = $("#userId");
			$idInput.keyup(function() {
				if($idInput.val().length >= 5) {
					$.ajax({
						url: "idCheck.me",
						data : {checkId: $idInput.val()},
						success:function(result) {
							console.log(result);
							if(result == "idN") {
								$('#checkResult').show();
								$('#checkResult').css("color","red").text("사용중인 아이디 입니다. 다시 입력");
								$("#enrollForm :submit").attr("disabled", true);
							}else {
								$('#checkResult').show();
								$('#checkResult').css("color","green").text("사용 가능한 아이디 입니다.");
								$("#enrollForm :submit").attr("disabled", false);
							}
						},
						error:function(){
							console.log("아이디 중복체크용 ajax통신 실패");
						}
					})
				} else {
					$('#checkResult').hide();
					$("#enrollForm :submit").attr("disabled", true);
				}
			})
		})
	</script>
</body>
</html>