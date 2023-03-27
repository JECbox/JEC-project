package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBExpert;


@WebServlet("/getALLNotice.do")
public class GetAllNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAllNoticeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_num = request.getParameter("PAGE_NUM");
		DBExpert dbe = new DBExpert();
		int pageNum = 1;
		if(page_num != null) pageNum = Integer.parseInt(page_num);
		ArrayList<Notice> list = dbe.getAllNotice(pageNum);
		int bbsCount = dbe.getNoticeCount(); //상품.
		int pageCount = bbsCount / 5;
		if(bbsCount % 5 != 0) pageCount++;
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher
				("index.jsp?BODY=noticeList.jsp");
		
		rd.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
