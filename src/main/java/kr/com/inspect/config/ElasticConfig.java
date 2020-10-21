package kr.com.inspect.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
public class ElasticConfig {
	
	/* ElasticSearch */
	String hostname = "localhost";
	int port = 9200;
	String scheme = "http";
	
	@Bean
	public RestHighLevelClient restHighLevelClient() {
		return new RestHighLevelClient(
	            RestClient.builder(
	                    new HttpHost(hostname, port, scheme)));
	}
}
