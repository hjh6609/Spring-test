<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.sql.*"%>
<%
    Connection conn = null;                                        // null�� �ʱ�ȭ �Ѵ�.
    PreparedStatement pstmt = null;
 
     try{
         String strDriver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";                       // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.
         String strDBConn = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���
         String strUserID = "hjh1";                                                    // ����� ����
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
