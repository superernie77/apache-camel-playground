package com.wds.example.camel.cameldemo.filter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestFilterExample extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//@formatter:off
		from("restlet:http://localhost:8085/filter/{text}?restletMethods=GET")
			.log("${header.text}")
			.filter(header("text").endsWith("pass")) // request passes if it ends with "pass"
		.bean("greeterBean", "sayHello(${header.text})");
		//@formatter:on
	}

}
