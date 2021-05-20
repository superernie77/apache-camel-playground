package com.wds.example.camel.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithTransform extends RouteBuilder {

	
	@Override
	public void configure() throws Exception {
		
//		from("restlet:http://localhost:8085/hellowithtransform?restletMethods=GET")
//		.log("Vor Transform ${body}")
//		.transform(body().append("Optimus Prime").regexReplaceAll("null", ""))
//		.log("Nach Transform ${body}");
	}

}