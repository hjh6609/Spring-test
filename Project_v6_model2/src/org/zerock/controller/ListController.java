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
@WebServlet("/fs/list")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FoodStoreService service;

	public ListController() {
		super();
		service = new FoodStoreService();
	}// Constructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서비스로부터 게시글 리스트를 받아온다.
		List<FoodStore> fsList = new ArrayList<>();
		try {
			fsList = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 이후 list.jsp로 요청을 전송한다. 이때 맛집리스트 fsList를 키값 "list"로 지정해준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fs/list.jsp");

		request.setAttribute("list", fsList);
		dispatcher.forward(request, response);

	}// doGet()

}
