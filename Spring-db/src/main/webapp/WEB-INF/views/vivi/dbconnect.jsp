<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.sql.*"%>
<%
    Connection conn = null;                                        // null로 초기화 한다.
    PreparedStatement pstmt = null;
 
     try{
         String strDriver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
         String strDBConn = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb";        // 사용하려는 데이터베이스명을 포함한 URL 기술
         String strUserID = "hjh1";                                                    // 사용자 계정
         String strUserPW = "1234";
                 
         Class.forName(strDriver);
         Connection objConn = DriverManager.getConnection(strDBConn, strUserID, strUserPW);
     
        // Statement
         Statement objStmt = objConn.createStatement();
         ResultSet objRS = objStmt.executeQuery("SELECT TOP 5 * FROM board");
 
         while(objRS.next()){    
             out.println(objRS.getString("NUM") + "<BR>");
         }
         //objRS.close();
         //objStmt.close();
     }catch(Exception e) {
            System.out.println(e);
            //e.printStackTrace();
            System.out.println("**");
        }
%>   
