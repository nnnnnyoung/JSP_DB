package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.human.vo.BoardVO;

public class BoardDAO {
	private Connection conn;
	
	public BoardDAO(){
		//1. 드라이버 로드(한번만) 2. 커넥션 3.쿼리전송 4.리턴값 처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch(Exception e) {
			System.out.println("로드실패");
		}
		
	}
	
	public boolean connect() { // 
		try {
			// 커넥션을 시도하고 그 결과를 얻어 오는 코드... 
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public void insert(BoardVO boardvo) {
		if(connect()) {
			String sql="insert into bboard values (board_cnt.nextval,?,?,?,?,?,default,default)";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, boardvo.getName());
				psmt.setString(2, boardvo.getEmail());
				psmt.setString(3, boardvo.getTitle());
				psmt.setString(4, boardvo.getContent());
				psmt.setString(5, boardvo.getPass());
				int r=psmt.executeUpdate();
				System.out.println("입력 성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("입력 실패");
			}
		}
	}
}
