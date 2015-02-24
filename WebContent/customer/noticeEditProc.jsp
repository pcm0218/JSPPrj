<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="com.newlecture.jspprj.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Notice notice = new Notice();
	
	notice.setCode(code);
	notice.setTitle(title);
	notice.setContent(content);
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.update(notice);
	
	response.sendRedirect("noticeDetail.jsp?c="+code);
%>