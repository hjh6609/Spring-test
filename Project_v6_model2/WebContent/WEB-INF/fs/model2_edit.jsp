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
	<!--	1.	�����͸� ����ڷκ��� �Է¹ް� ��� ��ư�� ������ ���� post������� request�� 
					EditController�� ������. �� EditController�� doPost()�޼ҵ尡 ȣ��ȴ�.-->
	<form method="post" align = "center"> 
		<!-- hidden���� idx���� �Ѱ�����. -->
		<input type="hidden" name="number" value="<%=num%>">
		<c:forEach var="album" items="${edit}">
		<div>
			�̸� : <input type='text' name='username'  value="${album.username} ">
		</div>
		<br />
		<br />
		<div>
			���� : <input type='text' name='title'  value="${album.title} ">
		</div>
		<br />
		<div>
			<textarea name='content'  cols="30"  rows="20">${album.content}</textarea>
		</div>
		<br />
		<div>
			<button>����</button>
		</div>
		</c:forEach>
	</form> 
</body>
</html>