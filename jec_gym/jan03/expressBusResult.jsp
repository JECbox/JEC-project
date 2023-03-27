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
	String total = request.getParameter("TOTAL");
	int tot = Integer.parseInt(total);
%>
<div align="center">
	<table border="1">
	<tr><td><h2 align="center">총액: <%=tot %></h2></td></tr>
	
	</table>
	</div>
	
</body>
</html>