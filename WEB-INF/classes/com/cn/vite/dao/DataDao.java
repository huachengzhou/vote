package com.cn.vite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import com.cn.vite.admin.Content;
import com.cn.vite.admin.Image;
import com.cn.vite.admin.Vote;
import com.cn.vite.mode.DBCP_DataSource;

public class DataDao {
	private QueryRunner runner = null;
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement state = null;
	/**
	 * @see �޸ĺ�ѡ����Ϣ
	 * @param id
	 * @param vote
	 * @param content
	 * @return
	 * @throws SQLException
	 */
    public boolean update(int id,Vote vote,Content content)throws SQLException{
    	runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
    	//update content  set age=20 , description='���' where vid=20;
    	//update vote set content='����' , ticket=30 where id=20;
    	String sql1 = "update content  set age=? , description=? where vid=?";
    	String sql2 = "update vote set content=? , ticket=? where id=?";
    	int a = runner.update(sql1, new Object[]{content.getAge(),content.getDescription(),id});
    	int b = runner.update(sql2, new Object[]{vote.getContent(),vote.getTicket(),id});
		return (b>0&&a>0);
    }
	/**
	 * @see ���Ӻ�ѡ����Ϣ
	 * @param vote
	 * @param content
	 * @param image
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean add(Vote vote, Content content, Image image) throws SQLException {
		int u = 0;
		try {
			runner = new QueryRunner(DBCP_DataSource.getDataSource_RT3());
			conn = DBCP_DataSource.getDataSource_RT3().getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into vote(content,ticket) values(?,?)";
			// 1���Ȳ���һ�����
			state = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			state.setString(1, vote.getContent());
			state.setInt(2, vote.getTicket());
			state.executeUpdate();
			// 2ȡ�ò�����������
			int kid = 0;
			rs = state.getGeneratedKeys();
			if (rs.next()) {
				kid = rs.getInt(1);
			}
			System.out.println("����" + kid);

			// �ٴβ������
			String sql2 = "insert into content(age,description,vid) values(?,?,?)";
			state = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			state.setInt(1, content.getAge());
			state.setString(2, content.getDescription());
			state.setInt(3, kid);
			int i = state.executeUpdate();
			rs = state.getGeneratedKeys();
			// �ٴ�ȡ�������������
			if (rs.next()) {
				kid = rs.getInt(1);
			}
			System.out.println("����" + kid);

			conn.commit();

			String sql3 = "insert into image(cid,path) values(?,?)";
			u = runner.update(sql3, new Object[] { kid, image.getPath() });

			System.out.println(i + " " + u);
		} catch (Exception e) {
			conn.rollback();
			conn.commit();
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
			if (state != null)
				state.close();
			if (rs != null)
				rs.close();
		}
		return u > 0;
	}
    /**
     * @see ɾ����ѡ��
     * @param id
     * @return boolean
     * @throws SQLException
     */
	public boolean remove(int id) throws SQLException {
		boolean flag = false;
		try {
			// ����:vote id������content���е�vid��image���е�cid����content�е�id
			// vote id==content vid
			// content id = image cid

			/*
			 * ˼·�������ô����vote idȡ��content�е� id ���ȸ���id-cidɾ��image(������ϵ�������)
			 * Ȼ���ٸ���id-vidɾ��content
			 */
			String sql = "select id from content where vid=?";
			conn = DBCP_DataSource.getDataSource_RT3().getConnection();
			conn.setAutoCommit(false);
			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			rs = state.executeQuery();
			int cid = 0;
			if (rs.next()) {
				cid = rs.getInt(1);
			}
			String sql1 = "delete from image where cid=?";
			state = conn.prepareStatement(sql1);
			state.setInt(1, cid);
			int x = state.executeUpdate();
			String sql2 = " delete from content where vid=?";
			state = conn.prepareStatement(sql2);
			state.setInt(1, id);
			int y = state.executeUpdate();
			String sql3 = "delete from vote where id=?";
			state = conn.prepareStatement(sql3);
			state.setInt(1, id);
			int z = state.executeUpdate();
			System.out.println("end" + x + " " + y + " " + z);
			conn.commit();
			if (z > 0)
				flag = true;
		} catch (Exception e) {
			conn.rollback();
			conn.commit();
		} finally {
			conn.close();
			state.close();
			rs.close();
		}
		return flag;
	}
}
