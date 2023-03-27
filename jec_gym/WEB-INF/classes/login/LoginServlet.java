package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBExpert;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.doo")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		DBExpert dbe = new DBExpert();
		String result = dbe.loginCheck(id,pwd);
		if(result.equals("OK")) {
			System.out.println("check");
			HttpSession session = request.getSession();
			if(id.equals("admin")) {
				session.setAttribute("ADMIN", id);
			}else {
				session.setAttribute("USER", id);
			}
			System.out.println(result);
			response.sendRedirect("index.jsp?BODY=loginResult.jsp?R="+result);
		}else {
			response.sendRedirect("index.jsp?BODY=loginResult.jsp?R=NOK");	
		}
	}

}
