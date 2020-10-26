package kr.com.inspect.dao;

public interface MongoDao {
	public void close();
	void insertElasticIndex(String database, String col, String index);
}
