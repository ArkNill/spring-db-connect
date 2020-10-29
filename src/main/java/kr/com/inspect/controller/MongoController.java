package kr.com.inspect.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.MongoDao;

@Controller
public class MongoController {
	@Autowired
	private MongoDao mongoDao;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	//몽고DB
	private String database = "audioDB";
	private String col = index;
	
	/* 엘라스틱서치 페이지 이동 */
	@GetMapping("/mongoPage")
	public String moveToElasticPage() {
		return "mongoDB/mongoPage";
	}
	
	/* 엘라스틱서치 특정 인덱스를 몽고DB 특정 컬렉션에 넣기 */
	@GetMapping("/insertElasticIndexIntoMongo")
	public String insertElasticIndexIntoMongo() {
		mongoDao.insertElasticIndex(database, col, index);
		return "mongoDB/insertElasticIndex";
	}
	
	/* 몽고DB 특정 컬렉션 가져오기 */
	@GetMapping("/getMongoCollection")
	public String getMongoCollection(Model model) {
		List<Document> list = mongoDao.getCollection(database, col);
		model.addAttribute("result", list);
		return "mongoDB/getCollection";
	}
	
	@GetMapping("/insertJSONData")
	public String insertJSONData() {
		String fullPath = "C:\\kyh\\json\\1773b6eb-d433-4f58-98bc-9f780055661f_STT 16.json";
		mongoDao.insertJSONData(database, col, fullPath);
		return "mongoDB/insertJSONData";
	}
}
