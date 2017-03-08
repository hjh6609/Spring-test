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

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/sample")
public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher
		 = request.getRequestDispatcher("/WEB-INF/sample2016.jsp");
		
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++){
			list.add("Hello " + i);
		}
		
		request.setAttribute("message", "Hello SulHyun");
		request.setAttribute("list", list);
		
		dispatcher.forward(request, response);
		
	}

}




