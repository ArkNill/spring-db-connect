package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.com.inspect.dto.Sound;

public class PptxReport {
	private String pptxFile = 
			new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) 
			+ "_log.pptx";
	
	public void writePptx(String path, List<Sound> list) {
		
	}
}
