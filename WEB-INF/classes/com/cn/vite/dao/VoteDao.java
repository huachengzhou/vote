package com.cn.vite.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cn.vite.admin.Info;
import com.cn.vite.admin.Vote;
import com.cn.vite.mode.DBCP_DataSource;

/**
 * Dao_ select 候选人
 * 
 * @author noatnuVoteDao
 *
 */
public class VoteDao {
	private QueryRunner runner = null;
    /**
     * @see 自然降序查找
     * @return
     * @throws SQLException
     */
	public List<Vote> findAllVoteDesc() throws SQLException {
		List<Vote> list = new ArrayList<Vote>();
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = "select * from vote order by ticket desc;";// 降序排列
		list = (List<Vote>) runner.query(sql, new BeanListHandler<Vote>(Vote.class));
		return list;
	}

	/**
	 * @see 查询所有候选人
	 * @return
	 * @throws SQLException
	 */
	public List<Vote> findAllVote() throws SQLException {
		List<Vote> list = new ArrayList<Vote>();
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = "select * from vote;";
		list = (List<Vote>) runner.query(sql, new BeanListHandler<Vote>(Vote.class));
		return list;
	}

	/**
	 * @see 取得候选人信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public Vote findVoteById(int id) throws SQLException {
		/* 根据传入的关联id取得我们所需信息表的id */
		Vote vote = null;
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = "select * from vote where id=?";
		vote = runner.query(sql, id, new BeanHandler<Vote>(Vote.class));
		return vote;
	}

	/**
	 * @see 更新投票数
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean updateById(int id) throws SQLException {
		String sql = "update vote set ticket = ticket+1 where id = ?";
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		int u = runner.update(sql, id);
		return u >= 0;
	}

	/**
	 * @see 查询所有人投票信息的最后时间和IP
	 * @return
	 * @throws SQLException
	 */
	public List<Info> findAllInfo() throws SQLException {
		List<Info> list = new ArrayList<Info>();
		String sql = " select ip,max(votetime) as votetime from info group by ip;";
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		list = runner.query(sql, new BeanListHandler<Info>(Info.class));
		return list;
	}
}
