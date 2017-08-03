package com.cn.vite.admin;

import java.sql.Timestamp;
/**
 * 投票IP和时间
 *
 */
public class Info {
	private String ip;
	private int id;
	private java.sql.Timestamp votetime;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Timestamp getVotetime() {
		return votetime;
	}

	public void setVotetime(java.sql.Timestamp votetime) {
		this.votetime = votetime;
	}

	public Info() {
		super();
	}

	@Override
	public String toString() {
		return "Info [ip=" + ip + ", id=" + id + ", votetime=" + votetime + "]";
	}

	public Info(String ip, int id, Timestamp votetime) {
		super();
		this.ip = ip;
		this.id = id;
		this.votetime = votetime;
	}
}
