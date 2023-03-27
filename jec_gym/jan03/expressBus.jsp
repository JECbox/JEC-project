<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int makeTotal2(String target, String seat, String num){
		int price = 0;
		if(seat.equals("0")){//좌석이 일반인 경우
			if(target.equals("1")){//대전
				price = 40000;
			}else if(target.equals("2")){//강릉
				price = 30000;
			}else if(target.equals("3")){//광주
				price = 45000;
			}else if(target.equals("4")){//대구
				price = 50000;
			}else if(target.equals("5")){//부산
				price = 55000;
			}
		}else{//좌석이 우등인 경우
			
			if(target.equals("1")){
				price = 43000;
			}else if(target.equals("2")){//강릉
				 price = 33000;
			}else if(target.equals("3")){//광주
				price =32000;
			}else if(target.equals("4")){//대구
				price =54000;
			}else if(target.equals("5")){//부산
				price = 60000;
			}
		}
		int number = Integer.parseInt(num);
		price = price * number;
		return price;
}
	int makeTotal(String target, String seat, String num){
	int numb = Integer.parseInt(num);
	int sea = Integer.parseInt(seat);
			int price = 0;
			if(sea == 0){
			switch(target){
			case "1": price = 40000; break;
			case "2": price = 30000;break;
			case "3": price = 45000;break;
			case "4": price = 50000;break;
			case "5": price = 55000;break;
			}
			int total = price * numb;
			return total;
			}else{
			switch(target){
			case "1": price = 43000;break;
			case "2": price = 32000;break;
			case "3": price = 48000;break;
			case "4": price = 55000;break;
			case "5": price = 60000;break;
			}
			int total =  price*numb;
			return total;
			
		}
		
}
	
%>
<%
	//num : 인원수 , seat : 우등 , target : 목적지
	String target = request.getParameter("TARGET");
	String seat = request.getParameter("SEAT");
	String num = request.getParameter("NUM");
	//일반:대전:40,000/강릉:30,000/광주:45,000
	//대구: 50,000/부산:55,000
	//우등: 대전:43,000/강릉:32,000/광주:48,000
	//대구: 54,000/부산:60,000
	int total = makeTotal2(target, seat, num);
	
	//response.sendRedirect("expressBusResult.jsp?TOTAL="+total);
	RequestDispatcher rd= request.getRequestDispatcher("expressBusResult.jsp?TOTAL="+total);
	rd.forward(request, response);
%>
</body>
</html>



















