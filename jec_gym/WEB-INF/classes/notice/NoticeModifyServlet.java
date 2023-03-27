package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BBS;
import util.DBExpert;


@WebServlet("/noticeModify.do")
public class NoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public NoticeModifyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String btn = request.getParameter("BTN");
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			String seqno = request.getParameter("SEQNO");
			System.out.println("seqno:"+seqno);
			String result = "";
			DBExpert dbe = new DBExpert();
			if(btn.equals("삭제")) {
				result = dbe.deleteNotice(Integer.parseInt(seqno));
			}else if(btn.equals("수정")) {
				Notice bbs  =new Notice();
				bbs.setSeqno(Integer.parseInt(seqno));
				bbs.setTitle(title);
				bbs.setContent(content);
				result = dbe.updateNotice(bbs);
			}
			response.sendRedirect("index.jsp?BODY=noticeModifyResult.jsp?R="+result);
		
	}

}
