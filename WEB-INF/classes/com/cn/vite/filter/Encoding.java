package com.cn.vite.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ������������Ӧ�ı����ʽ
 *
 */
public class Encoding implements Filter {
	private Map<String, String> map = new HashMap<String, String>();
    public Encoding() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding = map.get("encoding");
		// ������������ʽ
		request.setCharacterEncoding(encoding);
		// ������Ӧ�����ʽ
		response.setContentType("text/html;charset=" + encoding);
		response.setCharacterEncoding(encoding);
//		System.out.println("�������Ѿ����ñ����ʽ:"+encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		Enumeration<String> en = config.getInitParameterNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = config.getInitParameter(key);
			map.put(key, value);
		}
	}

}
