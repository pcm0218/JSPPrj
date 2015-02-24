<%@page import="com.newlecture.jspprj.jdbc.JdbcNoticeFileDao"%>
<%@page import="com.newlecture.jspprj.model.NoticeFile"%>
<%@page import="com.newlecture.jspprj.dao.NoticeFileDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="com.newlecture.jspprj.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/customer/upload");
	
	out.println(path+"<br />");
	
	MultipartRequest req = new MultipartRequest(request, path, 1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
	
	String title = req.getParameter("title");
	String fileName = req.getFilesystemName("file");
	String content = req.getParameter("content");
	
	out.println(title+"<br />");
	out.println(fileName+"<br />");
	out.println(content+"<br />");
	
	
	
	/* String title = request.getParameter("title");
	String file = request.getParameter("file");
	String content = request.getParameter("content"); */
	
	Notice notice = new Notice();
	
	notice.setTitle(title);
	notice.setContent(content);
	notice.setWriter("chanmoon");
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.insert(notice);
	
	if(req.getFile("file") != null)
	{
		String noticeCode = noticeDao.lastCode();
		
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setSrc(fileName);
		noticeFile.setDescription("");
		noticeFile.setNoticeCode(noticeCode);
		
		NoticeFileDao fileDao = new JdbcNoticeFileDao();
		fileDao.insert(noticeFile);
	}
	
	response.sendRedirect("notice.jsp");
%>