package com.wds.example.camel.cameldemo.transform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RestRouteWithTransformTest {

	private RestTemplate template = new RestTemplate();
	
	@Test
	void testHelloWithProcessor() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8080).host("localhost")
				.path("camel/hellowithtransform").build();

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Body tranformed"));	
	}
}
