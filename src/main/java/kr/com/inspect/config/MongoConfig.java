package kr.com.inspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {
	
	private String hostname = "localhost";
	private int port = 27017;
	
	
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(hostname, port);
	}
}
