package kr.com.inspect.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.com.inspect.dto.Sound;

public class ExcelWriter {
	
	private String s = File.separator; //디렉토리 구분자
	private String route = 
			"C:" +s+ "kyh" +s+ "export" +s+ "excel" +s;
	private String xlsFile = "test.xls";
	private String xlsxFile = "test.xlsx";
	
	public void xlsWiter(List<Sound> list) {
		// 워크북 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 워크시트 생성
		HSSFSheet sheet = workbook.createSheet();
		// 행 생성
		HSSFRow row = sheet.createRow(0);
		// 쎌 생성
		HSSFCell cell;
		
		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("아이디");
		
		cell = row.createCell(1);
		cell.setCellValue("카테고리");
		
		cell = row.createCell(2);
		cell.setCellValue("제목");
		
		cell = row.createCell(3);
		cell.setCellValue("회사");
		
		cell = row.createCell(4);
		cell.setCellValue("내용");
		
		// 리스트의 size 만큼 row를 생성
		Sound vo;
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			
			// 행 생성
			row = sheet.createRow(rowIdx+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getId());
			
			cell = row.createCell(1);
			cell.setCellValue(vo.getCategory());
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getTitle());
			
			cell = row.createCell(3);
			cell.setCellValue(vo.getCompany());
			
			cell = row.createCell(4);
			cell.setCellValue(vo.getContent());
			
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File(route + xlsFile);
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void xlsxWiter(List<Sound> list) {
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행 생성
		XSSFRow row = sheet.createRow(0);
		// 쎌 생성
		XSSFCell cell;
		
		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("아이디");
		
		cell = row.createCell(1);
		cell.setCellValue("카테고리");
		
		cell = row.createCell(2);
		cell.setCellValue("제목");
		
		cell = row.createCell(3);
		cell.setCellValue("회사");
		
		cell = row.createCell(4);
		cell.setCellValue("내용");
		
		// 리스트의 size 만큼 row를 생성
		Sound vo;
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			
			// 행 생성
			row = sheet.createRow(rowIdx+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getId());
			
			cell = row.createCell(1);
			cell.setCellValue(vo.getCategory());
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getTitle());
			
			cell = row.createCell(3);
			cell.setCellValue(vo.getCompany());
			
			cell = row.createCell(4);
			cell.setCellValue(vo.getContent());
			
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File(route + xlsxFile);
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
