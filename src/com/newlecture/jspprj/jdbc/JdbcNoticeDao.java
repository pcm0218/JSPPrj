package com.newlecture.jspprj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.PageContext;

import com.newlecture.jspprj.dao.NoticeDao;
import com.newlecture.jspprj.model.Notice;

public class JdbcNoticeDao implements NoticeDao{

	@Override
	public Notice getNotice(String code) {
		
		String sql = "SELECT * FROM NOTICES WHERE CODE =" + "'" + code + "'";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();

			Notice n = new Notice();
			n.setCode(rs.getString("code"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getDate("regdate"));
			n.setWriter(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));

			rs.close();
			st.close();
			con.close();

			return n;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Notice> getNotices(int page, String query, String field) {
		
		int start = 1+ (page-1)*20;
		int end = page*20;
		
		/*String sql = "SELECT * FROM ("
				+ "SELECT ROWNUM NUM, N.* FROM ("
				+ "SELECT * FROM NOTICES WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) N)"
				+ "WHERE NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		
		String sql = "SELECT N.* FROM ("
					+ "SELECT (ROW_NUMBER() OVER (ORDER BY REGDATE DESC)) NUM, NOTICES.* " 
					+ "FROM NOTICES WHERE " + field + " LIKE ?) N " 
					+ "WHERE N.NUM BETWEEN ? AND ?";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");
			st.setInt(2, start);
			st.setInt(3, end);
			
			ResultSet rs = st.executeQuery();
			
			List<Notice> list = new ArrayList<Notice>();
			
			while(rs.next()){

			Notice n = new Notice();
			n.setCode(rs.getString("code"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getDate("regdate"));
			n.setWriter(rs.getString("writer"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));
			
			list.add(n);
			}
			
			rs.close();
			st.close();
			con.close();

			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Notice> getNotices(int page, String query) {
		return getNotices(page, query, "TITLE");
	}

	@Override
	public List<Notice> getNotices(int page) {
		return getNotices(page, "", "TITLE");
	}
	
	@Override
	public int insert(Notice notice) {
		
		String sqlCode ="SELECT ISNULL(MAX(CAST(CODE AS INT)),0)+1 CODE FROM NOTICES";
		String sql = "INSERT INTO NOTICES(CODE,TITLE,WRITER,CONTENT,REGDATE,HIT) VALUES(?,?,?,?,getDate(),0)";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection con;

		con = DriverManager.getConnection(url, "sist", "newlec");
		
		Statement stCode = con.createStatement();
		ResultSet rs = stCode.executeQuery(sqlCode);
		
		rs.next();
		
		String code = rs.getString("CODE");
		
		stCode.close();
		rs.close();
		
		PreparedStatement st = con.prepareStatement(sql); //value 자리에 미리 ?를 넣어두고 후에 값을 집어 넣을수 있음
		st.setString(1, code);
		st.setString(2, notice.getTitle());
		st.setString(3, notice.getWriter());
		st.setString(4, notice.getContent());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Notice notice) {

		String sql = "UPDATE NOTICES SET TITLE=?,CONTENT=? WHERE CODE=?";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection con;

		con = DriverManager.getConnection(url, "sist", "newlec");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setString(3, notice.getCode());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	@Override
	public int delete(String code) {
		String sql = "DELETE NOTICES WHERE CODE =?";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection con;

		con = DriverManager.getConnection(url, "sist", "newlec");
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,code);

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getSize(String query, String field) {
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE '" + field + "' LIKE ?"; 
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");
			
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			int size = rs.getInt("CNT");
			
			rs.close();
			st.close();
			con.close();

			return size;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int getSize(String query) {
		return getSize(query, "TITLE");
	}

	@Override
	public String lastCode() {
		// TODO Auto-generated method stub // stub : 함수의 구현부	
		
		String sql = "SELECT ISNULL(MAX (CAST (CODE AS INT)) ,0) CODE FROM NOTICES";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);
			rs.next();
			
			String Code = rs.getString("Code");
			
			st.close();
			con.close();

			return Code;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Notice prevNotice(String curCode) {
		String sql = "SELECT TOP 1 * FROM NOTICES WHERE REGDATE > "
				+ "(SELECT REGDATE FROM NOTICES WHERE CODE=?) "
				+ "ORDER BY REGDATE ASC";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			st.setString(1, curCode);

			rs.next();

			Notice n = new Notice();
			n.setCode(rs.getString("code"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getDate("regdate"));
			n.setWriter(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));

			rs.close();
			st.close();
			con.close();

			return n;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Notice nextNotice(String curCode) {
		String sql = "SELECT * FROM NOTICES WHERE REGDATE < "
				+ "(SELECT REGDATE FROM NOTICES WHERE CODE=?) "
				+ "ORDER BY REGDATE DESC";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			st.setString(1, curCode);

			rs.next();

			Notice n = new Notice();
			n.setCode(rs.getString("code"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getDate("regdate"));
			n.setWriter(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));

			rs.close();
			st.close();
			con.close();

			return n;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}	

}
