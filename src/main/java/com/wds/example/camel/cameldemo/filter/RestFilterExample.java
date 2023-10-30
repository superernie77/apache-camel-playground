package com.wds.example.camel.cameldemo.filter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestFilterExample extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").host("localhost").port(8080);

		//@formatter:off
		from("rest:get:filter/{text}").routeId("Rest-Filter-Route")
			.log("${header.text}")

			.filter(header("text").endsWith("pass")) // request passes if it ends with "pass"
			.bean("greeterBean", "sayHello(${header.text})");
		//@formatter:on
	}

}
