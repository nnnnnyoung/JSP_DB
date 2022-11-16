package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	public void insert(BoardVO boardvo) { //작성한 게시글을 DB에 저장
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
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("입력 실패");
			}
		}
	}
	
	   public ArrayList<BoardVO> selectAll(){
		      ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		      ArrayList<BoardVO> allList = new ArrayList<>();
		      if(connect()) {
		         try {
		            String sql="select * from bboard";  // 완성된쿼리
		            Statement stmt = conn.createStatement();
		            rs = stmt.executeQuery(sql);
		            while(rs.next()) {  // rs는 튜플을 통채로 가져온다.
		               BoardVO b = new BoardVO(); //튜플하나당 객체 한개 
		               b.setName(rs.getString("name"));
		               b.setCnt(rs.getInt("cnt"));
		               b.setContent(rs.getString("content"));
		               b.setEmail(rs.getString("email"));
		               b.setIndate(rs.getString("indate"));
		               b.setTitle(rs.getString("title"));
		               b.setNum(rs.getInt("num"));
		               allList.add(b);
		            }
		         } catch (Exception e) {
		            // TODO: handle exception
		         }
		         
		      }
		      return allList;
		      
		      
		   }

	   public BoardVO selectOne(String num){
	       ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
	         
	         if(connect()) {
	            try {
	               String sql="select * from bboard where num="+num;  // 완성된쿼리
	               Statement stmt = conn.createStatement();
	               rs = stmt.executeQuery(sql);
	               while(rs.next()) {  // rs는 튜플을 통채로 가져온다.
	                  BoardVO b = new BoardVO(); //튜플하나당 객체 한개 
	                  b.setName(rs.getString("name"));
	                  b.setCnt(rs.getInt("cnt"));
	                  b.setContent(rs.getString("content"));
	                  b.setEmail(rs.getString("email"));
	                  b.setIndate(rs.getString("indate"));
	                  b.setTitle(rs.getString("title"));
	                  b.setNum(rs.getInt("num"));
	                  return b;
	               }
	            } catch (Exception e) {
	               // TODO: handle exception
	            }
	            
	         }
	         return null;
	   }


}
