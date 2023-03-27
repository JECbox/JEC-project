<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="bbsInput.do" onsubmit="return check(this)" method="post">
리뷰 제목 : <input type="text" name="TITLE"><br>
리뷰 내용 :<textarea rows="5" cols="40" name="CONTENT"></textarea><br>
<input type="submit" value="작 성">
<input type="reset" value="취 소">
</form>
</div>
<script type="text/javascript">
function check(frm) {
	if(frm.TITLE.value ==''){
		alert("insert name."); frm.TITLE.focus();
		
	}else{
		if(frm.TITLE.value.length > 30){
			alert("30자 이내로 작성하세요.") frm.TITLE.focus(); return false;
		}
	}
	if(frm.CONTENT.value ==''){
		alert("insert."); frm.CONTENT.focus(); return false;
		
	}else{
		if(frm.CONTENT.value.length > 100){
			alert("100자 이내로 작성하세요."); frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("is that right?")) return false;
}
</script>
</body>
</html>