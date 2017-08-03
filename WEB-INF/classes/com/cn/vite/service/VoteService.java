package com.cn.vite.service;

import java.util.List;

import com.cn.vite.admin.Address;
import com.cn.vite.admin.Admin;
import com.cn.vite.admin.Info;
import com.cn.vite.admin.Vote;
import com.cn.vite.dao.AddressDao;
import com.cn.vite.dao.AdminDao;
import com.cn.vite.dao.InfoDao;
import com.cn.vite.dao.VoteDao;
import com.cn.vite.exception.NoVoteException;
import com.cn.vite.exception.OverTicketException;

/**
 * 查询候选人 业务层
 *
 */
public class VoteService {
	private VoteDao dao = new VoteDao();
	private InfoDao infoDao = new InfoDao();
	/**
	 * @see 查找所有所选人,但是按照降序查找
	 * @return
	 * @throws Exception
	 */
	public List<Vote> findAllVoteDesc()throws Exception{
		try {
			return dao.findAllVoteDesc();
		} catch (Exception e) {
			throw new Exception();
		}
	}
	/**
	 * @see 查询所有候选人
	 * @return
	 * @throws Exception
	 */
	public List<Vote> findAllVote() throws Exception {
		try {
			return dao.findAllVote();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	/**
	 * @see 取得候选人信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Vote findVoteById(int id) throws Exception {
		try {
			return dao.findVoteById(id);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	/**
	 * @see 更新投票数
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateById(int id, String ip,Object lock) throws Exception {
		int uu = 5;
		boolean sign = false;
		// 根据IP查找最后投票时间
		Info info = infoDao.findInfoByIp(ip);
		if (info == null) {// 第一次投票
			sign = dao.updateById(id);
			info = new Info();
			info.setIp(ip);//小心
			info.setId(id);
			infoDao.insert(info);
		} else {
			Vote vote = dao.findVoteById(id);
			if(vote.getTicket()<=50){//限制投票的数量
				// 取得最后投票时间
				long end = info.getVotetime().getTime();
				long middle = (System.currentTimeMillis() - end)/1000;
				// 如果大于uu_分钟
				if (middle > uu) {
					synchronized (lock) {//加锁确保同步,锁的范围越小越好
						sign = dao.updateById(id);
						info.setIp(ip);
						infoDao.insert(info);
					}
				}else {
					//时间少于uu_秒不允许投票
					throw new NoVoteException("投票时间少于:"+uu);
				}
			}else {
				throw new OverTicketException("超过规定的投票数");
			}
		}
		return sign;
	}
	/**
	 * 查询所有人投票信息的最后时间和IP
	 * @return
	 * @throws Exception
	 */
	public List<Info> findAllInfo()throws Exception{
		AddressDao addressDao = new AddressDao();
		Address address = null;
		try {
			List<Info> list = dao.findAllInfo();
			for(Info info:list){
				address = addressDao.findAddressByIp(info.getIp());
				info.setAddress(address);
			}
			return list;
		} catch (Exception e) {
			throw new Exception();
		}
	}
    /**
     * 防止重复登陆从ServletContext中查找是否存在已经登陆的情况
     * @param usernameList
     * @param username
     * @return
     */
	public boolean checkOnline(List<String> usernameList, String username) {
		boolean flag = false;
		if(usernameList.size()==0){//第一次为null没有一个用户,该用户未在线
			usernameList.add(username);
		}else {
			for(String u:usernameList){
				if(u.equals(username)){//该用户在线
					flag = true;//已经登陆过了
					return flag;
				}
			}
			//该用户不在线
			usernameList.add(username);
		}
		return flag;
	}
	/**
	 * @see 查询并获取管理员信息
	 * @param username
	 * @param password
	 * @return Admin
	 * @throws Exception
	 */
	public Admin findAdminByUP(String username,String password)throws Exception{
		Admin admin = null;
		AdminDao dao = new AdminDao();
		try {
			admin = dao.findAdminByUP(username, password);
			return admin;
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
