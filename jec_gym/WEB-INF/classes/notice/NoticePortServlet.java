package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBExpert;


@WebServlet("/noticePost.do")
public class NoticePortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticePortServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ADMIN");
		DBExpert dbe = new DBExpert();
		int seqno = dbe.getMaxNotice()+1;
		Notice notice = new Notice();
		notice.setSeqno(seqno); notice.setId(id);
		notice.setTitle(title); notice.setContent(content);
		String result = dbe.insertNotice(notice);
		//resutl.jsp로 화면 전환
		response.sendRedirect("index.jsp?BODY=noticeInputResult.jsp?R="+result);
	}

}
