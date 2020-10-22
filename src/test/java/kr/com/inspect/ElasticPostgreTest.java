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

import kr.com.inspect.dto.Sound;

public class ElasticPostgreTest {
	
	@Autowired
	RestHighLevelClient elasticClient;
	
	/* 엘라스틱서치 */
	private String index = "audiolist";
	
	/* 자원 회수 */
	public void closeResources() {
		try {
			elasticClient.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		insertElasticIndexToPostgre(index);
		closeResources();
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
	public void insertElasticIndexToPostgre(String index) {
		// 인덱스를 통해 엘라스틱서치에서 데이터를 받아옴
		SearchHit[] searchHits = getAllIndexInElastic(index);
		
        String json;
        DBObject dbObject;
        
        // for문을 돌며 json형태의 키값을 뽑아내어 Sound 객체에 바인딩
        for(SearchHit hit: searchHits) {
            json = hit.getSourceAsString();
            dbObject = (DBObject)JSON.parse(json);    
        }
	}
}
