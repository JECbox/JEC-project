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
<h2>JEC_GYM 회원가입</h2>
<form action="register.do" method="post" name="frm" onsubmit="return check(this)">
<input type="hidden" name="idChecked">
이 름: <input type="text" name="NAME" size="20"><br>
계 정: <input type="text" name="USER_ID" size="5">
		<input type="button" value="중복검사" onclick="idCheck()"><br>
주 소: <input type="text" name="ADDR" size="30"><br>
연락처:<input type="text" name="PHONE" size="10"><br>
암 호:<input type="password" name="USER_PWD" size="10"><br>
암호 확인:<input type="password" name="CONFIRM" size="10"><br>
성 별 : M<input type="radio" name="GENDER" value="M">
W<input type="radio"name="GENDER" value="W"><br>
이메일: <input type="text" name="EMAIL" size="20"> @ <select>
												<option>naver.com</option>
												<option>daum.net</option>
												<option>yahoo.com</option>
												<option>gmail.com</option>
												</select><br>
직 업:<select name="JOB">
	<option>normal</option>
	<option>trainer</option>
	<option>student</option>
	<option>main</option>
	</select><br><br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">

</form>
</div>
<script type="text/javascript">
function idCheck() {
	if(document.frm.USER_ID.value == ''){
		alert("계정을 입력하세요"); 	document.frm.USER_ID.focus(); return;
	}
	var url = "idCheck.do?USER_ID="+document.frm.USER_ID.value;
	window.open(url,"_blank_","width=650,height=200"); //창의 내용, 창의 이름, 창의 가로세로크기 .open
}
function check(frm) {
	if (frm.NAME.value=='') {
		alert("이름을 입력하세요.");frm.NAME.focus(); return false;
	}
	if (frm.idCheckd.value == '') {
		alert("계정 중복 검사를 해주세요."); return false;
		
	}
	if(frm.USER_ID.value == ''){
		alert("계정을 입력하세요."); frm.USER_ID.focus(); return false;
	}
	if(frm.PHONE.value == ''){
		alert("연락처를 입력하세요"); frm.PHONE.focus(); return false;
	}
	if (frm.USER_PWD.value == '') {
		alert("암호를 입력하세요"); frm.USER_PWD.focus(); return false;
	}
	if(frm.USER_PWD.value != frm.CONFRIM.value){
		alert("암호가 일치하지 않습니다."); frm.USER_PWD.focus(); return false;
	}
	if ( !frm.GENDER[0].checked && !frm.GENDER[1].checked) {
		alert("성별을 입력하세요."); frm.GENDER[0].focus(); return false;
	}
	if(! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>

</body>
</html>