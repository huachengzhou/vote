package com.cn.vite.text;

import java.sql.SQLException;

import com.cn.vite.admin.Content;
import com.cn.vite.admin.Image;
import com.cn.vite.admin.Vote;
import com.cn.vite.dao.DataDao;

public class DataDaoTest {
	protected DataDao dao = new DataDao();
    public void add(){
    	Vote vote = new Vote();
    	vote.setContent("小狗");
    	vote.setTicket(2);
    	
    	Content content = new Content();
    	content.setAge(5);
    	content.setDescription("看门");
    	content.setVote(vote);
    	
    	Image image = new Image();
    	image.setContent(content);
    	image.setPath("images/dog.jpg");
    	try {
			dao.add(vote, content, image);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void remove(int id){
    	boolean flag = false;
    	try {
			flag = dao.remove(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(flag);
    }
    public static void main(String[] args) {
    	DataDaoTest test = new DataDaoTest();
    	test.add();//运行之后选取第一个主键值传入remove()
//    	test.remove(14);
    	System.out.println("over");
	}
}
