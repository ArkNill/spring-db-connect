package kr.com.inspect.dao.impl;

import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.PostgreDao;
import kr.com.inspect.dto.Sound;
import kr.com.inspect.mapper.PostgreMapper;

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
	public void insertPostgre(String index) {
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
}
