package com.cn.vite.util;

import java.sql.Date;

public class User {
    private int id ;
    private Date birthday;
    private double salary;
    private String username;
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", birthday=" + birthday + ", salary=" + salary + ", username=" + username
				+ ", password=" + password + "]";
	}
}
