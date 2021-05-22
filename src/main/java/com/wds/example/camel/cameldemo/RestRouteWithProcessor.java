package com.wds.example.camel.cameldemo;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithProcessor extends RouteBuilder {

	private Processor nameProcessor = exchange -> exchange.getIn().setHeader("text", exchange.getIn().getHeader("text") + " prozessiert"); 
	
	
	@Override
	public void configure() throws Exception {
		
		from("restlet:http://localhost:8085/hellowithprocessor/{text}?restletMethods=GET")
		.routeId("meineroute")
		.log("Vor Prozessor: ${header.text}")
		.process(nameProcessor)
		.log("Nach Prozessor: ${header.text}")
		.bean("greeterBean", "sayHello(${header.text})");
	}

}