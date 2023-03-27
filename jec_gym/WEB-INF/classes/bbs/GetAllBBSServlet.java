package bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBExpert;


@WebServlet("/getALLBBS.do")
public class GetAllBBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAllBBSServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//myhome_bbs_tbl에서 조회를 한다.
		//조회결과를 bbsList.jsp로 전달한다.
		String page_num = request.getParameter("PAGE_NUM");
		DBExpert dbe = new DBExpert();
		int pageNum = 1;
		if(page_num != null) pageNum = Integer.parseInt(page_num);
		ArrayList<BBS> list = dbe.getAllBBS(pageNum);
		int bbsCount = dbe.getBBSCount();
		int pageCount = bbsCount / 5;
		if(bbsCount % 5 != 0) pageCount++;
		request.setAttribute("LIST", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher
				("index.jsp?BODY=bbsList.jsp");
		
		rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
