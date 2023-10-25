<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	//세션을 이용해서 인증되지 않은 사람들은 login페이지로 리다이렉트
 	if(session.getAttribute("user_id")==null ){
 		response.sendRedirect("user_login.jsp");
 	}
 	String id =(String)session.getAttribute("user_id");
 %>   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2><%=id %>님 환영합니다.</h2>
		<a href="user_logout.jsp">로그아웃</a>
		<a href="user_modify_ok">정보수정</a>
		<a href="user_delete_ok">회원탈퇴</a>
	</body>
</html>