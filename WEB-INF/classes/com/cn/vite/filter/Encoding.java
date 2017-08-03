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
 * 设置请求与响应的编码格式
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
		// 设置请求编码格式
		request.setCharacterEncoding(encoding);
		// 设置响应编码格式
		response.setContentType("text/html;charset=" + encoding);
		response.setCharacterEncoding(encoding);
//		System.out.println("过滤器已经设置编码格式:"+encoding);
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
