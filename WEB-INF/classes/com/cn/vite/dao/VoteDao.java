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
 * Dao_ select ��ѡ��
 * 
 * @author noatnuVoteDao
 *
 */
public class VoteDao {
	private QueryRunner runner = null;
    /**
     * @see ��Ȼ�������
     * @return
     * @throws SQLException
     */
	public List<Vote> findAllVoteDesc() throws SQLException {
		List<Vote> list = new ArrayList<Vote>();
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = "select * from vote order by ticket desc;";// ��������
		list = (List<Vote>) runner.query(sql, new BeanListHandler<Vote>(Vote.class));
		return list;
	}

	/**
	 * @see ��ѯ���к�ѡ��
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
	 * @see ȡ�ú�ѡ����Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public Vote findVoteById(int id) throws SQLException {
		/* ���ݴ���Ĺ���idȡ������������Ϣ���id */
		Vote vote = null;
		runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
		String sql = "select * from vote where id=?";
		vote = runner.query(sql, id, new BeanHandler<Vote>(Vote.class));
		return vote;
	}

	/**
	 * @see ����ͶƱ��
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
	 * @see ��ѯ������ͶƱ��Ϣ�����ʱ���IP
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
