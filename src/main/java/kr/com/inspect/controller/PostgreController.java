package kr.com.inspect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.PostgreDao;
import kr.com.inspect.dto.Sound;

@Controller
public class PostgreController {
	@Autowired
	private PostgreDao postgreDao;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	/* PostgreSQL 페이지 이동 */
	@GetMapping("/postgrePage")
	public String moveToElasticPage() {
		return "postgreSQL/postgrePage";
	}
	
	/* 엘라스틱서치 특정 인덱스를 PostgreSQL 특정 테이블에 넣기 */
	@GetMapping("/insertElasticIndexIntoPostgre")
	public String insertElasticIndexIntoPostgre() {
		postgreDao.insertElasticIndex(index);
		return "postgreSQL/insertElasticIndex";
	}
	
	/* PostgreSQL 특정 테이블 가져오기 */
	@GetMapping("/getPostgreTable")
	public String getPostgreTable(Model model) {
		List<Sound> soundList = postgreDao.getTable();
		model.addAttribute("result", soundList);
		return "postgreSQL/getTable";
	}
}
