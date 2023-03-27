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
<c:if test="${ empty LIST }">
	<h2>상품이 존재하지 않습니다.</h2>
</c:if>
<c:if test="${! empty LIST }">
	<h2>상품 목록</h2>
	<table>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach items="${LIST }" var="notice">
	<tr><td>${notice.seqno }</td>
		<td><a href="noticeRead.do?SEQNO=${notice.seqno }"> ${notice.title }</a></td>
		<!-- 글번호 보내기' -->
		<td>${notice.id }</td>
		<td>${notice.notice_date }</td>
	</tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="notice">
		<a href="getALLNotice.do?PAGE_NUM=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>  