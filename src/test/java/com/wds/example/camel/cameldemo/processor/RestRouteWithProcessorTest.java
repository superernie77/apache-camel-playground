package com.wds.example.camel.cameldemo.processor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RestRouteWithProcessorTest {

	private RestTemplate template = new RestTemplate();
	
	@Test
	void testHelloWithProcessor() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8080).host("localhost")
				.path("camel/hellowithprocessor").path("/{message}").buildAndExpand("Max");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Hello Max processed!"));	
	}
}
