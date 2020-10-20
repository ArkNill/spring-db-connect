package kr.co.inspect;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.inspect.config.ElasticConfig;
import kr.co.inspect.vo.ElasticDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ElasticConfig.class) 
public class ElasticTest {
	public static @ClassRule ElasticAvailable elasticAvailable = ElasticAvailable.onLocalhost();

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired ElasticsearchOperations operations;

	@Test
	public void textSearch() throws ParseException {
		String expectedDate = "2020-10-20";
		String expectedWord = "회의";
		CriteriaQuery query = new CriteriaQuery(
				new Criteria("content").contains(expectedWord).and(new Criteria("date").greaterThanEqual(expectedDate)));
		System.out.println(expectedDate + expectedWord);
		SearchHits<ElasticDTO> result = operations.search(query, ElasticDTO.class, IndexCoordinates.of("audiolist"));

		assertThat(result).hasSize(3);

		for (SearchHit<ElasticDTO> elastic : result) {
			assertThat(elastic.getContent().getContent()).contains(expectedWord);
			assertThat(format.parse(elastic.getContent().getDate())).isAfter(format.parse(expectedDate));
		}
	}
}
