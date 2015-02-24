package com.newlecture.jspprj;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NewlecSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("���ǻ���: " + event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("��������: " + event.getSession().getId());
	}
}
