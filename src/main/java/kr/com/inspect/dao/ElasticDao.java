package kr.com.inspect.dao;

import org.elasticsearch.search.SearchHit;

public interface ElasticDao {
	public void close();
	public SearchHit[] getAllIndex(String index);
}
