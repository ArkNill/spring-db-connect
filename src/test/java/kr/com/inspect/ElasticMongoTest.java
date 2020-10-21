package kr.com.inspect;

import java.io.IOException;

import org.bson.Document;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class ElasticMongoTest {
	
	@Autowired
	RestHighLevelClient elasticClient;
	
	@Autowired
	MongoClient mongoClient;
	
	/* 엘라스틱서치 */
	private String index = "audiolist";
	
	/* 몽고DB */
	private String database = "testDB";
	private String col  = index;
	
	/* 자원 회수 */
	public void closeResources() {
		mongoClient.close();
		try {
			elasticClient.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		SearchHit[] searchHits = getAllIndexInElastic(index);
		
		insertElasticIndexToMongo(index, database, col);
	}
	
	/* 엘라스틱서치에서 해당되는 인덱스에 있는 데이터 모두 가져오기 */
	public SearchHit[] getAllIndexInElastic(String index) {
		// 엘라스틱서치 index 설정
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = new SearchRequest().indices(index);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        
        try {
            searchResponse = elasticClient.search(searchRequest, RequestOptions.DEFAULT);
        }catch (IOException e){
            System.out.println("search error");
        }
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        return searchHits;
	}
	
	/* 몽고DB에 엘라스틱서치에서 받아온 인덱스 데이터를 입력하기 */
	public void insertElasticIndexToMongo(String index, String database, String col) {
		// 인덱스를 통해 엘라스틱서치에서 데이터를 받아옴
		SearchHit[] searchHits = getAllIndexInElastic(index);
		
		@SuppressWarnings("deprecation")
		DB DB = mongoClient.getDB(database);
        DBCollection collection = DB.getCollection(col);

        String json;
        DBObject dbObject;
        
        // for문을 돌며 MongoDB에 insert
        // String 을 json형태로 바꿔서 MongoDB에 저장
        for(SearchHit hit: searchHits) {
            json = hit.getSourceAsString();
            dbObject = (DBObject)JSON.parse(json);
            collection.insert(dbObject);
        }
        
        // db.test.find()
        MongoDatabase mDB = mongoClient.getDatabase(database);
        MongoCollection<Document> mCollection = mDB.getCollection(col);
        FindIterable<Document> documents = mCollection.find();
        System.out.println(String.format("\n%s collection",col));
        for (Document doc : documents){
            System.out.println(doc.toJson());
        }
	}
}
