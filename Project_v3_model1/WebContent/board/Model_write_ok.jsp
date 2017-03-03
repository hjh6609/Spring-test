<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="dao" class="board.DAO"/>
<jsp:useBean id="vo" class="board.VO"/>
<jsp:setProperty name="vo" property="*" />

<%	
	request.setCharacterEncoding("euc-kr");

	//String password1 = request.getParameter("txtPwd");
	//System.out.println("Before   " + password1 + "<br /><br />");

	int max = dao.getMax();
	
	//String password = request.getParameter("txtPwd");
	//System.out.println("After   " + password);
	
	dao.insertWrite(vo, max);
	
%>

  <script language="javascript">
   self.window.alert("입력한 글을 저장하였습니다.");
   location.href="Model_list.jsp"; 
</script>