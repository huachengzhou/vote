package com.cn.vite.admin;

/**
 * 图像信息
 */
public class Image {
	//候选人id
	private int id;
	//头像路径
	private String path;
	//头像关联的候选人详细信息
	private Content content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", path=" + path + ", content=" + content + "]";
	}
	public Image(String path) {
		super();
		this.path = path;
	}
	public Image() {
	}
}
