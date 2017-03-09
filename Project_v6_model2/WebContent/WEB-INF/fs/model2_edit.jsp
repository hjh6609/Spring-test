<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%String num = request.getParameter("num"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Model2_edit</title>
</head>
<body>
	<!--	1.	데이터를 사용자로부터 입력받고 등록 버튼을 누르는 순간 post방식으로 request를 
					EditController로 날린다. 즉 EditController의 doPost()메소드가 호출된다.-->
	<form method="post" align = "center"> 
		<!-- hidden으로 idx값을 넘겨주자. -->
		<input type="hidden" name="number" value="<%=num%>">
		<c:forEach var="album" items="${edit}">
		<div>
			이름 : <input type='text' name='username'  value="${album.username} ">
		</div>
		<br />
		<br />
		<div>
			제목 : <input type='text' name='title'  value="${album.title} ">
		</div>
		<br />
		<div>
			<textarea name='content'  cols="30"  rows="20">${album.content}</textarea>
		</div>
		<br />
		<div>
			<button>수정</button>
		</div>
		</c:forEach>
	</form> 
</body>
</html>