package notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBExpert;


@WebServlet("/noticeRead.do")
public class NoticeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NoticeReadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String seqno = request.getParameter("SEQNO");
			DBExpert dbe = new DBExpert(); //공지번호
			Notice bbs = dbe.getNotice(Integer.parseInt(seqno));
			request.setAttribute("NOTICE", bbs);
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("ADMIN");
			if(id != null && bbs.getId().equals(id)) {//작성자와 로그인 한 계정이 같은 경우
				RequestDispatcher rd = request.getRequestDispatcher
						("index.jsp?BODY=noticeDetailOwner.jsp");
				rd.forward(request, response);
			}else { //다른경우
				RequestDispatcher rd = request.getRequestDispatcher
						("index.jsp?BODY=noticeDetail.jsp");
				rd.forward(request, response);
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
