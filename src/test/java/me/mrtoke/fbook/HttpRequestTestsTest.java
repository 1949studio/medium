package me.mrtoke.fbook;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTestsTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void ifHomePageReturnsWelcomeCorrectly_ThenSuccess() {
		String renderHtml = this.restTemplate.getForObject("http://localhost:" + port, String.class);
		System.out.println("Pauline Hanson");
		assertEquals(renderHtml.contains("Welcome to Kawthoolei.Dev"), true);
	}
}
