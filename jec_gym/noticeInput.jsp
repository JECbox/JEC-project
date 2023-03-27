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
<h2>공지사항 쓰기</h2>
<form action="noticePost.do" method="post" onsubmit="return check(this)">
	<table>
		<tr><th>제 목</th><td><input type="text" name="TITLE"></td></tr>
		<tr><th>내 용</th><td><textarea rows="6" cols="40" name="CONTENT"></textarea>
		</td></tr>
		<tr><td colspan="2"><input type="submit" value="등 록">
			<input type="reset" value="취소"></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(frm) {
	if(frm.TITLE.value == ''){
		alert("제목을 입력하세요"); frm.TITLE.focus(); return false;
	}else{
		if(frm.TITLE.value.length > 30){
			alert("제목은 30자 이내로 작성하세요"); frm.TITLE.focus(); return false;
		}
	}
	if(frm.CONTENT.value ==''){
		alert("내용을 입력하세요");frm.CONTENT.focus(); return false;
	}else{
		if(frm.CONTENT.value.length > 100){
			alert("내용은 100자 이내로 작성하시오."); frm.CONTENT.focus(); return false;
		}
	}
	if(! confirm("내용이 맞습니까?")) return false;
}
</script>
</body>
</html>