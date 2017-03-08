package org.zerock.service;

import java.util.List;

import org.zerock.domain.FoodStore;
import org.zerock.persistence.FoodStoreDAO;

// Service 클래스
public class FoodStoreService {

	// 서비스 클래스에서 dao를 물고있어야 한다.
	private FoodStoreDAO dao;

	public FoodStoreService() {
		this.dao = new FoodStoreDAO();
	}// Constructor

	// 게시물 추가
	// ResisterController에서 FoodStoreService로 VO를 던져줬다. 그러면 Service에서는 DAO로 다시
	// VO를 던져서 데이터베이스에 저장되도록 한다.
	public boolean register(FoodStore vo) throws Exception {

		boolean judge = dao.register(vo);
		return judge;
	}// register()

	// 게시판 리스트를 데이터베이스에서 가져온다. 
	public List<FoodStore> getList() throws Exception {
		
		
		return dao.getList();
	}// getList()
	
	// 게시판 상세보기 데이터 로딩 
	public List<FoodStore> getView(int num) throws Exception {
		
		return dao.getView(num);
	}// getList2()
	
	// 삭제할 게시글 찾고 삭제
	public boolean getDelete(FoodStore vo) throws Exception {
		
		return dao.getDelete(vo);
	}// getDelete()
	
	// 삭제할 게시글 찾기2 
	//	public List<FoodStore> getDelete2(FoodStore vo) throws Exception {
	//		boolean judge = dao.getDelete2(vo);
	//		return dao.getDelete2();
	//	}// getList2()

}
