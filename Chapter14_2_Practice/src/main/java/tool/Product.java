package tool;

import java.sql.Timestamp;

public class Product {
	private int id;
	private String name;
    private String content;
    private Timestamp postDate;


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
	
	public Timestamp getPostDate() {
		return postDate;
	}

}
