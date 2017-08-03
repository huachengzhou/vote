package com.cn.vite.mode;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.DocumentException;
/**
 * DBCP:��ȡ����Դ,��DataSourceXML�ж�ȡ���ݿ�������Ϣ
 * ->DBCP���ӳ��ƺ���c3p0��ʼ�ٶ�Ҫ����ôһ��
 * @author noatnu_DBCP_DataSource
 * @version 1.1
 * @since jdk1.6
 * @see --
 *
 */
public class DBCP_DataSource {
	/**
	 * @see RT3:��ʼ���ӳص���������5,�����100���������,������2����������
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT3(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getRT3("driver"));
			dataSource.setUrl(DataSourceXML.getRT3("url"));
			dataSource.setUsername(DataSourceXML.getRT3("username"));
			dataSource.setPassword(DataSourceXML.getRT3("password"));
			dataSource.setInitialSize(4);//��ʼ���ӳص���������5
			dataSource.setMaxActive(100);//�����100���������
			dataSource.setMinIdle(2);//������2����������
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	/**
	 * @see RT���ݿ�:��ʼ���ӳص���������5,�����10���������,������2����������
	 * @return DataSource
	 */
	public static DataSource getDataSource_RT(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getRT("driver"));
			dataSource.setUrl(DataSourceXML.getRT("url"));
			dataSource.setUsername(DataSourceXML.getRT("username"));
			dataSource.setPassword(DataSourceXML.getRT("password"));
			dataSource.setInitialSize(4);//��ʼ���ӳص���������5
			dataSource.setMaxActive(10);//�����10���������
			dataSource.setMinIdle(2);//������2����������
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	/**
	 * @see DB2:��ʼ���ӳص���������5,�����10���������,������2����������
	 * @return DataSource
	 */
	public static DataSource getDataSource_DB2(){
		BasicDataSource dataSource = new BasicDataSource();
		
		try {
			dataSource.setDriverClassName(DataSourceXML.getDB2("driver"));
			dataSource.setUrl(DataSourceXML.getDB2("url"));
			dataSource.setUsername(DataSourceXML.getDB2("username"));
			dataSource.setPassword(DataSourceXML.getDB2("password"));
			dataSource.setInitialSize(4);//��ʼ���ӳص���������5
			dataSource.setMaxActive(10);//�����10���������
			dataSource.setMinIdle(2);//������2����������
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
