package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.BoardDAO;
import com.human.vo.BoardVO;

/**
 * Servlet implementation class boardList
 */
@WebServlet("/boardList")
public class boardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardDAO boardDAO=new BoardDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 데이터베이스 접근... 후 자료 받아오기
		//포워딩
		ArrayList<BoardVO> a=new ArrayList<>(); //a변수는 select* from bboard 결과에 의한 튜플을 저장하고 있다.
		//DB작업을 위해서는 dao객체가 필요
		a=boardDAO.selectAll();
		String url="bbs/list.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		request.setAttribute("bList", a);
		dispatcher.forward(request, response);
		System.out.println(a.size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
