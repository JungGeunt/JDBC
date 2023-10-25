
<%@page import="com.user.ok.MemberVO"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String id = (String)session.getAttribute("user_id");
      
    
    %>
<%
//id는 세션을 통해서 얻음
	
	//회원정보는 request를 통해서 얻음
	/*
	String pw = (String)request.getAttribute("user_pw");
	String name = (String)request.getAttribute("user_name");
	String phone1 = (String)request.getAttribute("user_phone1");
	String phone2 = (String)request.getAttribute("user_phone2");
	String gender = (String)request.getAttribute("user_gender");
	
	System.out.println(id +", "+pw +", "+name+","+phone1+","+phone2+","+gender);
	*/
%>        
