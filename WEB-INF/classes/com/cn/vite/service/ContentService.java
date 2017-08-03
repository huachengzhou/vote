package com.cn.vite.service;

import com.cn.vite.admin.Content;
import com.cn.vite.admin.Image;
import com.cn.vite.admin.Vote;
import com.cn.vite.dao.ContentDao;
import com.cn.vite.dao.ImageDao;
/**
 *查询候选人详细信息
 *
 */
public class ContentService {
	private ContentDao dao = new ContentDao();
	private ImageDao imageDao = new ImageDao();
    /**
     * @see 查询候选人详细信息
     * @param id
     * @return
     * @throws Exception
     */
	public Content findContentById(int id) throws Exception {
		try {
			//手工装配关联关系
			Vote vote = new VoteService().findVoteById(id);
			Content content = dao.findContentById(id);
			Image image = imageDao.findImageById(id);
			content.setVote(vote);
			content.setImage(image);
			return content;
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
