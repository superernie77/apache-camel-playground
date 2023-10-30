package com.wds.example.camel.cameldemo.processor;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithProcessor extends RouteBuilder {

	private Processor nameProcessor = exchange -> exchange.getIn().setHeader("text", exchange.getIn().getHeader("text") + " processed"); 
	
	
	@Override
	public void configure() throws Exception {
		
		//@formatter:off
	/*	from("restlet:http://localhost:8085/hellowithprocessor/{text}?restletMethods=GET")
		.routeId("processor_route")
		.log("Before Processor: ${header.text}")
		.process(nameProcessor)
		.log("After Processor: ${header.text}")
		.bean("greeterBean", "sayHello(${header.text})");*/
		//@formatter:on
	}

}