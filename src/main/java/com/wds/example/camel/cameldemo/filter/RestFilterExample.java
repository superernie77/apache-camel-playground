package com.wds.example.camel.cameldemo.filter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestFilterExample extends RouteBuilder {

	@Override
	  public void configure() throws Exception {
	    restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
	    
	    rest().path("/filter").consumes("application/text").produces("application/text")
	    	.get("{text}").to("direct:filter");
	    
	    from("direct:filter")
	    	.log("${header.text}")
	    	.filter(header("text").endsWith("pass")) // request passes if it ends with "pass"
	    	.bean("greeterBean", "sayHello(${header.text})");
	    } 

}
