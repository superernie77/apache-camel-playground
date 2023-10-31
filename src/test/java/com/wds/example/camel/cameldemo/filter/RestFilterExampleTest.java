package com.wds.example.camel.cameldemo.filter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest
class RestFilterExampleTest {

	private RestTemplate template = new RestTemplate();
	
	@Test
	void testRouteFilterTrue() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8080).host("localhost")
				.path("/hello").build();

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Hello pass!"));	
	}
	
	@Test
	@Disabled
	void testRouteFilterFalse() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8085).host("localhost")
				.path("/filter").path("/{text}").buildAndExpand("skip");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result == null);	
	}
}
