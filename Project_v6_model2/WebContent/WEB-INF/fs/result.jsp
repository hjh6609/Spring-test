<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
</head>
<body>

	<!--	다음과 같이 el을 사용하면 username에 해당하는 getter를 Apache Tomcat v8.0 라이브러리가 
				호출해준다.-->
	${fsVO.username} 등록됐습니다.

	<!--	setTimeout(함수, 시간) 메소드는 함수가 지정된 시간이후에 호출되도록 설정하는 것이다.
				근데 아래와 같이 현재의 위치를 /Project_v6_model2/fs/list로해서 리스트를 뿌려주는 서블릿(controller)으로
				지정해주는데는 이유가 있다. 만약 이런 처리를 해주지 않을때의 상황을 보자. 
				입력화면에서 전송 버튼을 누르면 컨트롤러에서 doPost()가 호출되어 게시글객체를 추가하고,
				result.jsp에서 등록완료 메세지를 띄워준다 . 이 일련의 작업이 완료된 후에도 url은 
				http://localhost:8081/Project_v6_model2/fs/register 으로 변하지 않는다. 그러면 브라우저에서 f5번을 누르면
				그대로 등록완료 메세지가 보여질 것이다. 사실은 또 다시 post방식으로 맛집데이터가 컨트롤러로 보내지고 
				그럼 doPost()가 호출되어 게시물객체를 추가하고 result.jsp에서 등록완료 메세지를 띄워준것이다.
				중복적인 데이터를 연속적으로 빠르게 넣을 수 있다.(도배) 따라서 데이터를 한번 넣고 1초 후(바로 바뀌면 성공 
				메세지를 볼 수 없으므로) /list서블릿을 호출해서 url이 바뀌도록 해준것이다. 그러면 새로고침을 통한
				도배를 막을 수 있다.-->
	<script>
		setTimeout(function() {
			window.location = "/Project_v6_model2/fs/list";
		}, 1000);
	</script>

</body>
</html>