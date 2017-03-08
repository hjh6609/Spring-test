package org.zerock.controller;

import javax.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.zerock.domain.FoodStore;
import org.zerock.service.FoodStoreService;

@WebServlet("/fs/model2_delete")
public class DeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	private FoodStoreService service;

	public DeleteController() {
		super();
		service = new FoodStoreService();
	}// Constructor
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
//		FoodStore fsVO = new FoodStore();
//		fsVO.setPwd( Integer.parseInt(request.getParameter("pwd") ) );
//		int num = Integer.parseInt(request.getParameter("num"));
//		//String pwd = request.getParameter("pwd");
//		
//		//try {
//		//	service.getDelete(num, fsVO);
//		//} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		//}
//		
//		//System.out.println(num);
//		//System.out.println("-------------------------------------");
//		//System.out.println(pwd);
		
		//delete_model2 view 띄우기:-)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fs/model2_delete.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("do Post called");

		// post방식에서 한글깨짐 현상은 다음과 같이 encoding방식을 UTF-8로 setting해준다.
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = null;
		FoodStore fsVO = new FoodStore();
		
		fsVO.setNumber( Integer.parseInt(request.getParameter("number") ) );
		fsVO.setPwd( Integer.parseInt(request.getParameter("pwd") ) );
		
		try{
			// VO를 서비스로 보내서 글 번호랑 비번 디비로 보낼 준비
			service.getDelete(fsVO);
			// register.jsp로부터의 요청을 수신하고, result.jsp에 전송하는 객체 dispatcher를 생성.
			dispatcher = request.getRequestDispatcher("/WEB-INF/fs/result2.jsp");
			
			// 문자열 storeVO라는 key, storeVO라는 value로 지정한다.
			request.setAttribute("fsVO", fsVO);
			
		}catch (Exception e) {
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher("/WEB-INF/sample.jsp");
		}
		
		// 삭제에 성공했을 시에 result.jsp에 서블릿의 요청을 전송하고,
		// 실패했을 시에 error.jsp에 서블릿의 요청을 전송한다.
		dispatcher.forward(request, response);
		
		System.out.print("1111");
		
	}

}
