package com.cn.vite.service;

import com.cn.vite.admin.Content;
import com.cn.vite.admin.Image;
import com.cn.vite.admin.Vote;
import com.cn.vite.dao.DataDao;
/**
 *����Ա����
 */
public class DataService {
    private DataDao dao = new DataDao();
    /**
     * @see ���Ӻ�ѡ����Ϣ
     * @param vote
     * @param content
     * @param image
     * @return boolean
     * @throws Exception
     */
    public boolean add(Vote vote, Content content, Image image)throws Exception{
    	try {
			return dao.add(vote, content, image);
		} catch (Exception e) {
			throw new Exception();
		}
    }
    /**
     * @see ɾ����ѡ��
     * @param id
     * @return boolean
     * @throws Exception
     */
    public boolean remove(int id) throws Exception{
    	try {
    		return dao.remove(id);
		} catch (Exception e) {
			throw new Exception();
		}
    }
    /**
     * @see �޸ĺ�ѡ����Ϣ
     * @param id
     * @param vote
     * @param content
     * @return
     * @throws Exception
     */
    public boolean update(int id,Vote vote,Content content)throws Exception{
    	try {
			return dao.update(id, vote, content);
		} catch (Exception e) {
			throw new Exception();
		}
    }
}
