package kr.com.inspect.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.com.inspect.dto.Sound;

@Service
@PropertySource(value = "classpath:report.properties") 
public class PptxReport {
	@Value("${table.column0}") 
	private String column0;
	
	@Value("${table.column1}") 
	private String column1;
	
	@Value("${table.column2}") 
	private String column2;
	
	@Value("${table.column3}") 
	private String column3;
	
	@Value("${table.column4}") 
	private String column4;
	
	public void writePptx(String path, List<Sound> list) {
		String pptxFileName = 
				new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) 
				+ "_log.pptx";
		
		XMLSlideShow ppt = new XMLSlideShow();
		
		
		File file = new File(path + pptxFileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			ppt.write(fos);
			System.out.println(path + pptxFileName);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				if(ppt!=null) ppt.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
	}
}
