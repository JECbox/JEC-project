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
	<h2>게시글 상세</h2>
	<form action="noticeModify.do" method="post" onsubmit="return check()">
	<input type="hidden" name="SEQNO" value="${NOTICE.seqno }">
	<table>
		<tr>
		 <th>글번호</th><td>${NOTICE.seqno }</td>
		</tr>
		<tr><th>작성자</th><td>${NOTICE.id }</td></tr>
		<tr><th>제목</th><td><input type="text" name="TITLE" value="${NOTICE.title }"></td></tr>
		<tr><th>작성일</th><td>${NOTICE.notice_date }</td></tr>
		<tr><th>내용</th>
		<td><textarea rows="5" cols="40" name="CONTENT">${NOTICE.content }</textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="수정" name="BTN"/>
			<input type="submit" value="삭제" name="BTN">
		</td></tr>
	</table>
	</form>
</c:if>

</div>
<script type="text/javascript">
function check() {
	if(! confirm("작업을 진행 하시겠습니까?")) return false;
}
</script>
</body>
</html>