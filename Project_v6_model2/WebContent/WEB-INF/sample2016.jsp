<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Sample 2016 </h1>
  
  <h1>${message}</h1>
  
  <ul>
    <c:forEach items="${list}" var="str">
      <li>${str }</li>
    </c:forEach>
  </ul>
  
  <img src="http://www.stardailynews.co.kr/news/photo/201505/58852_72530_2015.jpg">
</body>
</html>