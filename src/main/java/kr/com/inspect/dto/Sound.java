package kr.com.inspect.dto;

public class Sound {
	private String id;
	private String category;
	private String title;
	private String company;
	private String content;
	
	public Sound() {}
	public Sound(String id, String category, String title, String company, String content) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.company = company;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Sound [id=" + id + ", category=" + category + ", title=" + title + ", company=" + company + ", content="
				+ content + "]";
	}
}
