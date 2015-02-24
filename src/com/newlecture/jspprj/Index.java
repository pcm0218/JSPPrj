package com.newlecture.jspprj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class Index extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String _sumA = "";
		String _sumS = "";
		String _sumC= "";
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		if(application.getAttribute("sum") != null)
			_sumA = application.getAttribute("sum").toString();
		
		if (session.getAttribute("sum") != null)
			_sumS = session.getAttribute("sum").toString();
		
		if(cookies != null){
			for(Cookie cookie :cookies){
				if("sum".equals(cookie.getName())){
					_sumC = cookie.getValue();
				}
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"EUC-KR\">");
		out.write("<title>더하기</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("		<a href=\"add\">계산하기</a>");
		out.write("		<p>마지막 계산값 app:" + _sumA + "</p>" );
		out.write("		<p>마지막 계산값 session:" + _sumS + "</p>" );
		out.write("		<p>마지막 계산값 cookie:" + _sumC + "</p>" );
		out.write("</body>");
		out.write("</html>");		
		
	}

}
