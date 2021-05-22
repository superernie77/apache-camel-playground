package com.wds.example.camel.cameldemo.greeter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest
class GreeterRouteTest {

	
	private RestTemplate template = new RestTemplate();
	
	@Test
	void testHello() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8085).host("localhost")
				.path("/hello").path("/{message}").buildAndExpand("Max");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Hello Max!"));
		
	}

}
