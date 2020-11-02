package kr.com.inspect.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.springframework.beans.factory.annotation.Value;

import kr.com.inspect.dto.Sound;

public class TestReport {
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
	
	public void writeDocx(String path, List<Sound> list) {
		String docxFileName = 
				new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) 
				+ "_log.docx";
		
		System.out.println("테스트");
		
		XWPFDocument doc = new XWPFDocument();
		XWPFTable table = doc.createTable(list.size()+1, 5);
		
		/* 헤더 정보 구성 */
		table.getRow(0).getCell(0).setText(column0);
		table.getRow(0).getCell(1).setText(column1);
		table.getRow(0).getCell(2).setText(column2);
		table.getRow(0).getCell(3).setText(column3);
		table.getRow(0).getCell(4).setText(column4);
		
		Sound vo;
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			table.getRow(rowIdx+1).getCell(0).setText(vo.getId());
			table.getRow(rowIdx+1).getCell(1).setText(vo.getCategory());
			table.getRow(rowIdx+1).getCell(2).setText(vo.getTitle());
			table.getRow(rowIdx+1).getCell(3).setText(vo.getCompany());
			table.getRow(rowIdx+1).getCell(4).setText(vo.getContent());
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File(path + docxFileName);
		FileOutputStream fos = null;
		System.out.println(path + docxFileName);
				
		try {
			fos = new FileOutputStream(file);
			doc.write(fos);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				if(doc!=null) doc.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TestReport testReport = new TestReport();
		List<Sound> list = new ArrayList<>();
		Sound sound = new Sound();
		sound.setId("테스트1");
		sound.setCompany("테스트2");
		sound.setCategory("테스트3");
		sound.setContent("테스트4");
		sound.setTitle("테스트5");
		list.add(sound);
		testReport.writeDocx("C:\\kyh\\", list);
	}
	
	
}
