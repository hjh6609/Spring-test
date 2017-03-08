package org.zerock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.FoodStore;
import org.zerock.service.FoodStoreService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/fs/model2_view")
public class ViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private FoodStoreService service;

	public ViewController() {
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
		
		// 각 번호의 content를 불러온다.
		List<FoodStore> fsList = new ArrayList<>();
		try {
			fsList = service.getView(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fs/model2_view.jsp");
		
		
		request.setAttribute("view", fsList);
		dispatcher.forward(request, response);
		
	}// doGet()

}
