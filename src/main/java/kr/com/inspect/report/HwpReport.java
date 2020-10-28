package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.com.inspect.dto.Sound;

public class HwpReport {
	private String hwpFile = 
			new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) 
			+ "_log.hwp";
	
	public void writeHwp(String path, List<Sound> list) {
		
	}
}
