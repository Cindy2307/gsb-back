package com.ecolepratique.rapport;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ApplicationIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testAllRapport() throws JSONException {
		String response = restTemplate.getForObject("/rapport", String.class);
		System.out.println("ItemControllerIT - testAllRapports response=" + response);
		JSONAssert.assertEquals("[{id:2},{id:3},{id:5},{id:6},{id:7}]", response, false);
	}
}
