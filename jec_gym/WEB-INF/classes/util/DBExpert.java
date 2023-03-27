  package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bbs.BBS;
import member.Member;
import notice.Notice;

public class DBExpert {
	Connection con; PreparedStatement pstmt; Statement stmt;
	ResultSet rs;
	//공지수정
	public String updateNotice(Notice bbs) {
		
		String result = "";
		String update = "update jec_notice set title=?,content=? where seqno =?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getContent());
			pstmt.setInt(3, bbs.getSeqno());
			pstmt.executeUpdate();
			result = "OK";
		}catch(Exception e) {
			e.printStackTrace();
			result ="NOK";
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//수정
	public String updateBBS(BBS bbs) {
		String result = "";
		String update = "update jec_bbs set title=?,content=? where seqno =?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getContent());
			pstmt.setInt(3, bbs.getSeqno());
			pstmt.executeUpdate();
			result = "OK";
			
			
		}catch(Exception e) {
			result ="NOK";
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		
		return result;
	}
	//상품삭제
	public String deleteNotice(int seqno) {
		String result = ""; //삭제결과 저장
		String delete = "delete from jec_notice where seqno=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			result = "OK";
		}catch(Exception e) {
			result = "NOK"; 
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e) {}
	}
		return result;
	}
	
	//삭제
	public String deleteBBS(int seqno) {
		String result = ""; //삭제결과 저장
		String delete = "delete from jec_bbs where seqno=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			result = "OK";
		}catch(Exception e) {
			result = "NOK"; 
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e) {}
	}
		return result;
		
	}
	
	//글번호
	public BBS getBBS(int seqno) {
		BBS bbs = null;//조회결과저장
		String select = "select seqno,title,id,content,to_char(bbs_date, 'YY/MM/DD') from jec_bbs where seqno = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);//첫물음표 글번호설정
			rs = pstmt.executeQuery();//실행
			if(rs.next()) {
				bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setId(rs.getString(3));
				bbs.setContent(rs.getString(4));
				bbs.setBbs_date(rs.getString(5));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
				
		}
		return bbs;
	}
	//공지 수
	public int getNoticeCount() {
		int count = -1; //결과저장
		String select = "select count(*) from jec_notice";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
					pstmt = con.prepareStatement(select);
					rs= pstmt.executeQuery();
					if(rs.next()) {
						count = rs.getInt(1);
					}else {
						count = 0;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(con != null) con.close();
						
					}catch(Exception e) {}
				}
				return count;
	}
	//	상품상세조회
	public Notice getNotice(int seqno) {
		Notice bbs = null;//조회결과저장
		String select = "select seqno,title,id,content,to_char(notice_date, 'YY/MM/DD') "
						+ "from jec_notice where seqno = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);//첫물음표 글번호설정
			rs = pstmt.executeQuery();//실행
			if(rs.next()) {
				bbs = new Notice();
				bbs.setSeqno(rs.getInt(1)); //셀렉트 첫번째 항목 저장
				bbs.setTitle(rs.getString(2));
				bbs.setId(rs.getString(3));
				bbs.setContent(rs.getString(4));
				bbs.setNotice_date(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
				
		}
		return bbs;
	}
	
	public int getBBSCount() {
		int count = -1; //결과저장
		String select = "select count(*) from jec_bbs";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
					pstmt = con.prepareStatement(select);
					rs= pstmt.executeQuery();
					if(rs.next()) {
						count = rs.getInt(1);
					}else {
						count = 0;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(con != null) con.close();
						
					}catch(Exception e) {}
				}
				return count;
	}
	//상품 조회
	public ArrayList<Notice> getAllNotice(int pageNo){
		String select = "select seqno,title,id, input_date "
				+ "from  (select rownum rn,seqno,title,id,to_char(notice_date,'YY/MM/DD') input_date "
				+ "from jec_notice order by seqno desc) "
				+ "where  rn > ? and rn < ?";
		int from = (pageNo - 1)*5;	int to = ((pageNo - 1)*5)+6;
		ArrayList<Notice> al = new ArrayList<Notice>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, from); pstmt.setInt(2, to);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice bbs = new Notice();
				bbs.setSeqno(rs.getInt(1));//첫번째 조회결과를 seqno에 저장
				bbs.setTitle(rs.getString(2));//두번째 조회결과를 title에 저장
				bbs.setId(rs.getString(3));//세번째 조회결과를 id에 저장
				bbs.setNotice_date(rs.getString(4));//네번째 조회결과를 bbs_date에 저장
				al.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		return al;
	}
	
	//조회
	public ArrayList<BBS> getAllBBS(int pageNo){
//		String select = "select seqno,title,id,to_char(bbs_date,'YY/MM/DD') "
//				+ "from myhome_bbs_tbl order by seqno desc";
		String select = "select seqno,title,id, input_date "
				+ "from  (select rownum rn,seqno,title,id,to_char(bbs_date,'YY/MM/DD') input_date "
				+ "from jec_bbs order by seqno desc) "
				+ "where  rn > ? and rn < ?";
		int from = (pageNo - 1)*5;	
		int to = ((pageNo - 1)*5)+6;
		ArrayList<BBS> al = new ArrayList<BBS>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, from); 
			pstmt.setInt(2, to);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BBS bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));//첫번째 조회결과를 seqno에 저장
				bbs.setTitle(rs.getString(2));//두번째 조회결과를 title에 저장
				bbs.setId(rs.getString(3));//세번째 조회결과를 id에 저장
				bbs.setBbs_date(rs.getString(4));//네번째 조회결과를 bbs_date에 저장
				al.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		return al;
	}
	
	//상품작성
	public String insertNotice(Notice notice) {
		String result = "";
		String insert = "insert into jec_notice values(?,?,?,?,sysdate)";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, notice.getSeqno());
			pstmt.setString(2, notice.getTitle());
			pstmt.setString(3, notice.getId());
			pstmt.setString(4, notice.getContent());
			pstmt.executeUpdate();
			result = "OK";
			
		}catch(Exception e) {
			result = "NOK";
		}finally {
		try {
			 if(pstmt != null) pstmt.close();
			  if(con != null) con.close();
		}catch(Exception e) {}
	}
		return result;
	}
	
	 
	//게시판
	public int getMaxNotice() {
		int result = -99;
		String select = "select max(seqno) from jec_notice";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}else {
				result =0;
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
	//회원가입
	public String register(Member member) {
		String result = "";
		String insert = "insert into jec_gym values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1,member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getJob());
			pstmt.executeUpdate();
		 
			result = "OK";
		}catch(Exception e) {
			result = "NOK";
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null ) con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public String selectId(String id) {
		String result = null; //조회결과 저장용 변수
		String select = "select id from jec_gym where id=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //select실행
			if(rs.next()) {
				result = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public String loginCheck(String id, String pwd) {
		String result = ""; //조회결과 저장변수
		String select = "select pwd from jec_gym where id=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			String password = "";
			if(rs.next()) {
				password = rs.getString(1); //조회결과를 패스워드에 ㄷ저장
				if(pwd.equals(password)) { //입력한 암호화 조회한 암호가 일치하는 경우
					result = "OK";
				}else {
					System.out.println("1");
					result = "NOK"; //계정은 존재하지만 암호가 일치하지 않는 경우
				}
			}else { //조회결가 존재하지 않는 경우
				System.out.println("2");

				result = "NOK"; //계정이 존재하지 않는 경
				}
		}catch(Exception e){
			e.printStackTrace();
			result = "NOK";
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//defalut = 같은 폴더에서만 공개
	public String insertBBS(BBS bbs) { //diffrent folder
		String insert="insert into jec_bbs values(?,?,?,?,sysdate)";
		String result = "";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno());
			pstmt.setString(2, bbs.getTitle());
			pstmt.setString(3, bbs.getId());
			pstmt.setString(4, bbs.getContent());
			
			pstmt.executeUpdate();
			result = "OK";
		}catch(Exception e) {
			result = "NOK";
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}
				
		}
		return result;
	}
	
	//가장 큰 글번호를 검색하는 메소드 (return)
	public int getMaxSeqno() {
		String select= "select max(seqno) from jec_bbs";
		int maxSeqno = -1;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/XE","hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			//삽입,삭제,변경 : executeUpdate()
			//조회 : executeQuery()
			if(rs.next()) {
				maxSeqno = rs.getInt(1); //1 : select 항목의 순서
			}else {
				maxSeqno = 0;
				
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				
			}finally {
				
			}
		}
		return maxSeqno;
	}
}
