package com.cn.vite.text;

import org.junit.Test;

import com.cn.vite.admin.Content;
import com.cn.vite.service.ContentService;
/**
 * 
 * ���� ��ѯ��ѡ����ϸ��Ϣ
 *
 */
public class ContentServiceTest {
    private ContentService service = new ContentService();
    @Test
    public void text()throws Exception{
    	Content content = service.findContentById(1);
    	System.out.println(content.getAge());
    	System.out.println(content);
    }
}
