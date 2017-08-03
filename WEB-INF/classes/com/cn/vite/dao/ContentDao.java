package com.cn.vite.dao;
/**
 * ��ѯ��ѡ�˵���ϸ��Ϣ
 * @author noatnu_ContentDao
 *
 */

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cn.vite.admin.Content;
import com.cn.vite.mode.DBCP_DataSource;
/**
 * 
 *��ѯ��ѡ����ϸ��Ϣ
 */
public class ContentDao {
	private QueryRunner runner = null;
	/**
	 * @see ��ѯ��ѡ����ϸ��Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public Content findContentById(int id)throws SQLException {
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		Content content = new Content();
		String sql = "select * from content where vid=?";
		content = runner.query(sql, id,new BeanHandler<Content>(Content.class));
		return content;
	}
}
