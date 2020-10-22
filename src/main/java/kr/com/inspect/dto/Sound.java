package kr.com.inspect.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sound")
@Data
public class Sound {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sound_id")
	String id;
	String category;
	String title;
	String company;
	String content;
}
