package com.mycom.sound.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "audiolist", type = "sound")
@Builder
public class ElasticSound {
	@Id
	private String id;
	private String category;
	private String title;
	private String company;
	private String content;
}
