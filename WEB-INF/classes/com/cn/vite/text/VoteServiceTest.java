package com.cn.vite.text;

import java.util.List;

import org.junit.Test;

import com.cn.vite.admin.Info;
import com.cn.vite.admin.Vote;
import com.cn.vite.service.VoteService;

public class VoteServiceTest {
	VoteService service = new VoteService();
	/**
	 * @see ��ѯ���к�ѡ��ҵ������
	 * @throws Exception
	 */
	@Test
    public void test() throws Exception{
    	List<Vote> list = new VoteService().findAllVote();
    	System.out.println(list);
    	
    	List<Info> list2 = service.findAllInfo();
    	System.out.println(list2);
    }
}
