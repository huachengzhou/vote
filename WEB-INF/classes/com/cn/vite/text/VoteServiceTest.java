package com.cn.vite.text;

import java.util.List;

import org.junit.Test;

import com.cn.vite.admin.Info;
import com.cn.vite.admin.Vote;
import com.cn.vite.service.VoteService;

public class VoteServiceTest {
	VoteService service = new VoteService();
	/**
	 * @see 查询所有候选人业务层测试
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
