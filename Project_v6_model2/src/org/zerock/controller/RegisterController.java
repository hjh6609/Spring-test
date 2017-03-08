package org.zerock.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.zerock.domain.FoodStore;
import org.zerock.service.FoodStoreService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/fs/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegisterController.class);

	private FoodStoreService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		service = new FoodStoreService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	// 클라이언트가 맨 처음 /fs/register의 uri로 요청하면 get방식으로 날아오는 것이기 때문에
	// 이 doGet()메소드가 호출된다. 그러면 단지 입력화면인 register.jsp를 띄워주면된다.
			
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fs/register.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("do Post called");

		// post방식에서 한글깨짐 현상은 다음과 같이 encoding방식을 UTF-8로 setting해준다.
		request.setCharacterEncoding("UTF-8");

		// register.jsp에서 보낸 request로 부터 전달된 파라미터를 읽어내서 이를 기반으로
		// FoodStore타입 VO를 만들어준다. 이 VO를 FoodStoreService의 register메소드의 인자로 넘겨서
		// 추가시켜준다.
		// 이때 추가에 성공하면 result.jsp를 호출하고, 실패하면 error.jsp를 호출한다.
		// servlet에서 jsp를 호출할때 RequestDispatcher 클래스를 사용한다.
		RequestDispatcher dispatcher = null;
		FoodStore fsVO = new FoodStore();
		
		fsVO.setUsername(request.getParameter("username"));
		fsVO.setTitle(request.getParameter("title"));
		fsVO.setContent(request.getParameter("content"));
		fsVO.setPwd( Integer.parseInt(request.getParameter("pwd") ) );

		try {
			// VO를 서비스로 보내 게시물 리스트에 등록하도록 한다.
			service.register(fsVO);

			// register.jsp로부터의 요청을 수신하고, result.jsp에 전송하는 객체 dispatcher를 생성.
			dispatcher = request.getRequestDispatcher("/WEB-INF/fs/result.jsp");

			// 문자열 storeVO라는 key, storeVO라는 value로 지정한다.
			request.setAttribute("fsVO", fsVO);

		} catch (Exception e) {
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher("/WEB-INF/sample.jsp");
		} // catch()
		
		// 맛집추가에 성공했을 시에 result.jsp에 서블릿의 요청을 전송하고,
		// 실패했을 시에 error.jsp에 서블릿의 요청을 전송한다.
		dispatcher.forward(request, response);

	}// doPost()

}// class
