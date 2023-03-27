package idcheck;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBExpert;


@WebServlet("/idCheck.do")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public IdcheckServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("USER_ID");
		DBExpert dbe = new DBExpert();
		String dup = dbe.selectId(user_id); //계정으로 검색
		//idCheck.jsp로 화면 전환 forward
		request.setAttribute("ID", user_id);
		request.setAttribute("DUP", dup);
		RequestDispatcher rd = request.getRequestDispatcher("idCheck.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
