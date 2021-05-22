package com.wds.example.camel.cameldemo.greater;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GreeterRestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("restlet:http://localhost:8085/hello/{text}?restletMethods=GET")
		.bean("greeterBean", "sayHello(${header.text})");
	}

}
