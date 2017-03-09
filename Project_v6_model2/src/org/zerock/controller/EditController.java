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


@WebServlet("/fs/model2_edit")
public class EditController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	private FoodStoreService service;

	public EditController() {
		super();
		service = new FoodStoreService();
	}// Constructor
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.print(num);
		
		//서비스로부터 게시글 리스트를 받아온다.
		List<FoodStore> fsedit = new ArrayList<>();
		try {
			fsedit = service.getEdit(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//model2_edit  view 띄우기:-)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fs/model2_edit.jsp");
		request.setAttribute("edit", fsedit);
		dispatcher.forward(request, response);		
	}	
	//글 수정 값 받기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("do Post called");
		// post방식에서 한글깨짐 현상은 다음과 같이 encoding방식을 UTF-8로 setting해준다.
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = null;
		FoodStore fsVO = new FoodStore();
		
		fsVO.setNumber( Integer.parseInt(request.getParameter("number") ) );
		fsVO.setTitle(request.getParameter("title"));
		fsVO.setContent(request.getParameter("content"));
		try{
			response.setContentType("text/html; charset=UTF-8");
			service.getEdit2(fsVO);
			// register.jsp로부터의 요청을 수신하고, result.jsp에 전송하는 객체 dispatcher를 생성.
			dispatcher = request.getRequestDispatcher("/WEB-INF/fs/result2.jsp");
			// 문자열 storeVO라는 key, storeVO라는 value로 지정한다.
			request.setAttribute("fsVO", fsVO);
		}catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('Edit Fail !');");
	        out.println("history.back();"); // 이전페이지로 이동
	        out.println("</script>");
	        out.close(); // 스트림 자원 반환
	        return;
		}
		dispatcher.forward(request, response);
		System.out.print("1111");
	}
}