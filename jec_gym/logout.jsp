<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 	String admin = (String)session.getAttribute("ADMIN");
	String user = (String)session.getAttribute("USER");
	String id = "";
	if(admin != null){
		id = admin;
		
	}else if(user != null){
		id = user;
	}
%>
<form action="Logout.do">
안녕하세요 <%= id %>님<br>

<br/>
<input type="submit" value="logout"/>
</form>
</body>
</html>