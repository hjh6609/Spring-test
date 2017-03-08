<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Model2 Board Write</title>
</head>
<body>
	<h2 align="center">Model2 Board Write</h2>

	<!--	1.	데이터를 사용자로부터 입력받고 등록 버튼을 누르는 순간 post방식으로 request를 
						registerController로 날린다. 즉 registerController의 doPost()메소드가 호출된다.-->
	<form method="post" align = "center">

		<div>
			이름 : <input type='text' name='username' >
		</div>
		<br />
		<div>
			비번 : <input type='password' name='pwd' >
		</div>
		<br />
		<div>
			제목 : <input type='text' name='title' >
		</div>
		<br />
		<div>
			<textarea name='content'  cols="30"  rows="20"></textarea>
		</div>
		<br />
		<div>
			<button>등록</button>
		</div>

	</form>

</body>
</html>