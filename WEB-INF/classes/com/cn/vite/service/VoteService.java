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
 * ��ѯ��ѡ�� ҵ���
 *
 */
public class VoteService {
	private VoteDao dao = new VoteDao();
	private InfoDao infoDao = new InfoDao();
	/**
	 * @see ����������ѡ��,���ǰ��ս������
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
	 * @see ��ѯ���к�ѡ��
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
	 * @see ȡ�ú�ѡ����Ϣ
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
	 * @see ����ͶƱ��
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateById(int id, String ip,Object lock) throws Exception {
		int uu = 5;
		boolean sign = false;
		// ����IP�������ͶƱʱ��
		Info info = infoDao.findInfoByIp(ip);
		if (info == null) {// ��һ��ͶƱ
			sign = dao.updateById(id);
			info = new Info();
			info.setIp(ip);//С��
			info.setId(id);
			infoDao.insert(info);
		} else {
			Vote vote = dao.findVoteById(id);
			if(vote.getTicket()<=50){//����ͶƱ������
				// ȡ�����ͶƱʱ��
				long end = info.getVotetime().getTime();
				long middle = (System.currentTimeMillis() - end)/1000;
				// �������uu_����
				if (middle > uu) {
					synchronized (lock) {//����ȷ��ͬ��,���ķ�ΧԽСԽ��
						sign = dao.updateById(id);
						info.setIp(ip);
						infoDao.insert(info);
					}
				}else {
					//ʱ������uu_�벻����ͶƱ
					throw new NoVoteException("ͶƱʱ������:"+uu);
				}
			}else {
				throw new OverTicketException("�����涨��ͶƱ��");
			}
		}
		return sign;
	}
	/**
	 * ��ѯ������ͶƱ��Ϣ�����ʱ���IP
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
     * ��ֹ�ظ���½��ServletContext�в����Ƿ�����Ѿ���½�����
     * @param usernameList
     * @param username
     * @return
     */
	public boolean checkOnline(List<String> usernameList, String username) {
		boolean flag = false;
		if(usernameList.size()==0){//��һ��Ϊnullû��һ���û�,���û�δ����
			usernameList.add(username);
		}else {
			for(String u:usernameList){
				if(u.equals(username)){//���û�����
					flag = true;//�Ѿ���½����
					return flag;
				}
			}
			//���û�������
			usernameList.add(username);
		}
		return flag;
	}
	/**
	 * @see ��ѯ����ȡ����Ա��Ϣ
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
