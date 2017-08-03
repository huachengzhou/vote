package com.cn.vite.mode;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.dom4j.DocumentException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0:��ȡ����Դ,��DataSourceXML�ж�ȡ���ݿ�������Ϣ
 * @author noatnu_C3P0_DataSource
 * @version 1.1
 * @since jdk1.6
 * @see --
 */
public class C3P0_DataSource {

	/**
	 * @see RT3:���ӳص����������1000,���ӳص���С������40,���ӳصĳ�ʼ������10,���ӳصĻ���������180
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
				c3p0.setMaxPoolSize(1000);// ���ӳص����������1000
				c3p0.setMinPoolSize(40);//���ӳص���С������40
				c3p0.setInitialPoolSize(10);//���ӳصĳ�ʼ������10
				c3p0.setMaxStatements(180);//���ӳصĻ���������180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}
	/**
	 * @see RT:���ӳص����������1000,���ӳص���С������40,���ӳصĳ�ʼ������10,���ӳصĻ���������180
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
				c3p0.setMaxPoolSize(1000);// ���ӳص����������1000
				c3p0.setMinPoolSize(40);//���ӳص���С������40
				c3p0.setInitialPoolSize(10);//���ӳصĳ�ʼ������10
				c3p0.setMaxStatements(180);//���ӳصĻ���������180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}
	/**
	 * @see DB2:���ӳص����������1000,���ӳص���С������40,���ӳصĳ�ʼ������10,���ӳصĻ���������180
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
				c3p0.setMaxPoolSize(1000);// ���ӳص����������1000
				c3p0.setMinPoolSize(40);//���ӳص���С������40
				c3p0.setInitialPoolSize(10);//���ӳصĳ�ʼ������10
				c3p0.setMaxStatements(180);//���ӳصĻ���������180
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return c3p0;
	}

}
