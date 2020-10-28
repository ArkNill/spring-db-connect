package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.com.inspect.dto.Sound;

public class DocsReport {
	private String docsFile = 
			new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) 
			+ "_log.docs";
	
	public void writeDocs(String path, List<Sound> list) {
		
	}
}
