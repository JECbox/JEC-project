package bbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBExpert;


@WebServlet("/bbsInput.do")
public class BBSInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BBSInputServlet() {
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
	String id = (String)session.getAttribute("USER");
	
	if( id == null ) { //로그인 안 함
		//로그인 화면을 출력한다.
		response.sendRedirect("index.jsp?NOLOGIN=YES");
	}else {//로그인 함
		//게시글 정보를 db에 삽입
		BBS bbs = new BBS();
		DBExpert dbe = new DBExpert();
		int seqno = dbe.getMaxSeqno() + 1;
		bbs.setSeqno(seqno); //글번호
		bbs.setTitle(title);
		bbs.setContent(content);
		bbs.setId(id);
		String result = dbe.insertBBS(bbs); //게시글 등록
		response.sendRedirect("index.jsp?BODY=bbsResult.jsp?R="+result);
		
	}
  }
}






















