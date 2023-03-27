package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBExpert;


@WebServlet("/bbsModify.do")
public class BBSModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("BTN");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		String seqno = request.getParameter("SEQNO");
		String result = "";
		DBExpert dbe = new DBExpert();
		if(btn.equals("삭제")) {
			result = dbe.deleteBBS(Integer.parseInt(seqno));
		}else if(btn.equals("수정")) {
			BBS bbs  =new BBS();
			bbs.setSeqno(Integer.parseInt(seqno));
			bbs.setTitle(title);
			bbs.setContent(content);
			result = dbe.updateBBS(bbs);
		}
		response.sendRedirect("index.jsp?BODY=bbsModifyResult.jsp?R="+result);
	}

}















