<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글입력
	response.setCharacterEncoding("UTF-8"); //한글출력
	response.setContentType("text/html;charset=UTF-8");

	int x = 0;
	int y = 0;

	if (request.getMethod().equals("POST")) {
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");

		if (_x != null && !_x.equals(""))
			x = Integer.parseInt(_x);

		if (_y != null && !_y.equals(""))
			y = Integer.parseInt(_y);
	}

	int sum = x + y;

	String _save = request.getParameter("save");

	if (_save != null) {
		String _sum = request.getParameter("sum");
		_save = new String(_save.getBytes("ISO-8859-1"), "UTF-8"); //한글입력

		System.out.println(_save);

		if (_save.equals("앱")) {
			//application = request.getServletContext();
			application.setAttribute("sum", _sum);
			System.out.println("saved in app");
		}

		else if (_save.equals("세션")) {
			session.setAttribute("sum", _sum);
			System.out.println("saved in session");
		}

		else if (_save.equals("쿠키")) {
			Cookie cookie = new Cookie("sum", _sum);
			cookie.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie);
			System.out.println("saved in cookie");
		}
	}		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더하기</title>
</head>
<body>
	<form action="add.jsp" method="post">
	
		<ul>
			<li> <label for="x">X:</label> <input name="x" /> </li>
			<li> <label for="y">Y:</label> <input name="y" /> </li>
			<li> <label for="sum">SUM:</label> <input name = "sum" value= <%=sum %>> </li>
		</ul>
		
		<p> 
			<input type="submit" value="덧셈"/>	
			<input type="submit" name="save" value="앱"/>
			<input type="submit" name="save" value="세션"/>
			<input type="submit" name="save" value="쿠키"/>
		</p>
		<p>
			<a href="index">home</a>
		</p>
	</form>
</body>
</html>
