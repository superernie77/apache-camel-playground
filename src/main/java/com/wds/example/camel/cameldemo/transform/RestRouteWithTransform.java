package com.wds.example.camel.cameldemo.transform;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithTransform extends RouteBuilder {

	
	@Override
	public void configure() throws Exception {
		
		rest()
		.path("/hellowithtransform")
		.produces("application/text")    
	    .get()
	    .to("direct:transform");

		
		from("direct:transform")
		.log("Before Transform ' ${body}'")
		.transform(body().append("Body tranformed").regexReplaceAll("null", ""))
		.log("After Transform '${body}'");
		
	}

}