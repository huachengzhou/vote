package com.cn.vite.text;

import java.sql.SQLException;

import com.cn.vite.admin.Image;
import com.cn.vite.dao.ImageDao;

public class ImageTest {
    public static void main(String[] args) throws SQLException {
		Image image = null;
		image = new ImageDao().findImageById(1);
		System.out.println(image);
	}
}
