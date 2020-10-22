package kr.com.inspect.repository;

import org.elasticsearch.search.SearchHit;

public interface DataRepository {
	public SearchHit[] getAllIndexInElastic();
	public void insertElasticIndexToMongo();
}
