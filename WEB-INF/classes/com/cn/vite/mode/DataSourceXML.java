package com.cn.vite.mode;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 从DataSource.xml读取各个数据库的信息(目前读取DB2,RT,RT3)
 * @author noatnu_DataSourceXML
 *
 */
public class DataSourceXML {

	private final static String[] strs = new String[] { "/com/cn/vite/ini/DataSource.xml", "driver", "url", "username",
			"password" };
    /**
     * @see 获取DB2数据库信息
     * @param data
     * @return
     * @throws DocumentException
     */
	public static String getDB2(String data) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = DataSourceXML.class.getResourceAsStream(strs[0]);
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);

		Element driver = (Element) document.selectNodes("//" + strs[1]).get(0);
		Element url = (Element) document.selectNodes("//" + strs[2]).get(0);
		Element username = (Element) document.selectNodes("//" + strs[3]).get(0);
		Element password = (Element) document.selectNodes("//" + strs[4]).get(0);

		map.put(strs[1], driver.getText());
		map.put(strs[2], url.getText());
		map.put(strs[3], username.getText());
		map.put(strs[4], password.getText());

		return map.get(data);
	}
    /**
     * @see 获取RT数据库信息
     * @param data
     * @return
     * @throws DocumentException
     */
	public static String getRT(String data) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = DataSourceXML.class.getResourceAsStream(strs[0]);
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);

		Element driver = (Element) document.selectNodes("//" + strs[1]).get(1);
		Element url = (Element) document.selectNodes("//" + strs[2]).get(1);
		Element username = (Element) document.selectNodes("//" + strs[3]).get(1);
		Element password = (Element) document.selectNodes("//" + strs[4]).get(1);

		map.put(strs[1], driver.getText());
		map.put(strs[2], url.getText());
		map.put(strs[3], username.getText());
		map.put(strs[4], password.getText());

		return map.get(data);
	}
    /**
     * @see 获取RT3数据库信息
     * @param data
     * @return
     * @throws DocumentException
     */
	public static String getRT3(String data) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = DataSourceXML.class.getResourceAsStream(strs[0]);
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);

		Element driver = (Element) document.selectNodes("//" + strs[1]).get(2);
		Element url = (Element) document.selectNodes("//" + strs[2]).get(2);
		Element username = (Element) document.selectNodes("//" + strs[3]).get(2);
		Element password = (Element) document.selectNodes("//" + strs[4]).get(2);

		map.put(strs[1], driver.getText());
		map.put(strs[2], url.getText());
		map.put(strs[3], username.getText());
		map.put(strs[4], password.getText());

		return map.get(data);
	}

}
