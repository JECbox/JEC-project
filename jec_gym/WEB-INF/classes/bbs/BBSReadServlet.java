package bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBExpert;


@WebServlet("/bbsRead.do")
public class BBSReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BBSReadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno = request.getParameter("SEQNO");
		DBExpert dbe = new DBExpert();
		BBS bbs = dbe.getBBS(Integer.parseInt(seqno));
		request.setAttribute("BBS", bbs);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		if(id != null && bbs.getId().equals(id)) {//작성자와 로그인 한 계정이 같은 경우
			RequestDispatcher rd = request.getRequestDispatcher
					("index.jsp?BODY=bbsDetailOwner.jsp");
			rd.forward(request, response);
		}else { //다른경우
			RequestDispatcher rd = request.getRequestDispatcher
					("index.jsp?BODY=bbsDetail.jsp");
			rd.forward(request, response);
		}
		
	}

}
