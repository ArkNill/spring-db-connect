package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.com.inspect.dto.Sound;

@Service
@PropertySource(value = "classpath:report.properties") 
public class PptxReport {
	private String pptxFile = 
			new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) 
			+ "_log.pptx";
	
	public void writePptx(String path, List<Sound> list) {
		
	}
}
