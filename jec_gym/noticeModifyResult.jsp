<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.R == 'OK' }">
<script type="text/javascript">
	setTimeout(function () {
		alert("작업이 완료되었습니다");
	},100);
</script>
<c:if test="${param.R == 'NOK' }">
 	<script type="text/javascript">
 	setTimeout(function () {
		alert("작업이 완료되지 않았습니다.");
	},100);
 	</script>
</c:if>
</c:if>
</body>
</html>