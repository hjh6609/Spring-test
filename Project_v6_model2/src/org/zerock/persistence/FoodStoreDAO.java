package org.zerock.persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zerock.domain.FoodStore;

public class FoodStoreDAO {

	private static Logger logger = Logger.getLogger(FoodStoreDAO.class);

	public void create(FoodStore vo) throws Exception {
		logger.info(vo);
	}// create()

	// DB에 게시글 등록
	public boolean register(FoodStore vo) throws Exception {

		StringBuffer query = new StringBuffer();
		
		query.append(" insert into board2(USERNAME,TITLE, CONTENT,PWD, READ_DATE ,HIT ) ");
		query.append(" values(?,?,?,?, GETDATE(),0 ) ");
		
		String username = vo.getUsername();
		String title = vo.getTitle();
		String content = vo.getContent();
		int pwd = vo.getPwd();
		
		StringBuilder test = new StringBuilder();
		
		new AbstractExecutor() {

			@Override
			protected void execute() throws Exception {

				con.setAutoCommit(false);

				// 매개변수로 받아온 데이터베이스에 보낼 SQL문으로 PreparedStatement객체를 만든다.
				pstmt = con.prepareStatement(query.toString());

				int idx = 1;
				pstmt.setString(idx++, username);
				pstmt.setString(idx++, title);
				pstmt.setString(idx++, content);
				pstmt.setInt(idx++, pwd);

				// insert, update, delete같은 DML쿼리는 PreparedStatment클래스의 executeUpdate()메소드를
				// 호출하여 쿼리를 실행 한다. 업데이트된(변경된) row의 수를 반환한다. 
				int count = pstmt.executeUpdate();
				test.append(count + "");

				// DML은 autocommit이 이루어지지 않으므로 다음처럼 commit을 수동으로 해주어야한다.
				con.commit();
			}
		}.executeJob();
		
		int judge = Integer.parseInt(test.toString());

		if (judge < 1) {
			throw new Exception("REGISTER FAILED");

		} else {
			System.out.println("REGISTER COMPLETE");
			return true;
		} // else
	}// register()
	
	// DB에서 글 삭제
	public boolean getDelete(FoodStore vo) throws Exception {
		
		StringBuffer query = new StringBuffer();
		
		query.append(" DELETE ");
		query.append(" FROM ");
		query.append(" board2  WHERE num= ? AND PWD = ? " );
		
		StringBuilder test = new StringBuilder();
		
		int num =vo.getNumber();
		int pwd = vo.getPwd();
	
		List<FoodStore> fsView = new ArrayList<>();
		
		new AbstractExecutor() {
			@Override
			protected void execute() throws Exception {
				con.setAutoCommit(false);

				// 매개변수로 받아온 데이터베이스에 보낼 SQL문으로 PreparedStatement객체를 만든다.
				pstmt = con.prepareStatement(query.toString());

				int idx = 1;
				pstmt.setInt(idx++, num);
				pstmt.setInt(idx++, pwd);

				// insert, update, delete같은 DML쿼리는 PreparedStatment클래스의 executeUpdate()메소드를
				// 호출하여 쿼리를 실행 한다. 업데이트된(변경된) row의 수를 반환한다. 
				int count = pstmt.executeUpdate();
				test.append(count + "");

				// DML은 autocommit이 이루어지지 않으므로 다음처럼 commit을 수동으로 해주어야한다.
				con.commit();
				
			}// execute()
		}.executeJob();

		int judge = Integer.parseInt(test.toString());

		if (judge < 1) {
			System.out.println("비번 틀림");
			//return false;
			throw new Exception("Delete FAILED");
		} else {
			System.out.println("Delete COMPLETE");
			return true;
		} // else
	}

	// DB에서 번호별 글을 불러온다.
	public List<FoodStore> getView(int num) throws Exception {
	
		StringBuffer query = new StringBuffer();
		
		query.append(" SELECT ");
		query.append(" USERNAME,TITLE,CONTENT,READ_DATE,HIT " );
		query.append(" FROM ");
		query.append(" board2  WHERE num= " + num );
		List<FoodStore> fsView = new ArrayList<>();
		
		new AbstractExecutor() {

			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub

				con.setAutoCommit(false);
				pstmt = con.prepareStatement(query.toString());

				// 쿼리를 실행후 결과를 ResultSet으로 받아온다.
				rs = pstmt.executeQuery();

				int idx = 0;
				// ResultSet클래스의 next()메소드는 현재위치의 row에서 다음의 row로 커서를 옮긴다.
				// 처음 호출될때 가장 첫 줄의 row 위치로 커서를 옮긴다.
				while (rs.next()) {

					FoodStore fsVO = new FoodStore();
	
					fsVO.setUsername(rs.getString(1));
					fsVO.setTitle(rs.getString(2));
					fsVO.setContent(rs.getString(3));
					fsVO.setRead_date(rs.getDate(4));
					fsVO.setHit(rs.getInt(5));
					fsView.add(idx, fsVO);
					idx++;
				} // while()
			}// execute()
		}.executeJob();

		return fsView;
	}// getList()
		

	// DB에서 게시글 리스트 받아온다.
	// 쿼리를 DB로 날려서 모든 row들을 ResultSet으로 받아온다. 이후, 이 ResultSet의 모든 row들을
	// 순회하며 각 컬럼의 값들로 VO 를 만들어 리스트를 만들어 서비스로 반환한다.
	public List<FoodStore> getList() throws Exception {


		StringBuffer query = new StringBuffer();
		
		query.append(" SELECT ");
		query.append(" NUM,USERNAME,TITLE,CONTENT,READ_DATE,PWD,HIT ");
		query.append(" FROM ");
		query.append(" board2 ");
		List<FoodStore> fsList = new ArrayList<>();

		new AbstractExecutor() {

			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub

				con.setAutoCommit(false);
				pstmt = con.prepareStatement(query.toString());

				// 쿼리를 실행후 결과를 ResultSet으로 받아온다.
				rs = pstmt.executeQuery();

				int idx = 0;
				// ResultSet클래스의 next()메소드는 현재위치의 row에서 다음의 row로 커서를 옮긴다.
				// 처음 호출될때 가장 첫 줄의 row 위치로 커서를 옮긴다.
				while (rs.next()) {

					FoodStore fsVO = new FoodStore();

					// ResultSet클래스의 getString()메소드는 현재 커서(row)의 지정된 매개변수로 넘어온
					// 위치의 컬럼의 값을 String타입으로 반환한다. 주의할 점은 인덱스번호가 0이 아니라
					// 1부터 시작한다는 점이다.
					fsVO.setNum(rs.getInt(1));
					fsVO.setUsername(rs.getString(2));
					fsVO.setTitle(rs.getString(3));
					fsVO.setContent(rs.getString(4));
					fsVO.setRead_date(rs.getDate(5));
					fsVO.setPwd(rs.getInt(6));
					fsVO.setHit(rs.getInt(7));
					fsList.add(idx, fsVO);
					idx++;
				} // while()
			}// execute()

			// rs나 pstmt, con을 닫는 작업을 여기서 해줄 필요가 없다. 연결을 맺고 닫는 것 처럼 모든 DAO들의
			// 중복적인 작업들을 추상클래스로 빼서 수행되도록 설계한 것이다. 즉, 이 추상클래스를 상속받은
			// DAO클래스들은 추상메소드인 execute()즉, 자신이 수행해야할 기능에 대해서만 코딩해주면 되는것이다.
		}.executeJob();

		return fsList;
	}// getList()

}// class
