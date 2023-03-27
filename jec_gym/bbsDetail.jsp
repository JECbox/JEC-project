<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${ empty BBS }">
	<h2>존재하지 않는 게시글입니다.</h2>
</c:if>
<c:if test="${ ! empty BBS }">
	<form action="bbsModify.do" method="post">
	<h2>게시글 상세</h2>
	<input type="hidden" name="SEQNO" value="${BBS.seqno }"/>
	<table>
		<tr>
		<th>글번호</th><td>${BBS.seqno }</td></tr>
		<tr><th>작성자</th><td>${BBS.id }</td></tr>
		<tr><th>제목</th><td>${BBS.title }</td></tr>
		<tr><th>작성일</th><td>${BBS.bbs_date }</td></tr>
		<tr><th>내용</th>
		<td><textarea readonly="readonly" rows="5" cols="40">${BBS.content }</textarea></td></tr>
		</table>
		</form>
</c:if>
</div>
</body>
</html>