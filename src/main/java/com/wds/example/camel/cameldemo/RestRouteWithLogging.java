package com.wds.example.camel.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithLogging extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
//		from("restlet:http://localhost:8085/hellowithlogging/{text}?restletMethods=GET")
//		.log("Call with parameter ${header.text}")
//		.bean("greeterBean", "sayHello(${header.text})");
	}

}