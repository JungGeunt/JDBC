<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //로그아웃 처리는 세션의 삭제
    session.invalidate();
    response.sendRedirect("user_login.jsp");
    
    %>
