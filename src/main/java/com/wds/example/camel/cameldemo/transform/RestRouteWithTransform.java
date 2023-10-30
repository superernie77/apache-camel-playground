package com.wds.example.camel.cameldemo.transform;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithTransform extends RouteBuilder {

	
	@Override
	public void configure() throws Exception {
		
		//@formatter:off
	/*	from("restlet:http://localhost:8085/hellowithtransform?restletMethods=GET")
		.log("Before Transform ' ${body}'")
		.transform(body().append("Body tranformed").regexReplaceAll("null", ""))
		.log("After Transform '${body}'");*/
		//@formatter:on
	}

}