package com.cn.vite.text;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cn.vite.admin.Vote;
import com.cn.vite.dao.VoteDao;
/**
 * Dao_�� �����ݿ��ѯ��������
 * @author noatnuVoteDaoTest
 *
 */
public class VoteDaoTest {
	/**
	 * @see ��ѯ���к�ѡ����Ϣ Dao
	 * @throws SQLException
	 */
	@Test
    public void test()throws SQLException{
    	List<Vote> list = new VoteDao().findAllVote();
    	for(Vote vote:list){
    		System.out.println(vote);
    	}
    }
	@Test
	public void update()throws SQLException{
		boolean sign = new VoteDao().updateById(1);
		System.out.println(sign);
	}
}
