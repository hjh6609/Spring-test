<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>model2_list</title>
</head>
<body>
	<table width="600" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr><td colspan="6" align="center"><h1>Model2 Board</h1></td></tr>
	<tr bgcolor="skyblue">
	    <td width="20" align="center">Num</td>
	    <td width="100" align="center">Title</td>    
	    <td width="50" align="center">Name</td>
	    <td width="50" align="center">Date</td>
	    <td width="20" align="center">Cnt</td>
	</tr>
	
	<c:forEach var="album" items="${list}">
	<tr> 
	    <td align="center">${album.num}</td>    
	    <td align="center"><a href="model2_view.do?num=${album.num}">${album.title}</a></td>
	     <td align="center">${album.username}</td>
	    <td align="center">${album.read_date}</td>
	    <td align="center">${album.hit }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" width="399" align="center"  height="100">
			<input type=button value="글쓰기" OnClick="window.location='register' ">
		</td>
	</tr>
	</table>
</body>
</html>