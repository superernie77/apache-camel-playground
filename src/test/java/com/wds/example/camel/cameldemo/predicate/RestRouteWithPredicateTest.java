package com.wds.example.camel.cameldemo.predicate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest
class RestRouteWithPredicateTest {

	private RestTemplate template = new RestTemplate();
	
	@Test
	void testHelloWithPredicateRout1() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8085).host("localhost")
				.path("/hellochoice").path("/{text}").buildAndExpand("route1");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Route 1 called"));	
	}
	
	@Test
	void testHelloWithPredicateRout2() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8085).host("localhost")
				.path("/hellochoice").path("/{text}").buildAndExpand("route2");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Route 2 called"));	
	}

	@Test
	void testHelloWithPredicateRout3() {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").port(8085).host("localhost")
				.path("/hellochoice").path("/{text}").buildAndExpand("default_route");

			String result = template.getForObject(uri.toUriString(), String.class);
			
			assertTrue(result.equals("Route 3 called"));	
	}

}
