package com.user.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user_login_ok")
public class user_login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public user_login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//form 태그로 부터 로그인 정보 전달 받음
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		
		//검증
		//System.out.println(id + ", " + pw );
		
//		//DB 접속을 위해서 필요한 변수 및 객체
//		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String user = "mytest";
//		String password ="mytest";
//		
//		Connection conn =null;
//		//preparedStatement
//		PreparedStatement pstmt = null;
//		ResultSet rs =null;
//	
//		//SQL 작성
//		String sql= "select *from testuser where id =? and pw = ?";
//		
//		try {
//			//1.Driver 로드
//			Class.forName(driver);
//			//2.Connection 객체 생성
//			conn = DriverManager.getConnection(url, user, password);
//			//3.PreparedStatement객체 생성
//			pstmt =conn.prepareStatement(sql);
//			//SQL실행
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			
//			//ResultSet 객체에 응답 내용을 담음
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()) {//아이디와 패스워드가 모두 일치하는 경우
//				//로그인, SQL로 얻은 정보를 통해서 Session을 생성
//				HttpSession session = request.getSession(); //세션 객체 생성
//				session.setAttribute("user_id", id); //세션객체 user_id에 id값을 저장
//				
//				//로그인 시 보여줄 페이지로 전환 (세션에 저장해서 센드리다이렉트사용가능)
//				response.sendRedirect("user_mypage.jsp");
//			}else {
//				//로그인 실패...
//				response.sendRedirect("user_login_fail.jsp");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null)conn.close();
//				if(pstmt != null)pstmt.close();
//				if(rs != null)rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
		//MemberDAo 객체 
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.login(id, pw);
		
		if(result == 1) {//로그인 성공
			HttpSession session = request.getSession(); //세션 객체 생성
			session.setAttribute("user_id", id); 		//세션객체 user_id에 id값을 저장			
			//로그인 시 보여줄 페이지로 전환 (세션에 저장해서 센드리다이렉트사용가능)
			response.sendRedirect("user_mypage.jsp");
			
		}else {//로그인 실패
			response.sendRedirect("user_login_fail.jsp");
		}
		
	}

}
