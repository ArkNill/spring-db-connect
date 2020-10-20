package kr.co.inspect.vo;

import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Builder;
import lombok.Data;

/* 엘라스틱서치로부터 데이터를 받아올 DTO */
@Data
@Builder
@Document(indexName = "audiolist", type = "sound", shards = 1, replicas = 0,
		refreshInterval = "-1")
public class ElasticDTO {
	private @Id String id;
	private String label;
	private String title;
	private @Field(type = Date) String date;
	private String company;
	private String content;
	
	public ElasticDTO() {};
	
	public ElasticDTO(String id, String label, String title, String date, String company, String content) {
		super();
		this.id = id;
		this.label = label;
		this.title = title;
		this.date = date;
		this.company = company;
		this.content = content;
	}
}
