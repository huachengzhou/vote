package com.cn.vite.exception;

@SuppressWarnings("serial")
public class NoVoteException extends Exception {

	public NoVoteException(String string) {
		System.out.println(string);
	}

}
