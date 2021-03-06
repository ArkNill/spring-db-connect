package kr.com.inspect.dto;

public class EojeolList {
	private String id; //primary key
	private String standard;
	private String eojeol;
	private int end;
	private boolean isDialect;
	private int begin;
	private String utterance_id; //foreign key
	
	public EojeolList() {}
	public EojeolList(String id, String standard, String eojeol, int end, boolean isDialect, int begin,
			String utterance_id) {
		super();
		this.id = id;
		this.standard = standard;
		this.eojeol = eojeol;
		this.end = end;
		this.isDialect = isDialect;
		this.begin = begin;
		this.utterance_id = utterance_id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getEojeol() {
		return eojeol;
	}
	public void setEojeol(String eojeol) {
		this.eojeol = eojeol;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isDialect() {
		return isDialect;
	}
	public void setDialect(boolean isDialect) {
		this.isDialect = isDialect;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public String getUtterance_id() {
		return utterance_id;
	}
	public void setUtterance_id(String utterance_id) {
		this.utterance_id = utterance_id;
	}
	
	@Override
	public String toString() {
		return "EojeolList [id=" + id + ", standard=" + standard + ", eojeol=" + eojeol + ", end=" + end
				+ ", isDialect=" + isDialect + ", begin=" + begin + ", utterance_id=" + utterance_id + "]";
	}
}
