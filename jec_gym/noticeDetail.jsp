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
<c:if test="${ empty NOTICE }">
	<h2>존재하지 않는 게시글입니다.</h2>
</c:if>
<c:if test="${ ! empty NOTICE }">
	<form action="noticeModify.do" method="post">
	<h2>게시글 상세</h2>
	<input type="hidden" name="SEQNO" value="${NOTICE.seqno }"/>
	<table>
		<tr>
		<th>글번호</th><td>${NOTICE.seqno }</td></tr>
		<tr><th>작성자</th><td>${NOTICE.id }</td></tr>
		<tr><th>제목</th><td>${NOTICE.title }</td></tr>
		<tr><th>작성일</th><td>${NOTICE.notice_date }</td></tr>
		<tr><th>내용</th>
		<td><textarea readonly="readonly" rows="5" cols="40">${NOTICE.content }</textarea></td></tr>
		</table>
		</form>
</c:if>
</div>
</body>
</html>