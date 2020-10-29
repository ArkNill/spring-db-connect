package kr.com.inspect.dto;

import java.util.List;

public class Utterance {
	private String id;
	private String note;
	private String standard_form;
	private String form;
	private double start;
	private double end;
	private List<EojeolList> eojoelList;
	
	public Utterance() {}
	public Utterance(String id, String note, String standard_form, String form, int start, int end,
			List<EojeolList> eojoelList) {
		super();
		this.id = id;
		this.note = note;
		this.standard_form = standard_form;
		this.form = form;
		this.start = start;
		this.end = end;
		this.eojoelList = eojoelList;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStandard_form() {
		return standard_form;
	}
	public void setStandard_form(String standard_form) {
		this.standard_form = standard_form;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public double getStart() {
		return start;
	}
	public void setStart(double start) {
		this.start = start;
	}
	public double getEnd() {
		return end;
	}
	public void setEnd(double end) {
		this.end = end;
	}
	public List<EojeolList> getEojoelList() {
		return eojoelList;
	}
	public void setEojoelList(List<EojeolList> eojoelList) {
		this.eojoelList = eojoelList;
	}
	
	@Override
	public String toString() {
		return "Utterance [id=" + id + ", note=" + note + ", standard_form=" + standard_form + ", form=" + form
				+ ", start=" + start + ", end=" + end + ", eojoelList=" + eojoelList + "]";
	}
}
