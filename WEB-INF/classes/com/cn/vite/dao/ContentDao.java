package com.cn.vite.dao;
/**
 * 查询候选人的详细信息
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
 *查询候选人详细信息
 */
public class ContentDao {
	private QueryRunner runner = null;
	/**
	 * @see 查询候选人详细信息
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
