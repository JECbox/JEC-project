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

<c:if test="${param.R == 'OK' }">
	<script type="text/javascript">
		setTimeout(function () {
			alert("로그인 되었습니다.");
		},100);	 
		</script>
</c:if>



<c:if test="${param.R == 'NOK' }">
	<script type="text/javascript">
	setTimeout(function () {
		alert("로그인 되지않았습니다. 계정과 암호를 확인하세요");
	},100);		
	</script>
</c:if>
</body>
</html>