package kr.com.inspect.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.PostgreDao;
import kr.com.inspect.dto.EojeolList;
import kr.com.inspect.dto.Metadata;
import kr.com.inspect.dto.Sound;
import kr.com.inspect.dto.Speaker;
import kr.com.inspect.dto.Utterance;
import kr.com.inspect.mapper.PostgreMapper;
import kr.com.inspect.parser.JsonParsing;

@Repository
public class PostgreDaoImpl implements PostgreDao {
	@Autowired
	private PostgreMapper postgreMapper;
	
	@Autowired
	private ElasticDao elasticDao;
	
	@Override
	public List<Sound> getTable() {
		return postgreMapper.getTable();
	}

	@Override
	public void insertElasticIndex(String index) {
		// 인덱스를 통해 엘라스틱서치에서 데이터를 받아옴
		SearchHit[] searchHits = elasticDao.getIndex(index);
		
		for(SearchHit hit: searchHits) {
			Map<String, Object> map = hit.getSourceAsMap();
			
			Sound sound = new Sound();
			sound.setId(hit.getId());
			sound.setCategory((String)map.get("category"));
			sound.setTitle((String)map.get("title"));
			sound.setCompany((String)map.get("company"));
			sound.setContent((String)map.get("content"));
			
			postgreMapper.insertValue(sound);
		}
	}
	
	@Override
	public void insertJSONObject(String fullPath) {
		/* json 파일을 읽어서 객체로 파싱 */
		JsonParsing jsonParsing = new JsonParsing();
		JSONObject obj = jsonParsing.getJSONObject(fullPath);
		
		/* metadata 테이블 입력 */
		Metadata metadata  = jsonParsing.setMetadata(obj);
		postgreMapper.insertIntoMetadata(metadata); 
		
		/* metadata_id를 가져옴(creator, title) */
		Map map = new HashMap();
		map.put("creator", metadata.getCreator());
		map.put("title", metadata.getTitle());
		int metadata_id = postgreMapper.getMetadataId(map);
		
		/* speaker 테이블 입력 */
		List<Speaker> speakerList = jsonParsing.setSpeaker(obj, metadata_id);
		for(Speaker speaker : speakerList) {
			postgreMapper.insertIntoSpeaker(speaker);
		}
		
		/* utterance 테이블 입력 */
		List<Utterance> utteranceList = jsonParsing.setUtterance(obj, metadata_id);
		for(Utterance utterance : utteranceList) {
			postgreMapper.insertIntoUtterance(utterance); //utterance 입력
			List<EojeolList> eojeolListList = utterance.getEojoelList();
			for(EojeolList eojeolList : eojeolListList) {
				postgreMapper.insertIntoEojeolList(eojeolList); //eojeolList 입력
			}
		}
	}
}
