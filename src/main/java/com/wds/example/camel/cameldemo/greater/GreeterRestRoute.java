package com.wds.example.camel.cameldemo.greater;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class GreeterRestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
		
		//@formatter:off
		 rest().path("/hello").produces("application/text")    
	    	.get("{text}").to("bean:greeterBean?method=sayHello(${headers.text})");
		//@formatter:on
	}

}
