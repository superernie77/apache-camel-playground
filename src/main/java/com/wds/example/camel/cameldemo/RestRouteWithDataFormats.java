package com.wds.example.camel.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RestRouteWithDataFormats extends RouteBuilder {
	
	// needs camel-jaxb and cmm dependency in pom
	private JaxbDataFormat dataFormat = new JaxbDataFormat("com.wds.cmm");
	
	// needs camel-xstream and camel-jackson dependency in pom
	private JsonDataFormat jsonFormat = new JsonDataFormat();
	
	@Override
	public void configure() throws Exception {
	
		from("restlet:http://localhost:8080/hellotransform/?restletMethods=POST")
		.log("${body}")
		.unmarshal(dataFormat)
		.log("${body}")
		.marshal(jsonFormat)
		.log("${body}");
	
	}
}
