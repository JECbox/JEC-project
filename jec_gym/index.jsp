<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	height: 100%
}
table#body{width: 80%; border-collapse: collapse; border: 1px solid blue;;
			margin-left: 20px; margin-right: 20px; background-color:gray;}
#Login {
	width: 100%; padding: 10px;
	margin-top: 10px; margin-left: 10px;
}
#menu {margin-top: 10px; margin-left: 10px; color: white;}
#content {background-color: gray; text-align: top;}
header, footer{background-color: black;}
td,th {border:1px solid black;
	background-color: bage;  
}
img {
	width: 400px;height: 100%;
}

</style>
</head>
<body>
<div align="center">
<header>
<h2><img alt="" src="img/img1.png"><img alt="" src="img/img2.png"><img alt="" src="img/img3.png"></h2>
</header>
<section>
<table id="body">
<tr>
	<td width="30%" height="300" valign="top">
		<div id="Login">
	<c:choose>
		<c:when test="${empty sessionScope.ADMIN  && empty sessionScope.USER}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="logout.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
		</div>
		<div id="menu" align="left">
		<a href="index.jsp?BODY=introGym.jsp">💪 JEC GYM 소개 💪</a><br><br>
		<a href="getALLNotice.do">💪 상품 보기 💪</a><br><br>
		<a href="getALLBBS.do"> 💪 리뷰 게시판 💪</a><br><br>
		
		<c:if test="${sessionScope.ADMIN != null }">
		<a href="index.jsp?BODY=noticeInput.jsp">💪 상품등록 💪</a><br><br>
		</c:if>
		<c:if test="${sessionScope.USER != null }">
		
		<a href="index.jsp?BODY=bbsInput.jsp">💪 리뷰 작성 게시판 💪</a><br>
		</c:if>
		</div>
	</td>
<%
	String content = request.getParameter("BODY");
%>
<%
	if(content != null){
%>
	<td id="content">
		<jsp:include page="<%=content %>"></jsp:include>
<%} %>
	</td>
</tr>
</table>
</section>
<footer>
<h3>JEC GYM Copyright.</h3>
</footer>
</div>
<c:if test="${param.NOLOGIN != null }">
  	<script type="text/javascript">
  		setTimeout(function(){
  			alert("게시글을 올리려면 로그인 하세요.");},100);
  	</script>
</c:if>
</body>
</html>















