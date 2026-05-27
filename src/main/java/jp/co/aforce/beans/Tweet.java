package jp.co.aforce.beans;

import java.io.Serializable;

public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private String postedAt;
	private String author;
	//削除フラグを追加
	private int deleteflug;

	public Tweet() {
	}
	
	//削除フラグを追加
	public Tweet(int id, String content, String postedAt, String author, int deleteflug) {
		this.id = id;
		this.content = content;
		this.postedAt = postedAt;
		this.author = author;
		this.deleteflug = deleteflug;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	//削除フラグを追加
	public int getDeleteflug() {
		return deleteflug;
	}

	public void setDeleteflug(int deleteflug) {
		this.deleteflug = deleteflug;
	}
}
