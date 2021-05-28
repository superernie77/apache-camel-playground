package com.wds.example.camel.cameldemo.predicate;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoutingWithPredicate extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		//@formatter:off
		from("restlet:http://localhost:8085/hellochoice/{text}?restletMethods=GET")
		 .choice()
		 	.when( e -> e.getIn().getHeader("text").equals("route1")).to("direct:log1")
		 	.when( e -> e.getIn().getHeader("text").equals("route2")).to("direct:log2")
		 	.otherwise().to("direct:log3")
		 .end();
		
		from("direct:log1")
		.routeId("Route 1")
		.log("Route 1 called")
		.transform(body().append("Route 1 called").regexReplaceAll("null", ""));
		
		from("direct:log2")
		.routeId("Route 2")
		.log("Route 2 called")
		.transform(body().append("Route 2 called").regexReplaceAll("null", ""));
		
		from("direct:log3")
		.routeId("Route 3")
		.log("Route 3 called")
		.transform(body().append("Route 3 called").regexReplaceAll("null", ""));
		//@formatter:on		
	}

}
