package kr.com.inspect.repository.impl;

import java.io.IOException;

import org.bson.Document;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import kr.com.inspect.repository.TestRepository;

@Repository
public class TestRepositoryImpl implements TestRepository {
	@Autowired
	private RestHighLevelClient elasticClient;
	
	@Autowired
	private MongoClient mongoClient;
	
	/* 엘라스틱서치 */
	private String index = "audiolist";
	
	/* 몽고DB */
	private String database = "sound";
	private String col  = index;
	
	/* 자원 회수 */
	public void closeElastic() {
		try {
			elasticClient.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@Override
	public void testMongoInsert() {
		MongoDatabase DB = mongoClient.getDatabase(database);
		MongoCollection<Document> collection = DB.getCollection(col);
		String json = "{'person1' : 'anna', 'person2' : 'olaf'}}";
		Document document = new Document()
					.append("name", "elsa")
					.append("age", "20")
					.append("family", JSON.parse(json));
		collection.insertOne(document);
			      
		// db.test.find()
		FindIterable<Document> documents = collection.find();
		System.out.println(String.format("\n%s collection",col));
		for (Document doc : documents){
			System.out.println(doc.toJson());
		}
		mongoClient.close();
	}

	@Override
	public void testPostgreInsert() {
		
	}
}
