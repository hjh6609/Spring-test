package org.zerock.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;
import org.zerock.persistence.FoodStoreDAO;

public class FoodDAOTest {

	FoodStoreDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new FoodStoreDAO();
	}

	@Test
	public void test() throws Exception {
		
		//Class.forName("org.apache.commons.dbcp.PoolingDriver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		String jdbcDriver = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testdb";
		
		Connection con = DriverManager.getConnection(jdbcDriver);
		
		System.out.println(con);
		 
		con.close();
		
	}

}
