package kr.com.inspect.dao;

import java.util.List;

import org.bson.Document;

public interface MongoDao {
	public void close();
	public void insertElasticIndex(String database, String col, String index);
	public void insertJSONData(String database, String col, String fullPath);
	public List<Document> getCollection(String database, String col);
}
