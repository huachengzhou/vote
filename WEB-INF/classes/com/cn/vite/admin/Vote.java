package com.cn.vite.admin;
/**
 * 候选人
 * @author noatnu_Vote
 *
 */
public class Vote {
	//编号
	private int id;
	//名字
	private String content;
	//票数
	private int ticket;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public Vote(int id, String content, int ticket) {
		super();
		this.id = id;
		this.content = content;
		this.ticket = ticket;
	}
	public Vote(String content, int ticket) {
		this.content = content;
		this.ticket = ticket;
	}
	public Vote() {
		super();
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", content=" + content + ", ticket=" + ticket + "]";
	}
}
