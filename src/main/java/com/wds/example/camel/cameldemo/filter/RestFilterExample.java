package com.wds.example.camel.cameldemo.filter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestFilterExample extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().contextPath("/rest").component("servlet").host("localhost").port(8080);

		//@formatter:off
		rest().get("/hello").to("direct:hello");	
			
			
		from("direct:hello").transform().constant("Hello!");
		//@formatter:on
	}

}
