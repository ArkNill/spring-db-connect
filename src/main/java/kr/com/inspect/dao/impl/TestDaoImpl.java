package kr.com.inspect.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;

import kr.com.inspect.dao.TestDao;
import kr.com.inspect.dto.Sound;
import kr.com.inspect.mapper.PostgreMapper;

@Repository
public class TestDaoImpl implements TestDao {
	@Autowired
	private PostgreMapper postgreMapper;
	
	public List<Sound> testPostgreFind() {
		return postgreMapper.findAll();
	}

	@Override
	public void insertPostgre(List<Sound> soundList) {
		// TODO Auto-generated method stub
		
	}
}
