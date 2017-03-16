package com.springdb.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	//빈즈에 등록된 똑같은 클래스의 객체를 찿아서 가져옴
	@Autowired
	private TestDAO dao;
	
	public String testService() {
		return this.toString();
	}
	
	public String testDAO() {
		return dao.testDAO();
	}

}
