package com.wds.example.camel.cameldemo.transform;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.camel.CamelContext;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.engine.DefaultFluentProducerTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RestRouteWithTransformTest {

	private RestTemplate template = new RestTemplate();
	
	@Autowired
	private CamelContext context;
	
	
	@Test
	void testHelloWithProcessor() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8080).host("localhost")
				.path("camel/hellowithtransform").build();

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Body tranformed"));	
	}
	
	@Test
	public void testWithDirectRouteCall() {
		ProducerTemplate prodTemplate = context.createProducerTemplate();
		
		// call the transform route directly without rest call
		Object result = prodTemplate.requestBody("direct:transform", "");
		
		assertTrue(result.equals("Body tranformed"));
		
	}
}
