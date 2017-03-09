package org.zerock.controller;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
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
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('패스워드 정보 오류');");
	        out.println("history.back();"); // 이전페이지로 이동
	        out.println("</script>");
	        out.close(); // 스트림 자원 반환
	        return;
		}
		dispatcher.forward(request, response);
		System.out.print("1111");
	}
}
