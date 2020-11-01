package kr.com.inspect.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.com.inspect.dto.Sound;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class Test2Report {

	public static void main(String[] args) {
		List<Sound> list = new ArrayList<>();
		list.add(new Sound("테스트1", "테스트1", "테스트1", "테스트1", "테스트1"));
		list.add(new Sound("테스트2", "테스트2", "테스트2", "테스트2", "테스트2"));
		String path = "C:\\kyh\\export\\excel\\";
		Test2Report testReport = new Test2Report();
		testReport.run(path, list);

	}

	public void run(String path, List<Sound> list) {
		String hwpFileName = 
				new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) 
				+ "_log.hwp";
		
		try {
			HWPFile hwpFile = BlankFileMaker.make();
			Paragraph p = hwpFile.getBodyText().getSectionList().get(0).addNewParagraph();
			p.createText();
			ParaText pt = p.getText();
			pt.addString("테스트~~~");
			HWPWriter.toFile(hwpFile, path+hwpFileName );
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}
}
