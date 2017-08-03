package com.cn.vite.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cn.vite.admin.Info;
import com.cn.vite.mode.DBCP_DataSource;

/**
 * 投票IP和时间
 *
 */
public class InfoDao {
	private QueryRunner runner = null;
    /**
     * @see 插入数据(IP time JavaBean)
     * @param info
     * @return
     * @throws SQLException
     */
	public boolean insert(Info info) throws SQLException {
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = " insert into info(ip) values(?)";
		int u = runner.update(sql,info.getIp());
		return u>=0;
	}
	@SuppressWarnings("deprecation")
	public Info findInfoByIp(String ip)throws SQLException{
		Info info = null;
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		/*select ip,max(votetime) as votetime from info where ip='0:0:0:0:0:0:0:1'group by ip ;*/
		String sql = "select ip,max(votetime) as votetime from info where ip=? group by ip ;";
		info = runner.query(sql, ip, new BeanHandler<Info>(Info.class));
		return info;
	}
}
