package com.wds.example.camel.cameldemo.file;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class FileRouteWithTransformAndMulticast extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("file:src/data")
		.log("Call for File ${header.CamelFileName}")
		.log("Contents of the File: ${body}")
		.multicast().to("direct:log1","direct:log2");
		
		from("direct:log1")
		.routeId("Route 1")
		.log("Route 1 called with File ${header.CamelFileName} and body : ${body}");
		
		from("direct:log2")
		.routeId("Route 2")
		.log("Route 2 called with File ${header.CamelFileName} and body : ${body}");
		
	}
}
