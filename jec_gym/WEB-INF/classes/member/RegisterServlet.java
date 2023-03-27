package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBExpert;


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("NAME");
		String id = request.getParameter("USER_ID");
		String addr = request.getParameter("ADDR");
		String phone = request.getParameter("PHONE");
		String pwd = request.getParameter("USER_PWD");
		String gender = request.getParameter("GENDER");
		String email = request.getParameter("EMAIL");
		String job = request.getParameter("JOB");
		
	//강사님께 질문
		Member member = new Member();
		member.setName(name); member.setId(id);
		member.setPhone(phone); member.setPwd(pwd);
		member.setGender(gender); member.setEmail(email);
		member.setJob(job);
		DBExpert dbe = new DBExpert();
		String result = dbe.register(member);
		//userEntryResult.jsp로 화면 전환
		response.sendRedirect("index.jsp?BODY=userEntryResult.jsp?R="+result);
	}

}
