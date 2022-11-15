package com.human.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.BoardDAO;
import com.human.vo.BoardVO;

/**
 * Servlet implementation class wrAction
 */
@WebServlet("/wrAction")
public class wrAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wrAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//파라미터 받기
		
		BoardDAO boardDAO=new BoardDAO(); 
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		String name=(String) request.getParameter("name");
		String email=(String) request.getParameter("email");
		String title=(String) request.getParameter("title");
		String pass=(String) request.getParameter("pass");
		String content=(String) request.getParameter("content");
		
		System.out.println(name+"/"+email+"/"+title+"/"+pass+"/"+content);
		// DB insert 작업 추가해야 함 DAO와 DTO가 필요함
		BoardVO boardvo=new BoardVO();
		boardvo.setName(name);
		boardvo.setContent(content);
		boardvo.setEmail(email);
		boardvo.setPass(pass);
		boardvo.setTitle(title);
		
		boardDAO.insert(boardvo);
				
		response.sendRedirect("boardList"); //redirect
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
