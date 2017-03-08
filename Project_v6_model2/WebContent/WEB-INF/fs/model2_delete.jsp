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
<title>model2_delete</title>

<script>
	function check(){
		if(!f.pwd.value){
			alert("비밀번호를 입력해야 해요");
			f.pwd.focus();
			return;
		}
		f.submit();
	}
</script>

</head>

<body>

<center>
	<form name="f" method="post">
	<hr width=500 color=red>
	
	<!-- hidden으로 idx값을 넘겨주자. -->
	<input type="hidden" name="number" value="<%=num%>">
	<input type="hidden" name="method" value=deleteOk>
	
	비밀번호:<input type="password" name="pwd">
	<input type="button" value="삭제" onclick="check()">
	<input type="reset" value="다시쓰기">
	<hr width=500 color=red>
	
	</form>
</center>

</body>
</html>