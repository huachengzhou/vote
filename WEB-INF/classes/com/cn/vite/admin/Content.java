package com.cn.vite.admin;

public class Content {
	// ���
	private int id;
	// ����
	private int age;
	// ְλ����
	private String description;
	//ͷ��
	private Image image;
	private Vote vote;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	public Content() {
		super();
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", age=" + age + ", description=" + description + ", image=" + image + ", vote="
				+ vote + "]";
	}
	public Content(int age, String description) {
		super();
		this.age = age;
		this.description = description;
	}
}
