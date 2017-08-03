package com.cn.vite.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cn.vite.admin.Address;
import com.cn.vite.mode.DBCP_DataSource;
/**
 *地址查询
 */
public class AddressDao {
	/**
	 * @see 根据ip查询地址
	 * @param ip
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public Address findAddressByIp(String ip)throws SQLException{
		Address address = null;
		String sql = "select * from address where ip=?";
		QueryRunner runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		address = runner.query(sql,ip,new BeanHandler<Address>(Address.class));
		return address;
	}
}
