package com.user.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user_modify_ok")
public class user_modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public user_modify_ok() {
        super(); 
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//정보 수정 페이지로 이동하기 위한DB에서 정보를 얻어오는 작업
		//DB에서 가져올 정보는 session에서 id값을 얻어서 사용
		//입력 값을 받아서 사용하는 것이 아니라 get을 사용하셨다고 말하심
		HttpSession session =request.getSession(); //세션생성
		String id =(String)session.getAttribute("user_id");

		//DAO 객체 
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getInfo(id);
		
		System.out.println(vo);
		
		//강제 저장
		request.setAttribute("vo", vo);
		//request에 강제 저장 및 포워드...
		request.setAttribute("user_name", vo.getName());
		request.setAttribute("user_pw", vo.getPw());
		request.setAttribute("user_phone1", vo.getPhone1());
		request.setAttribute("user_phone2", vo.getPhone2());
		request.setAttribute("user_gender", vo.getGender());
		
		
		request.getRequestDispatcher("user_update.jsp").forward(request, response);
		
		}
		
//		
//		//DB연동을 위한 변수 및 객체 선언
//		String url="jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String user = "mytest";
//        String password = "mytest";
//        
//        Connection conn =null;
//        PreparedStatement pstmt= null;
//        ResultSet rs = null;
//        
//        //DB에 전달한 SQL 작성
//        String sql = "select * from testuser where id =?";
//        
//        try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt= conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs=pstmt.executeQuery();
//        	
//			/*
//			 * rs.next()결과 값을 조회
//			 * rs.getString(컬럼명)을 통해서 값을 얻어옴...name, phone1, phone2, gender
//			 * request 강제 저장한 후에 포워드 처리 ... update.jsp전달...
//			 */
//			if(rs.next()) {
//				String name = rs.getString("name");
//				String pw = rs.getString("pw");
//				String phone1 = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String gender = rs.getString("gender");
//				
//				//request에 강제 저장 및 포워드...
//				request.setAttribute("user_name", name);
//				request.setAttribute("user_pw", pw);
//				request.setAttribute("user_phone1", phone1);
//				request.setAttribute("user_phone2", phone2);
//				request.setAttribute("user_gender", gender);
//				
//				//검증...
//				System.out.println(id +", "+pw +", "+name+","+phone1+","+phone2+","+gender);
//				
//				RequestDispatcher dp = request.getRequestDispatcher("user_update.jsp");
//				dp.forward(request, response);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn!=null)conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs !=null)rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
		
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
