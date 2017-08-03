package com.cn.vite.mode;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.dom4j.DocumentException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0:获取数据源,从DataSourceXML中读取数据库连接信息
 * @author noatnu_C3P0_DataSource
 * @version 1.1
 * @since jdk1.6
 * @see --
 */
public class C3P0_DataSource {

	/**
	 * @see RT3:连接池的最大连接数1000,连接池的最小连接数40,连接池的初始连接数10,连接池的缓存连接数180
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT3() {
		ComboPooledDataSource c3p0 = new ComboPooledDataSource();
		try {
			try {
				c3p0.setDriverClass(DataSourceXML.getRT3("driver"));
				c3p0.setJdbcUrl(DataSourceXML.getRT3("url"));
				c3p0.setUser(DataSourceXML.getRT3("username"));
				c3p0.setPassword(DataSourceXML.getRT3("password"));
				c3p0.setMaxPoolSize(1000);// 连接池的最大连接数1000
				c3p0.setMinPoolSize(40);//连接池的最小连接数40
				c3p0.setInitialPoolSize(10);//连接池的初始连接数10
				c3p0.setMaxStatements(180);//连接池的缓存连接数180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}
	/**
	 * @see RT:连接池的最大连接数1000,连接池的最小连接数40,连接池的初始连接数10,连接池的缓存连接数180
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT() {
		ComboPooledDataSource c3p0 = new ComboPooledDataSource();
		try {
			try {
				c3p0.setDriverClass(DataSourceXML.getRT("driver"));
				c3p0.setJdbcUrl(DataSourceXML.getRT("url"));
				c3p0.setUser(DataSourceXML.getRT("username"));
				c3p0.setPassword(DataSourceXML.getRT("password"));
				c3p0.setMaxPoolSize(1000);// 连接池的最大连接数1000
				c3p0.setMinPoolSize(40);//连接池的最小连接数40
				c3p0.setInitialPoolSize(10);//连接池的初始连接数10
				c3p0.setMaxStatements(180);//连接池的缓存连接数180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}
	/**
	 * @see DB2:连接池的最大连接数1000,连接池的最小连接数40,连接池的初始连接数10,连接池的缓存连接数180
	 * @return DataSource
	 */
	public static DataSource getDataSource_DB2() {
		ComboPooledDataSource c3p0 = new ComboPooledDataSource();
		try {
			try {
				c3p0.setDriverClass(DataSourceXML.getDB2("driver"));
				c3p0.setJdbcUrl(DataSourceXML.getDB2("url"));
				c3p0.setUser(DataSourceXML.getDB2("username"));
				c3p0.setPassword(DataSourceXML.getDB2("password"));
				c3p0.setMaxPoolSize(1000);// 连接池的最大连接数1000
				c3p0.setMinPoolSize(40);//连接池的最小连接数40
				c3p0.setInitialPoolSize(10);//连接池的初始连接数10
				c3p0.setMaxStatements(180);//连接池的缓存连接数180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}

}
