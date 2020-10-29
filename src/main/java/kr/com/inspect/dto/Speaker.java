package kr.com.inspect.dto;

public class Speaker {
	private int id; //autoincrement
	private int no;
	private int shortcut;
	private String occupation;
	private String sex;
	private String name;
	private int age;
	
	public Speaker() {}
	public Speaker(int id, int no, int shortcut, String occupation, String sex, String name, int age) {
		super();
		this.id = id;
		this.no = no;
		this.shortcut = shortcut;
		this.occupation = occupation;
		this.sex = sex;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getShortcut() {
		return shortcut;
	}
	public void setShortcut(int shortcut) {
		this.shortcut = shortcut;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Speaker [id=" + id + ", no=" + no + ", shortcut=" + shortcut + ", occupation=" + occupation + ", sex="
				+ sex + ", name=" + name + ", age=" + age + "]";
	}
}
