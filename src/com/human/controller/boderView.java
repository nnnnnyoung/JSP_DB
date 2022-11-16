package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.BoardDAO;
import com.human.vo.BoardVO;

/**
 * Servlet implementation class boderView
 */
@WebServlet("/boderView")
public class boderView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDAO boardDAO=new BoardDAO()   ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boderView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String num=request.getParameter("wno");
		System.out.println("디버깅용도: "+num);
		
		BoardVO data=boardDAO.selectOne(num); //자세히보기 선택한 글 객체
		System.out.println("aaaa");
		String url="bbs/view.jsp";
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		request.setAttribute("board", data);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
