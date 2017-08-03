package com.cn.vite.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cn.vite.admin.Admin;
import com.cn.vite.mode.DBCP_DataSource;

public class AdminDao {
	/**
	 * @see 查询管理员信息Bean
	 * @param username
	 * @param password
	 * @return Admin
	 * @throws SQLException
	 */
    @SuppressWarnings("deprecation")
	public Admin findAdminByUP(String username,String password)throws SQLException{
    	String sql = " select * from admin where username=? and password=?";
		QueryRunner runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
    	Admin admin = null;
    	admin = runner.query(sql,new Object[]{username,password},new BeanHandler<Admin>(Admin.class));
    	return admin;
    }
}
