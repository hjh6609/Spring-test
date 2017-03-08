package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.zerock.domain.FoodStore;

// 추상 클래스 
public abstract class AbstractExecutor {
	
	// static블록은 class가 메모리에 loading될때 실행된다.
	// jdbc driver loading
	static{
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver"); // external jar
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e){}
	}
	
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	// 이 메소드를 final로 선언한 이유는 DAO들의 프로세스 진행 순서가 먼저
	// DB와의 연결을 맺고 
	public final void executeJob() throws Exception{
		
		try{
			makeConnection();
			execute();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally{
			closeAll();
		}
	}// executeJob()
	
	// 서버 데이터베이스에 연결하는 작업.
	private void makeConnection()throws Exception{ 
		//con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:XE","team4","team4");
		con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb","hjh1","1234");
	}
	
	// DAO들 마다의 수행 즉, DAO들마다 반드시 이 추상메소드를 적절히 오버라이딩해야한다.
	// 그래야 추상클래스의 public메소드 executeJob()을 호출할 수있다.
	protected abstract void execute()throws Exception;
	
	// 닫는 작업
	private void closeAll(){
		if(rs != null){try{rs.close();}catch(Exception e){}}
		if(pstmt != null){try{rs.close();}catch(Exception e){}}
		if(con != null){try{rs.close();}catch(Exception e){}}
	}
}
