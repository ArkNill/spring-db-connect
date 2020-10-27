package kr.com.inspect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.PostgreDao;
import kr.com.inspect.dto.Sound;

@Controller
public class PostgreController {
	@Autowired
	private PostgreDao postgreDao;
	
	@Autowired
	private ElasticDao elasticDao;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	//PostgreSQL
	
	/* PostgreSQL 페이지 이동 */
	@GetMapping("/postgrePage")
	public String moveToElasticPage() {
		return "postgreSQL/postgrePage";
	}
	
	/* 엘라스틱서치 특정 인덱스를 PostgreSQL 특정 테이블에 넣기 */
	@GetMapping("/insertElasticIndexToPostgre")
	public String insertElasticIndexToPostgre() {
		Sound sound1 = new Sound();
		sound1.setCategory("lecture");
		sound1.setTitle("테스트강의1");
		sound1.setCompany("테스트회사1");
		sound1.setContent("테스트 강의1 내용~~~~~~~~~~");
		
		Sound sound2 = new Sound();
		sound2.setCategory("meeting");
		sound2.setContent("테스트회의1");
		sound2.setCompany("테스트회사2");
		sound2.setTitle("테스트 회의1 내용~~~~~~~~~~~");
		
		List<Sound> list = new ArrayList<>();
		list.add(sound1);
		list.add(sound2);
		
		postgreDao.insertPostgre(list);
		
		return "postgreSQL/insertElasticIndex";
	}
	
	/* PostgreSQL 특정 테이블 가져오기 */
	@GetMapping("/getPostgreTable")
	public String getPostgreTable(Model model) {
		List<Sound> soundList = postgreDao.testPostgreFind();
		for(Sound sound : soundList) {
			System.out.println(sound.getTitle());
		}
		model.addAttribute("result", soundList);
		return "postgreSQL/getTable";
	}
}
