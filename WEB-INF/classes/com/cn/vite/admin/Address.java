package com.cn.vite.admin;

public class Address {
	private int id;
	private String location;
	private String ip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", ip=" + ip + "]";
	}
	public Address() {
		super();
	}
}
