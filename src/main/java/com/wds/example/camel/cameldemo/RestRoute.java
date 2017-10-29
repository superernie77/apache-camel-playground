package com.wds.example.camel.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("restlet:http://localhost:8080/hello/{text}?restletMethods=GET")
		.bean("greeterBean", "sayHello(${header.text})");
	}

}
