package com.newlecture.jspprj;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class NewlecRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("요청종료 Remote IP=" + event.getServletRequest().getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("요청초기화 Remote IP=" + event.getServletRequest().getRemoteAddr());

	}
	
	

}
