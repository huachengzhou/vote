package com.cn.vite.exception;

@SuppressWarnings("serial")
public class OverTicketException extends Exception{

	public OverTicketException() {
	}

	public OverTicketException(String message) {
		System.out.println(message);
	}

}
