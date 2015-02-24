package com.newlecture.jspprj;

import java.io.IOException;

import javax.servlet.*;

public class CharacterEncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		System.out.println("before 필터라요");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
//		System.out.println("after 필터라요");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}
}
