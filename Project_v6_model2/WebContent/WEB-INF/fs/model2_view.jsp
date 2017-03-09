<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<body>
<br /><br /><br /><br /><br />
<table width="500" border="1" align="center">
<c:forEach var="album" items="${view}">
	<tr>
		<td colspan="2" align="center" height="50">${album.title }</td>
	</tr>
	<tr>
		<td bgcolor="skyblue" height="30">Username</td>
		<td height="30">${album.username }</td>
	</tr>
	<tr>
		<td bgcolor="skyblue" height="30">Date</td>
		<td height="30">${album.read_date }</td>
	</tr>
	<tr>
		<td colspan="2" align="center" height="200">${album.content }</td>
	</tr>  
	<tr>
		<td colspan="2" width="399" align="center">
			<input type=button value="글쓰기" OnClick="window.location='register' ">
			<input type=button value="답글" >
			<input type=button value="목록"   OnClick="window.location='list'">
			<input type=button value="수정"  OnClick="window.location='model2_edit?num=<%=num%>' ">
			<input type=button value="삭제"  OnClick="window.location='model2_delete?num=<%=num%>'">
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>