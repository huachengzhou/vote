package com.cn.vite.mode;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.DocumentException;
/**
 * DBCP:获取数据源,从DataSourceXML中读取数据库连接信息
 * ->DBCP连接池似乎比c3p0初始速度要快那么一点
 * @author noatnu_DBCP_DataSource
 * @version 1.1
 * @since jdk1.6
 * @see --
 *
 */
public class DBCP_DataSource {
	/**
	 * @see RT3:初始连接池的连接数量5,最多有100个活动连接数,最少有2个空闲连接
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT3(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getRT3("driver"));
			dataSource.setUrl(DataSourceXML.getRT3("url"));
			dataSource.setUsername(DataSourceXML.getRT3("username"));
			dataSource.setPassword(DataSourceXML.getRT3("password"));
			dataSource.setInitialSize(4);//初始连接池的连接数量5
			dataSource.setMaxActive(100);//最多有100个活动连接数
			dataSource.setMinIdle(2);//最少有2个空闲连接
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	/**
	 * @see RT数据库:初始连接池的连接数量5,最多有10个活动连接数,最少有2个空闲连接
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getRT("driver"));
			dataSource.setUrl(DataSourceXML.getRT("url"));
			dataSource.setUsername(DataSourceXML.getRT("username"));
			dataSource.setPassword(DataSourceXML.getRT("password"));
			dataSource.setInitialSize(4);//初始连接池的连接数量5
			dataSource.setMaxActive(10);//最多有10个活动连接数
			dataSource.setMinIdle(2);//最少有2个空闲连接
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	/**
	 * @see DB2:初始连接池的连接数量5,最多有10个活动连接数,最少有2个空闲连接
	 * @return DataSource
	 */
	public static DataSource getDataSource_DB2(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getDB2("driver"));
			dataSource.setUrl(DataSourceXML.getDB2("url"));
			dataSource.setUsername(DataSourceXML.getDB2("username"));
			dataSource.setPassword(DataSourceXML.getDB2("password"));
			dataSource.setInitialSize(4);//初始连接池的连接数量5
			dataSource.setMaxActive(10);//最多有10个活动连接数
			dataSource.setMinIdle(2);//最少有2个空闲连接
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
