package com.wds.example.camel.cameldemo.filter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestFilterExample extends RouteBuilder {

	@Override
	  public void configure() throws Exception {
	    restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
	    
	    rest().path("/rest").consumes("application/json").produces("application/json")
	        
	    	.get("{name}").to("bean:serviceBean?method=hello(${headers.name})")
	        
	    	.post().type(User.class).outType(User.class).to("bean:serviceBean?method=response");
	    } 

}
