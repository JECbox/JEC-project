<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="left">
<a href="index.jsp?BODY=userEntry.jsp">가입하기</a>
<form action="Login.doo" method="post" onsubmit="return check(this)">
계 정 : <input type="text" name="ID" size="10"><br/>
암 호 : <input type="password" name="PWD" size="10"><br/>
<input type="submit" value="login"/>
<input type="reset" value="cancel"/>
</form>
<script type="text/javascript">
function check(frm) {
	if(frm.ID.value == ''){
		alert("계정을 입력하세요.");frm.ID,focus(); return false;
	}
	if(frm.PWD.value == ''){
		alert("암호를 입력하세요."); frm.PWD.focus(); return false;
	}
}
</script>
</div>
</body>
</html>