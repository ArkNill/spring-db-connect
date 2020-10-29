package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.com.inspect.dto.Sound;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class TestReport {

	public static void main(String[] args) {
		List<Sound> list = new ArrayList<>();
		list.add(new Sound("테스트1", "테스트1", "테스트1", "테스트1", "테스트1"));
		list.add(new Sound("테스트2", "테스트2", "테스트2", "테스트2", "테스트2"));
		String path = "";

	}

	public void run(String path, List<Sound> list) {
		String hwpFileName = 
				new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) 
				+ "_log.hwp";
		
		try {
			HWPFile hwpFile = BlankFileMaker.make( );
			ArrayList<Section> sList = hwpFile.getBodyText( ).getSectionList( );
			System.out.println(sList.size());
			
			Sound vo;
			for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
				vo = list.get(rowIdx);
				Paragraph p = sList.get(0).getParagraph(rowIdx);
				p.getText().addString(vo.toString());
			}			
			HWPWriter.toFile(hwpFile, path+hwpFileName);
			System.out.println(path + hwpFileName);
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}
}
