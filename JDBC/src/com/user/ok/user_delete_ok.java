package com.user.ok;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/user_delete_ok")
public class user_delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public user_delete_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * sql->delete form testuser where id= ?;
		 * 1.아이디는 세션에서 얻는다.
		 * 2.pstmt를 이용해서 삭제 진행
		 * 3. excuteUpdate()실행 후 반환 값 확인
		 *  1. 이면 성공. 세션 전부 삭제 후 user-login.jsp 이동
		 *  0. 이면 실패. user_mypage.jsp 이동
		 */
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("user_id");
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.delete(id);
		if(result==1) {
			session.invalidate();
			PrintWriter out =response.getWriter();
			out.println("<script>"
					+"alert('success');"
					+"location.href='user_login.jsp';"
					+"</script>");
		}else {
			PrintWriter out =response.getWriter();
			out.println("<script>"
					+"alert('fail');"
					+"location.href='user_mypage.jsp';"
					+"</script>");
		}
		
//		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String user = "mytest";
//		String password ="mytest";
//		
//		Connection conn =null;
//		PreparedStatement pstmt =null;
//		String sql= "delete from testuser where id=?";
//		try {
//			Class.forName(driver);
//			conn=DriverManager.getConnection(url, user, password);
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			int result =pstmt.executeUpdate();
//			
//			if(result==1) {
//				session.invalidate();
//				PrintWriter out =response.getWriter();
//				out.println("<script>"
//						+"alert('success');"
//						+"location.href='user_login.jsp';"
//						+"</script>");
//			}else {
//				PrintWriter out =response.getWriter();
//				out.println("<script>"
//						+"alert('fail');"
//						+"location.href='user_mypage.jsp';"
//						+"</script>");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null)conn.close();
//				if(pstmt != null)pstmt.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
