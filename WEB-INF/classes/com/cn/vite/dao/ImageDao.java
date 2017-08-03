package com.cn.vite.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cn.vite.admin.Image;
import com.cn.vite.mode.DBCP_DataSource;

/**
 * ��ѡ��ͷ����Ϣ
 */
public class ImageDao {
	private QueryRunner runner = null;

	/**
	 * @see ��ȡ��ѡ��ͷ����Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public Image findImageById(int id) throws SQLException {
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		Image image = null;
		String sql = "select * from image where cid=?";
		image = runner.query(sql,id, new BeanHandler<Image>(Image.class));
		return image;
	}
}
