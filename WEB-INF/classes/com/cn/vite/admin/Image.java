package com.cn.vite.admin;

/**
 * ͼ����Ϣ
 */
public class Image {
	//��ѡ��id
	private int id;
	//ͷ��·��
	private String path;
	//ͷ������ĺ�ѡ����ϸ��Ϣ
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
