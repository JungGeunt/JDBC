package com.user.ok;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user_update_ok")
public class user_update_ok extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public user_update_ok() {
        super();

    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // form 데이터 처리
      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String name = request.getParameter("name");
      String phone1 = request.getParameter("phone1");
      String phone2 = request.getParameter("phone2");
      String gender = request.getParameter("gender");
      
      
      MemberDAO dao = MemberDAO.getInstance();
      MemberVO vo =new MemberVO(id, pw, name, phone1, phone2, gender);
      
      int result=dao.Update(vo);
      
      if(result ==1) {
        PrintWriter out = response.getWriter();
        out.println("<script>"
              + "alert('success');"
             + "location.href='user_mypage.jsp';"
              + "</script>");
     } else {
        PrintWriter out = response.getWriter();
        out.println("<script>"
              + "alert('fail');"
              + "history.go(-1);" //user_update.jsp로 이동
              + "</script>");
        response.sendRedirect("user_update.jsp");
     }
      
//      System.out.println(id + ", " + name + ", " + phone1 + ", " + phone2 + ", " + gender);
//      
//      // DB연동을 위한 변수 및 객체 선언
//      String url = "jdbc.mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//      String driver = "com.mysql.cj.jdbc.Driver";
//      String user = "mytest";
//      String pw = "mytest";
//      
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      
//      String sql = "update testuser set pw=?, name=?, phone1=?, phone2=?, gender=? where id=?";
//      
//   try {
//      Class.forName(driver);
//      conn = DriverManager.getConnection(url, user, pw);
//      pstmt = conn.prepareStatement(sql);
//      pstmt.setString(1, pw);
//      pstmt.setString(2, name);
//      pstmt.setString(3, phone1);
//      pstmt.setString(4, phone2);
//      pstmt.setString(5, gender);
//      pstmt.setString(6, id);
//      
//      
//      int result = pstmt.executeUpdate();
//      if(result ==1) {
//         PrintWriter out = response.getWriter();
//         out.println("<script>"
//               + "alert('success');"
//               + "location.href='user_mypage.jsp';"
//               + "</script>");
//      } else {
//         PrintWriter out = response.getWriter();
//         out.println("<script>"
//               + "alert('fail');"
//               + "history.go(-1);" //user_update.jsp로 이동
//               + "</script>");
//         response.sendRedirect("user_update.jsp");
//      }
//    
//      
//   } catch (Exception e) {
//      e.printStackTrace();
//   } finally {
//      try {
//      if(conn!=null) conn.close();
//      if(pstmt!=null) pstmt.close();
//      } catch (Exception e2) {
//         e2.printStackTrace();
//      }
//   }
      
      
      
  }
}