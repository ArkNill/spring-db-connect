package kr.co.inspect;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.Assumptions;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ElasticAvailable  implements TestRule {
	
	private final String url;
	
	private ElasticAvailable(String url) { //엘라스틱서치 서버 주소 지정
		this.url = url;
	}
	
	public static ElasticAvailable onLocalhost() { //localhost 서버
		return new ElasticAvailable("http://localhost:9200");
	}

	@Override
	public Statement apply(final Statement base, Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				checkServerRunning();
				base.evaluate();
			}
		};
	}
	
	/* 서버가 가동 중인지 체크 */
	private void checkServerRunning() {
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			CloseableHttpResponse response = client.execute(new HttpHead(url));
			if (response != null && response.getStatusLine() != null) {
				Assumptions.assumeThat(response.getStatusLine().getStatusCode()).isEqualTo(200); // 상태코드 200 = 성공
			}
		} catch (IOException e) {
			throw new AssumptionViolatedException(String.format("Elasticsearch Server seems to be down. %s", e.getMessage()));
		}
	}
	
}
