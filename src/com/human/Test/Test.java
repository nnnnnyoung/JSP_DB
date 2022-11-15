package com.human.Test;

import com.human.dao.BoardDAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO BDAO=new BoardDAO();
		boolean a=BDAO.connect();
		System.out.println(a);
		
	}

}
