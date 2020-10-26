package kr.com.inspect.dao.impl;

import org.bson.Document;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.MongoDao;

@Repository
@SuppressWarnings("deprecation")
public class MongoDaoImpl implements MongoDao {
	@Autowired
	private MongoClient mongoClient;
	
	@Autowired
	private ElasticDao elasticDao;
	
	/* 자원 회수 */
	@Override
	public void close() {
		mongoClient.close();
	}
	
	/* 몽고DB에 엘라스틱서치에서 받아온 인덱스 데이터를 입력하기 */
	@Override
	public void insertElasticIndex(String database, String col, String index) {
		// 인덱스를 통해 엘라스틱서치에서 데이터를 받아옴
		SearchHit[] searchHits = elasticDao.getAllIndex(index);
		
		DB DB = mongoClient.getDB(database);
        DBCollection collection = DB.getCollection(col);

        String json;
        DBObject dbObject;
        
        // for문을 돌며 MongoDB에 insert
        // String을 json형태로 바꿔서 MongoDB에 저장
        for(SearchHit hit: searchHits) {
            json = hit.getSourceAsString();
            System.out.println(json);
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
