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
	<h2>등록된 게시글이 존재하지 않습니다.</h2>
</c:if>
<c:if test="${! empty LIST }">
	<h2>게시글목록</h2>
	<table>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach items="${LIST }" var="bbs">
	<tr><td>${bbs.seqno }</td>
		<td><a href="bbsRead.do?SEQNO=${bbs.seqno }"> ${bbs.title }</a></td>
		<!-- 글번호 보내기' -->
		<td>${bbs.id }</td>
		<td>${bbs.bbs_date }</td>
	</tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="getALLBBS.do?PAGE_NUM=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>  