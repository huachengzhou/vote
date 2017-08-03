package com.cn.vite.util;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cn.vite.mode.C3P0_DataSource;

/**
 * 
 * @author noatnu_Demo1
 *
 */
public class Dbutils {
	private QueryRunner runner = null;

	/**
	 * @see dbutils ��װjdbc ��������(get DataSource)
	 * @throws Exception
	 */
	public void insert() throws Exception {
		runner = new QueryRunner(C3P0_DataSource.getDataSource_RT());
		String insert_sql = "insert into user(username,password,birthday,salary) values(?,?,?,?) ;";
		runner.update(insert_sql, new Object[] { "����", "abcdefg", "2067-09-22", 44436.89446 });
	}

	/**
	 * @see �������ݿ��(get DataSource)
	 * @throws Exception
	 */
	public void update() throws Exception {
		runner = new QueryRunner(C3P0_DataSource.getDataSource_RT());
		String update_sql = "update user set salary = 7878.78 where username = ?";
		runner.update(update_sql, "����");
	}

	/**
	 * @see û������Դ,����������ݿ�����Դ
	 * @param conn
	 * @throws Exception
	 */
	public void update(Connection conn) throws Exception {
		String insert_sql = "insert into user(username,password,birthday,salary) values(?,?,?,?) ;";
		runner = new QueryRunner();
		runner.update(conn, insert_sql, new Object[] { "��Ѿͷ", "abcdefg", "3067-01-22", 89436.894 });
		if (conn != null) {
			System.out.println("û���Զ��ر�!");
			conn.close();
		}
	}

	/**
	 * @see ���ؽ����
	 * @return JavaBean,Object[],List<T>,List<Object[]>
	 * @throws Exception
	 */
	public void isResultSetHandler_List_ObjectArray_JavaBean_ListBean() throws Exception {
		runner = new QueryRunner(C3P0_DataSource.getDataSource_RT());
		// String sqls = "select * from user where id=?";
		// User user = runner.query(sql, 1, new BeanHandler<User>(User.class));

		String sql = "select * from user ";
		User user = runner.query(sql, new BeanHandler<User>(User.class));/* ȡ��һ����¼��ת��Ϊbeans */
		Object[] objs = runner.query(sql, new ArrayHandler());/** ȡ��һ����¼��ת��Ϊ���� */

		List<User> list = runner.query(sql, new BeanListHandler<User>(User.class));/* ȡ�����м�¼���Ұ����м�¼��װ��������ȥ **/
		List<Object[]> oList = runner.query(sql, new ArrayListHandler());/* ȡ�����м�¼����ÿ����¼������װ�ɶ��� */

		System.out.println("����:" + user);
		System.out.println("����:" + Arrays.toString(objs));

		System.out.println("bean����:" + list);
		for (Object[] objects : oList) {
			System.out.println("��������:" + Arrays.toString(objects));
		}
	}

	/**
	 * @see ӳ���:���ݿ⵽�����ӳ��
	 * @return Map ListMap
	 * @throws Exception
	 */
	public void isResultSetHandler_Map_MapMax() throws Exception {
		runner = new QueryRunner(C3P0_DataSource.getDataSource_RT());
		String sql = "select * from user ";
		Map<String, Object> map = runner.query(sql, new MapHandler());
		List<Map<String, Object>> liMaps = runner.query(sql, new MapListHandler());
		Set<Entry<String, Object>> set = map.entrySet();
		Iterator<Entry<String, Object>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			System.out.println("-key:" + entry.getKey() + " value:" + entry.getValue() + "-");
		}
		for (Map<String, Object> map2 : liMaps) {
			System.out.println("username:" + map2.get("username") + " password:" + map2.get("password"));
		}
	}

	/**
	 * @see ȡ���ܼ�¼����
	 * @return count number
	 * @throws Exception
	 */
	public void isResultSetHandlerScalarHandler() throws Exception {
		runner = new QueryRunner(C3P0_DataSource.getDataSource_RT());
		String sql = "select count(*) from user ";
		Long sum = runner.query(sql, new ScalarHandler<>());
		System.out.println("������:"+sum);
	}

	public static void main(String[] args) throws Exception {
		Dbutils dbutil = new Dbutils();
		dbutil.isResultSetHandler_List_ObjectArray_JavaBean_ListBean();
		System.out.println("end!--------------");
		dbutil.isResultSetHandler_Map_MapMax();
		dbutil.isResultSetHandlerScalarHandler();
	}
}
